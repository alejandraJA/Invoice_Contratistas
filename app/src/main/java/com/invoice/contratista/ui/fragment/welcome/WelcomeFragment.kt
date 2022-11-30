package com.invoice.contratista.ui.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.FragmentWelcomeBinding

class WelcomeFragment(private val onClick: (Boolean) -> Unit) : Fragment() {

    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]
        binding.buttonGoToLogin.setOnClickListener {
            onClick.invoke(true)
        }
        binding.buttonGoToCreateAccount.setOnClickListener {
            onClick.invoke(false)
        }
    }

}//