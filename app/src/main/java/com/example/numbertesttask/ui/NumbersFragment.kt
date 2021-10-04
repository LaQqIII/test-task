package com.example.numbertesttask.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numbertesttask.R
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.databinding.FragmentNumbersBinding
import com.example.numbertesttask.extension.failure
import com.example.numbertesttask.extension.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NumbersFragment : Fragment(R.layout.fragment_numbers) {

    private var viewBinding: FragmentNumbersBinding? = null

    @Inject
    lateinit var numbersAdapter: NumbersAdapter

    private val numbersViewModel: NumbersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(numbersViewModel) {
            observe(numbers, ::renderNumbersList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentNumbersBinding.bind(view)
        viewBinding?.let { it.addNumberButton.setOnClickListener { addNumber() } }
        initializeView()
        loadNumbersList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initializeView() {
        viewBinding?.let {
            with(it.numbersRecyclerView) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = numbersAdapter
                numbersAdapter.clickListener = { number -> showNumberDetailFragment(number) }
            }
        }
    }

    private fun loadNumbersList() {
        numbersViewModel.loadNumbers()
    }

    private fun renderNumbersList(numbers: List<Number>?) {
        numbersAdapter.collection = numbers.orEmpty()
    }

    private fun handleFailure(failure: String?) {

    }

    private fun showNumberDetailFragment(number: Number) {
        val action =
            NumbersFragmentDirections.actionNumbersFragmentToNumberDetailFragment(number.value)
        findNavController().navigate(action)
    }

    private fun addNumber() {
        numbersViewModel.addRandomNumbers()
    }
}