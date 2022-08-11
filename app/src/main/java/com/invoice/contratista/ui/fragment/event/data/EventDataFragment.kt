package com.invoice.contratista.ui.fragment.event.data

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.databinding.FragmentEventDataBinding
import com.invoice.contratista.ui.fragment.event.data.adapter.DateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDataFragment : Fragment() {

    private lateinit var binding: FragmentEventDataBinding
    private lateinit var viewModel: EventDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventDataBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[EventDataViewModel::class.java]
        return binding.root
    }

    @Suppress("SENSELESS_COMPARISON")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listDates = mutableListOf<DateEntity>()
        val adapter = DateAdapter(listDates)
        binding.recyclerDate.setHasFixedSize(true)
        binding.recyclerDate.adapter = adapter
        viewModel.event.observe(viewLifecycleOwner) {
            if (it.eventEntity != null) binding.event = it.eventEntity
            if ((it.customer != null) && (it.customer.customer != null)) {
                binding.layoutCustomer.customer = it.customer.customer
                if (it.customer.address != null) {
                    val addressData = it.customer.address
                    val address = "${addressData.street}, " +
                            "${
                                if (addressData.interior.isEmpty()) 
                                    "${resources.getString(R.string.exterior)} ${addressData.exterior}"
                                else "${resources.getString(R.string.interior)} ${addressData.interior}, " +
                                        "${resources.getString(R.string.exterior)} ${addressData.exterior}"
                            }, " +
                            "${addressData.zip}, ${addressData.neighborhood}, " +
                            "${addressData.city}, ${addressData.municipality}, " +
                            "${addressData.state}, ${addressData.country}"
                    binding.layoutCustomer.textAddress.text = address
                }
            }
        }
        viewModel.dates.observe(viewLifecycleOwner) {
            listDates.clear()
            listDates.addAll(it)
            adapter.notifyDataSetChanged()
        }
        binding.layoutNote.editText!!.addTextChangedListener { text: Editable? ->
            if (text!!.isNotEmpty() && text.length > 5) viewModel.updateNote(text.toString())
        }
    }

}