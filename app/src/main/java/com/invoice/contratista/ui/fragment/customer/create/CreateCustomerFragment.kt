package com.invoice.contratista.ui.fragment.customer.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.relations.Customer
import com.invoice.contratista.databinding.FragmentCreateCustomerBinding
import com.invoice.contratista.utils.Utils.getTextWithValidation
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CreateCustomerFragment : Fragment() {

    private lateinit var binding: FragmentCreateCustomerBinding
    private lateinit var viewModel: CreateCustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CreateCustomerViewModel::class.java]
        binding = FragmentCreateCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val customer = Customer(
                customer = CustomerEntity(
                    id = UUID.randomUUID().toString(),
                    legal_name = binding.layoutLegalName.getTextWithValidation(),
                    tax_id = binding.layoutTaxIdentification.getTextWithValidation(),
                    tax_system = binding.layoutTaxSystem.getTextWithValidation(),
                    email = binding.layoutEmail.getTextWithValidation(),
                    phone = binding.layoutPhone.getTextWithValidation(),
                ),
                address = AddressEntity(
                    id = UUID.randomUUID().toString(),
                    street = binding.address.layoutStreet.getTextWithValidation(),
                    exterior = binding.address.layoutExterior.getTextWithValidation(),
                    interior = binding.address.layoutInterior.getTextWithValidation(),
                    neighborhood = binding.address.layoutNeighborhood.getTextWithValidation(),
                    city = binding.address.layoutCity.getTextWithValidation(),
                    municipality = binding.address.layoutMunicipality.getTextWithValidation(),
                    zip = binding.address.layoutZip.getTextWithValidation(),
                    state = binding.address.layoutState.getTextWithValidation(),
                    country = binding.address.layoutCountry.getTextWithValidation(),
                    idCustomer = "",
                )
            )
            if (customer.isNotEmpty()) viewModel.createCustomer(customer)
        }
    }

}