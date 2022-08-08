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
import com.invoice.contratista.databinding.CreateCustomerFragmentBinding
import com.invoice.contratista.utils.Utils.getText
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CreateCustomerFragment : Fragment() {

    private lateinit var binding: CreateCustomerFragmentBinding
    private lateinit var viewModel: CreateCustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CreateCustomerViewModel::class.java]
        binding = CreateCustomerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val customer = Customer(
                customer = CustomerEntity(
                    id = UUID.randomUUID().toString(),
                    legal_name = binding.layoutLegalName.getText(),
                    tax_id = binding.layoutTaxIdentification.getText(),
                    tax_system = binding.layoutTaxSystem.getText(),
                    email = binding.layoutEmail.getText(),
                    phone = binding.layoutPhone.getText(),
                ),
                address = AddressEntity(
                    id = 1,
                    street = binding.address.layoutStreet.getText(),
                    exterior = binding.address.layoutExterior.getText(),
                    interior = binding.address.layoutInterior.getText(),
                    neighborhood = binding.address.layoutNeighborhood.getText(),
                    city = binding.address.layoutCity.getText(),
                    municipality = binding.address.layoutMunicipality.getText(),
                    zip = binding.address.layoutZip.getText(),
                    state = binding.address.layoutState.getText(),
                    country = binding.address.layoutCountry.getText(),
                    idCustomer = "",
                )
            )
            if (customer.isNotEmpty()) viewModel.createCustomer(customer)
        }
    }

}