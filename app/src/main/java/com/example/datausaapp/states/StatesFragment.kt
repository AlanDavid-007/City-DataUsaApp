package com.example.datausaapp.states

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datausaapp.R
import com.example.datausaapp.data.api.ApiClientInstance
import com.example.datausaapp.data.repository.StateRepository
import com.example.datausaapp.view.FragmentStateViewModel


class StatesFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var viewModel: FragmentStateViewModel.RecipeDetailsViewModel
    private var getApiInstance = ApiClientInstance.retrofitInstance
    private var repository = StateRepository(getApiInstance)


    private var cityAdapter = StatesAdapter {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, EditStatesFragment(it) {
                viewModel.updateState(it)
            })
            ?.addToBackStack(null)
            ?.commit()
    }
    lateinit var ctCv: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ctCv = view.findViewById(R.id.rv_citys)

        setupViewModel()
        setRecyclerView()


        viewModel.states.observe(requireActivity()) {
            cityAdapter.setupRecycleView(it)
        }
        viewModel.states
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_city, container, false)


    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            FragmentStateViewModel.RecipeDetailsViewModel.RecipeDetailViewModelFactory(
                repository
            )
        ).get(FragmentStateViewModel.RecipeDetailsViewModel::class.java)
    }

    private fun setRecyclerView() {

        val layoutManager = LinearLayoutManager(context)
        val search = activity?.findViewById<SearchView>(R.id.search_textFilter)
        search?.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES)
        search?.setOnQueryTextListener(this)




        ctCv.layoutManager = layoutManager
        ctCv.adapter = cityAdapter
        DividerItemDecoration(
            requireContext(),
            layoutManager.orientation
        ).apply {

            ctCv.addItemDecoration(this)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        cityAdapter.filter.filter(query)

        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        cityAdapter.filter.filter(newText)


        return false
    }

}