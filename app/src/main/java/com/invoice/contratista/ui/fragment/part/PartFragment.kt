package com.invoice.contratista.ui.fragment.part

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentPartBinding
import com.invoice.contratista.ui.fragment.part.adapter.TaxAdapter
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem.Companion.toTaxItem
import com.invoice.contratista.utils.MoneyUtils.moneyFormat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PartFragment : Fragment() {

    private lateinit var binding: FragmentPartBinding
    private lateinit var taxAdapter: TaxAdapter
    private lateinit var viewModel: PartViewModel
    private val taxList = mutableListOf<TaxItem>()
    private var quantity = 1
    private var subTotal = 0.00
    private var price = 0.00
    private var discount = 0.00
    private var taxes = 0.00
    private var gain = 0.00

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPartBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[PartViewModel::class.java]
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namesList = mutableListOf<String>()
        val namesAdapter = ArrayAdapter(requireContext(), R.layout.item_list, namesList)

        taxAdapter = TaxAdapter(taxList) { tax: Double ->
            taxes += tax
            binding.textTotal.text = (subTotal + taxes).moneyFormat()
        }

        binding.apply {
            textQuantity.text = "1"
            autoCompleteProduct.setAdapter(namesAdapter)
            recyclerTax.setHasFixedSize(true)
            recyclerTax.adapter = taxAdapter
            buttonLess.setOnClickListener {
                if (quantity != 0) quantity--
                calculateSubTotalPrice()
            }
            buttonAdd.setOnClickListener {
                quantity++
                calculateSubTotalPrice()
            }
        }

        viewModel.apply {
            listProduct.observe(viewLifecycleOwner) {
                namesList.clear()
                it.forEach { product -> namesList.add(product.description) }
                namesAdapter.notifyDataSetChanged()
                binding.autoCompleteProduct.setOnItemClickListener { _, _, position, _ ->
                    getProduct(it[position].id)
                }
            }
            getNumber().observe(viewLifecycleOwner) {
                binding.textTitleNumber.text = (it + 1).toString()
            }
        }
    }

    private fun calculateSubTotalPrice() {
        taxes = 0.00
        subTotal = (quantity * price) - discount
        taxAdapter.setSubTotalPrice(subTotal)
        binding.apply {
            textSubtotal.text = subTotal.moneyFormat()
            textQuantity.text = quantity.toString()
            textTotalGain.text = (gain * quantity).moneyFormat()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getProduct(id: String) {
        viewModel.getProduct(id).observe(viewLifecycleOwner) {
            val product = it.product!!
            taxList.clear()
            price = product.price
            gain = ((product.gain * product.price) / 100)
            binding.apply {
                textPrice.text = product.price.moneyFormat()
                textGain.text = gain.moneyFormat()
                textDiscount.text = discount.moneyFormat()
            }
            calculateSubTotalPrice()
            if (it.localTaxes != null) it.localTaxes.forEach { tax ->
                taxList.add(
                    tax.toTaxItem(
                        subTotal
                    )
                )
            }
            if (it.taxes != null) it.taxes.forEach { tax -> taxList.add(tax.toTaxItem(subTotal)) }
            if (taxList.isNotEmpty()) taxAdapter.notifyDataSetChanged()
        }
    }

}