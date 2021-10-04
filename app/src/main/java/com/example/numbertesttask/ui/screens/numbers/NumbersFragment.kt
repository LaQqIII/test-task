package com.example.numbertesttask.ui.screens.numbers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numbertesttask.R
import com.example.numbertesttask.data.Number
import com.example.numbertesttask.databinding.FragmentNumbersBinding
import com.example.numbertesttask.extension.failure
import com.example.numbertesttask.extension.observe
import com.example.numbertesttask.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_numbers.*
import javax.inject.Inject

@AndroidEntryPoint
class NumbersFragment : Fragment(R.layout.fragment_numbers) {

    private var viewBinding: FragmentNumbersBinding? = null

    @Inject
    lateinit var navigator: Navigator

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
        initializeView()
        loadNumbersList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initializeView() {
        viewBinding?.let {
            with(numbersRecyclerView) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = numbersAdapter
                numbersAdapter.clickListener = { navigator.showNumberDetail(it) }
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
}