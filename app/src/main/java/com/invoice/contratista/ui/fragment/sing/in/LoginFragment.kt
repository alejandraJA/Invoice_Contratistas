package com.invoice.contratista.ui.fragment.sing.`in`

import android.annotation.SuppressLint
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
import com.invoice.contratista.utils.InputUtils.getTextWithValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonDoYouHaveAnAccount.setOnClickListener {
                onClick.invoke(false)
            }
            buttonLogin.setOnClickListener {
                val email = layoutAddress.getTextWithValidation()
                val password = layoutPassword.getTextWithValidation()
                if (viewModel.isLogged) {
                    viewModel.updateToken(email, password) { login() }
                } else {
                    viewModel.login(email, password) { login() }
                }
            }
            buttonLostYourPassword.setOnClickListener {
                Snackbar.make(
                    it,
                    "Hi",
                    Snackbar.LENGTH_INDEFINITE
                ).setAction("Ir") {

                }.show()
            }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            binding.textError.text = resources.getString(it)
        }
    }

    private fun login() {
        requireActivity().startActivity(
            Intent(requireContext(), MainActivity::class.java)
        )
        requireActivity().finish()
    }

}