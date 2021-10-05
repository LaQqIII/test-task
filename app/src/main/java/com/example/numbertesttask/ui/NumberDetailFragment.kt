package com.example.numbertesttask.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.numbertesttask.R
import com.example.numbertesttask.databinding.FragmentNumberDetailBinding

class NumberDetailFragment : Fragment(R.layout.fragment_number_detail) {

    private val args: NumberDetailFragmentArgs by navArgs()

    private var viewBinding: FragmentNumberDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentNumberDetailBinding.bind(view)
        initView(args.number)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initView(number: Int) {
        viewBinding?.let {
            with(it) {
                numberTextView.text =
                    requireContext().getString(R.string.numberIs, number.toString())
                numberIsEvenTextView.text =
                    if (number % 2 == 0)
                        requireContext().getString(R.string.numberIsEven)
                    else
                        requireContext().getString(R.string.numberIsOdd)
            }
        }
    }
}