package com.invoice.contratista.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.invoice.contratista.databinding.ActivityStartBinding
import com.invoice.contratista.ui.adapter.PagerAdapter
import com.invoice.contratista.ui.fragment.login.LoginFragment
import com.invoice.contratista.ui.fragment.singUp.SingUpFragment
import com.invoice.contratista.ui.fragment.welcome.WelcomeFragment

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter: PagerAdapter
        val list = listOf(
            WelcomeFragment {
                if (it) binding.pagerStart.setCurrentItem(1, true)
                else binding.pagerStart.setCurrentItem(2, true)
            },
            LoginFragment {
                binding.pagerStart.setCurrentItem(2, true)
            },
            SingUpFragment {
                binding.pagerStart.setCurrentItem(1, true)
            }
        )
        adapter = PagerAdapter(list, this)
        binding.pagerStart.adapter = adapter
    }
}