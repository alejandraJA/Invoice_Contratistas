package com.invoice.contratista.ui.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.invoice.contratista.databinding.FragmentLoginBinding
import com.invoice.contratista.ui.activity.main.MainActivity

class LoginFragment(private val onClick: (Boolean) -> Unit) : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonDoYouHaveAnAccount.setOnClickListener {
            onClick.invoke(false)
        }
        binding.buttonLogin.setOnClickListener {
            requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
        binding.buttonLostYourPassword.setOnClickListener {
            Snackbar.make(
                it,
                "Revise su bandeja de entrada para recuperar su cuenta.",
                Snackbar.LENGTH_INDEFINITE
            ).setAction("Ir") {

            }.show()
        }
    }

}