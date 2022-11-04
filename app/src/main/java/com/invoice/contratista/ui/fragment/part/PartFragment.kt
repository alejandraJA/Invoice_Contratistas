package com.invoice.contratista.ui.fragment.part

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.relations.Product
import com.invoice.contratista.databinding.FragmentPartBinding
import com.invoice.contratista.ui.fragment.part.adapter.TaxAdapter
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem.Companion.toTaxItem
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class PartFragment : Fragment() {

    private lateinit var binding: FragmentPartBinding
    private lateinit var taxAdapter: TaxAdapter
    private lateinit var viewModel: PartViewModel
    private val taxList = mutableListOf<TaxItem>()
    private val partData = PartData()

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
            binding.textTotal.text = partData.getTotal(tax)
        }

        binding.apply {
            autoCompleteProduct.setAdapter(namesAdapter)
            recyclerTax.setHasFixedSize(true)
            recyclerTax.adapter = taxAdapter
            buttonLess.setOnClickListener {
                partData.changeQuatity(
                    PartData.Operator.Res,
                    taxAdapter
                ) { subTotal, quantity, totalGain ->
                    setData(subTotal, quantity, totalGain)
                }
            }
            buttonAdd.setOnClickListener {
                partData.changeQuatity(
                    PartData.Operator.Sum,
                    taxAdapter
                ) { subTotal, quantity, totalGain ->
                    setData(subTotal, quantity, totalGain)
                }
            }
        }

        viewModel.apply {
            newPart.observe(viewLifecycleOwner) { part ->
                partData.partNumber = part.budgetNumber + 1
                binding.textTitleNumber.text = partData.partNumber.toString()
                namesList.clear()
                part.productsList.forEach { product -> namesList.add(product.description) }
                namesAdapter.notifyDataSetChanged()
                binding.autoCompleteProduct.setOnItemClickListener { _, _, position, _ ->
                    loadProduct(part.productsList[position].id)
                }
            }
            oldPart.observe(viewLifecycleOwner) { part ->
                partData.partNumber = part.partEntity.number
                binding.textTitleNumber.text = partData.partNumber.toString()
                binding.autoCompleteProduct.setText(part.product.product!!.description)
                partData.quantity = part.partEntity.quantity
                setProduct(part.product)
            }
        }
    }

    private fun setData(subTotal: String, quantity: String, totalGain: String) {
        binding.apply {
            textSubtotal.text = subTotal
            textQuantity.text = quantity
            textTotalGain.text = totalGain
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadProduct(id: String) {
        viewModel.getProduct(id).observe(viewLifecycleOwner) {
            setProduct(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setProduct(product: Product) {
        taxList.clear()
        partData.getPrices(
            product.product!!.price,
            product.product.gain,
            taxAdapter
        ) { price, gain, discount, subTotal, quantity, totalGain ->
            binding.apply {
                textPrice.text = price
                textGain.text = gain
                textDiscount.text = discount
            }
            setData(subTotal, quantity, totalGain)
        }
        if (product.localTaxes != null) product.localTaxes.forEach { tax ->
            taxList.add(
                tax.toTaxItem(
                    partData.subTotal
                )
            )
        }
        if (product.taxes != null) product.taxes.forEach { tax -> taxList.add(tax.toTaxItem(partData.subTotal)) }
        if (taxList.isNotEmpty()) taxAdapter.notifyDataSetChanged()
        binding.buttonSave.setOnClickListener {
            viewModel.setPart(
                PartEntity(
                    UUID.randomUUID().toString(),
                    partData.partNumber,
                    "",
                    product.product.id,
                    partData.quantity,
                    partData.discount,
                )
            )
            findNavController().popBackStack()
        }
    }

}