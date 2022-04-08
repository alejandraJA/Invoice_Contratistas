package com.invoice.contratista.ui.fragment.singUp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.SingUpFragmentBinding
import com.invoice.contratista.ui.activity.MainActivity

class SingUpFragment(private val onClick: (Boolean) -> Unit) : Fragment() {

    private lateinit var viewModel: SingUpViewModel
    private lateinit var binding: SingUpFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SingUpFragmentBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[SingUpViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAlreadyHaveAnAccount.setOnClickListener {
            onClick.invoke(true)
        }
        binding.buttonSingUp.setOnClickListener {
            requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
    }

}