package com.devventure.whatdidilearn.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import com.devventure.whatdidilearn.databinding.FragmentNewItemBinding
import com.devventure.whatdidilearn.entities.LearnedItem
import com.devventure.whatdidilearn.view.adapters.UnderstandingLevel
import com.devventure.whatdidilearn.viewmodel.LearnedItemViewModel
import com.google.android.material.textfield.TextInputLayout
import org.koin.android.ext.android.bind

class NewLearnedItemFragment : Fragment() {
    private var _binding: FragmentNewItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LearnedItemViewModel by sharedViewModel()

    private lateinit var tilTitle: TextInputLayout
    private lateinit var tilDescription: TextInputLayout
    private lateinit var rgPriority: RadioGroup


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewItemBinding.inflate(layoutInflater, container, false)
        tilTitle = binding.tilTitle
        tilDescription = binding.tilDescription
        rgPriority = binding.rgPriority
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureSaveBtn()
    }

    private fun configureSaveBtn() {
        binding.btnSave.setOnClickListener {
            if (validateFields())
                saveNewItem()
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true
        if (tilTitle.editText?.text.isNullOrEmpty()) {
            isValid = false
            tilTitle.error = "Error"
        }

        if (tilDescription.editText?.text.isNullOrEmpty()) {
            isValid = false
            tilDescription.error = "Error"
        }

        if (rgPriority.checkedRadioButtonId == -1) {
            isValid = false
            Toast.makeText(requireContext(), "Selecione um nível", Toast.LENGTH_SHORT).show()
        }
        return isValid
    }

    private fun saveNewItem() {
        val learnedItem = LearnedItem(name = tilTitle.editText?.text.toString(), description = tilDescription.editText?.text.toString(), understandingLevel = getSelectedLevel())
        viewModel.insertItem(learnedItem)
        findNavController().popBackStack()
    }

    private fun getSelectedLevel() : UnderstandingLevel {
        lateinit var understandingLevel: UnderstandingLevel
        when(binding.rgPriority.checkedRadioButtonId) {
            binding.rbLow.id -> understandingLevel = UnderstandingLevel.LOW
            binding.rbMedium.id -> understandingLevel = UnderstandingLevel.MEDIUM
            binding.rbHigh.id -> understandingLevel = UnderstandingLevel.HIGH
        }
        return understandingLevel
    }

}