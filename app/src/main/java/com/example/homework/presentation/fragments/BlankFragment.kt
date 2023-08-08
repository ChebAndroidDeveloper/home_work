package com.example.homework.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework.R
import com.example.homework.databinding.FragmentBlankBinding
import com.google.android.material.chip.Chip

const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null

    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonThird.setOnClickListener{
            findNavController().navigate(R.id.action_blankFragment_to_FirstFragment)
        }

        val chipGroup = binding.chipGroup
        val addChip = binding.addChip

        addChip.setOnClickListener {
            val editText = EditText(requireContext())
            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("Введите текст чипа")
                .setView(editText)
                .setPositiveButton("OK") { _, _ ->
                    val chip = Chip(requireContext())
                    chip.text = editText.text
                    chip.isCloseIconVisible = true
                    chip.setOnCloseIconClickListener { chipGroup.removeView(chip) }
                    chipGroup.addView(chip)
                }
                .setNegativeButton("Отмена", null)
                .create()
            dialog.show()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}