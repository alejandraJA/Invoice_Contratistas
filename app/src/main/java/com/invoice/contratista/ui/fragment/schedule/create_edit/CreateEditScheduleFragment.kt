package com.invoice.contratista.ui.fragment.schedule.create_edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentCreateEditScheduleBinding
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.Utils.getAddressObject
import com.invoice.contratista.utils.Utils.getDate
import com.invoice.contratista.utils.Utils.getHour
import com.invoice.contratista.utils.Utils.getStateSchedule
import com.invoice.contratista.utils.Utils.getTextWithValidation
import com.invoice.contratista.utils.Utils.isNotEmpty
import com.invoice.contratista.utils.Utils.setText
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CreateEditScheduleFragment : Fragment() {

    private lateinit var binding: FragmentCreateEditScheduleBinding
    private lateinit var viewModel: CreateEditScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateEditScheduleBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[CreateEditScheduleViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.getState()) {
            binding.buttonComplete.isEnabled = false
        }

        viewModel.schedule.observe(viewLifecycleOwner) {
            binding.layoutDate.setText(it.date.getDate())
            binding.layoutHour.setText(it.date.getHour())
            binding.layoutNote.setText(it.note)
            if (it.state.getStateSchedule() == Constants.StateSchedule.Atendido) {
                binding.layoutDate.isEnabled = false
                binding.layoutHour.isEnabled = false
                binding.buttonComplete.isEnabled = false
            }
        }
        viewModel.address.observe(viewLifecycleOwner) {
            binding.layoutAddress.address = it
        }

        binding.layoutDate.editText!!.setRawInputType(InputType.TYPE_NULL)
        binding.layoutDate.editText!!.setOnKeyListener(null)
        binding.layoutDate.editText!!.setOnClickListener {
            val datePicker = MaterialDatePicker
                .Builder
                .datePicker()
                .setTitleText(getString(R.string.select_date))
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
            datePicker.show(childFragmentManager, getString(R.string.select_date))
            datePicker.addOnPositiveButtonClickListener {
                val timeZoneUTC: TimeZone = TimeZone.getDefault()
                val offsetFromUTC: Int = timeZoneUTC.getOffset(Date().time) * -1
                val simpleFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)
                val date = Date(it + offsetFromUTC)
                binding.layoutDate.setText(simpleFormat.format(date))
            }
        }

        binding.layoutHour.editText!!.setRawInputType(InputType.TYPE_NULL)
        binding.layoutHour.editText!!.setOnKeyListener(null)
        binding.layoutHour.editText!!.setOnClickListener {
            val timePicker = MaterialTimePicker
                .Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitleText(getString(R.string.select_hour))
                .build()
            timePicker.show(childFragmentManager, getString(R.string.select_hour))
            timePicker.addOnPositiveButtonClickListener {
                binding.layoutHour.setText("${timePicker.hour}:${timePicker.minute}")
            }
        }

        binding.apply {
            buttonAddEvent.setOnClickListener {
                val date = layoutDate.getTextWithValidation()
                val hour = layoutHour.getTextWithValidation()
                val note = layoutNote.getTextWithValidation()
                val address = layoutAddress.getAddressObject()
                if (date.isNotEmpty() && hour.isNotEmpty() && note.isNotEmpty()
                    && address.isNotEmpty()
                ) {
                    viewModel.setSchedule(date = "$date $hour", note = note, address = address)
                    findNavController().popBackStack()
                }
            }
            buttonComplete.setOnClickListener {
                viewModel.updateStateSchedule()
                findNavController().popBackStack()
            }
        }
    }

}