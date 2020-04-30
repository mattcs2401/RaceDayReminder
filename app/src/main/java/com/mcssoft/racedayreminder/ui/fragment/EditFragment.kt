package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mcssoft.racedayreminder.databinding.EditFragmentBinding

class EditFragment: Fragment() {

    private var binding: EditFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = EditFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }
}