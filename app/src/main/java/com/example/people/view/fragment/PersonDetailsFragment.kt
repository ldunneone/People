package com.example.people.view.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.people.databinding.FragmentPersonDetailsBinding
import com.example.people.viewmodel.PersonDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class PersonDetailsFragment : Fragment() {
    val viewModel by viewModel<PersonDetailsViewModel>()

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPersonDetailsBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        val characterProperty = PersonDetailsFragmentArgs.fromBundle(arguments!!).selectedPerson

        binding.viewModel = viewModel
        viewModel.setPerson(characterProperty)

        return binding.root

    }
}