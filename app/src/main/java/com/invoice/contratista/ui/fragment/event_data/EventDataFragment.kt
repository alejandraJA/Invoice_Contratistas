package com.invoice.contratista.ui.fragment.event_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentEventBinding
import com.invoice.contratista.databinding.FragmentEventDataBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    }

}