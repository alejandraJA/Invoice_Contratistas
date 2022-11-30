package com.invoice.contratista.ui.fragment.part

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentPartBinding
import com.invoice.contratista.ui.fragment.part.adapter.TaxAdapter
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem
import com.invoice.contratista.ui.fragment.part.data.ProductItem
import com.invoice.contratista.utils.InputUtils.setText
import com.invoice.contratista.utils.MoneyUtils.moneyFormat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PartFragment : Fragment() {

    private lateinit var binding: FragmentPartBinding
    private lateinit var taxAdapter: TaxAdapter
    private lateinit var viewModel: PartViewModel
    private var quantity = 1
    private var discount = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPartBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[PartViewModel::class.java]
        return binding.root
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namesList = mutableListOf<String>()
        val namesListCopy = mutableListOf<ProductItem>()
        val namesAdapter = ArrayAdapter(requireContext(), R.layout.item_list, namesList)
        val taxList = mutableListOf<TaxItem>()

        taxAdapter = TaxAdapter(taxList)

        binding.apply {
            autoCompleteProduct.setAdapter(namesAdapter)
            recyclerTax.setHasFixedSize(true)
            recyclerTax.adapter = taxAdapter
            buttonLess.setOnClickListener {
                if (quantity > 1) {
                    quantity--
                    viewModel.updateQuantity(quantity)
                }
            }
            buttonAdd.setOnClickListener {
                quantity++
                viewModel.updateQuantity(quantity)
            }
            inputDiscount!!.doOnTextChanged { discountNumber, _, _, _ ->
                if (discountNumber.toString().isNotEmpty())
                    viewModel.updateDiscount(discountNumber.toString().toInt())
                else viewModel.updateDiscount(0)
            }
            autoCompleteProduct.setOnItemClickListener { _, _, position, _ ->
                viewModel.updateProduct(namesListCopy[position].id)
            }
        }

        viewModel.apply {
            productItem.observe(viewLifecycleOwner) { products ->
                namesList.clear()
                namesListCopy.clear()
                namesListCopy.addAll(products)
                products.forEach { namesList.add(it.description) }
                namesAdapter.notifyDataSetChanged()
            }
            taxes.observe(viewLifecycleOwner) {
                taxList.clear()
                taxList.addAll(it)
                taxAdapter.notifyDataSetChanged()
            }
            product.observe(viewLifecycleOwner) {
                binding.apply {
                    textProduct!!.text = it.description
                    textSku!!.text = it.sku
                    textTitleNumber.text = it.number.toString()
                    textPrice.text = it.price.moneyFormat()
                    textGain.text = it.gain.moneyFormat()
                    if (discount != it.discount) layoutDiscount.setText(it.discount.moneyFormat())
                    textTotalGain.text = it.totalGain.moneyFormat()
                    textSubTotal.text = it.subTotal.moneyFormat()
                    textTotal.text = it.total.moneyFormat()
                    textAmount.text = it.amount.moneyFormat()
                    textQuantity.text = it.quantity.toString()
                    discount = it.discount
                    quantity = it.quantity
                }
            }
        }
    }

}