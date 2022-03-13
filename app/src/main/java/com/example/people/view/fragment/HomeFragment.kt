package com.example.people.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.people.R
import com.example.people.data.Person
import com.example.people.util.LoadingState
import com.example.people.view.adapter.PersonAdapter
import com.example.people.view.adapter.PersonClick
import com.example.people.viewmodel.PersonViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(){

    private val personViewModel: PersonViewModel by viewModel()
    private lateinit var personAdapter: PersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseRecyclerView(view)
        setupObservers()
    }


    private fun initialiseRecyclerView(view: View){
        personAdapter = PersonAdapter(PersonClick {
            personViewModel.displayPersonDetails(it)
        })
        view.findViewById<RecyclerView>(R.id.person_data_recyclerview).apply {
            adapter = personAdapter
        }

        personViewModel.navigateToSelectedPerson.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToPersonDetailsFragment(
                        Person(
                            it.avatar,
                            it.createdAt,
                            it.email,
                            it.favouriteColor,
                            it.firstName,
                            it.id,
                            it.jobTitle,
                            it.lastName,
                            it.latitude,
                            it.longitude,
                            it.phone
                        )
                    )
                )


                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                personViewModel.displayPropertyDetailsComplete()
            }
        })
    }


    private fun setupObservers(){

        personViewModel.personData.observe(viewLifecycleOwner) {
            if(it != null) {
                personAdapter.personDataList = it.personResponse
            }
        }

        personViewModel.loadingState.observe(viewLifecycleOwner) {
            when(it.status){
                LoadingState.Status.RUNNING -> showSnackBar("Loading Person Data")
                LoadingState.Status.SUCCESS -> showSnackBar("Data Loaded Successfully")
                LoadingState.Status.FAILED -> showSnackBar("Unable to Load Person Data")
            }
        }
    }


    private fun showSnackBar(text: String){
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).show()
    }

}