package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.databinding.MainFragmentBinding
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.observer.RaceListObserver
import kotlinx.android.synthetic.main.main_activity.view.*
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null

    private val raceViewModel: RaceViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        // Set toolbar.
//        binding!!.root.id_toolbar.title = getString(R.string.title_race_day)
        // Set for menu.
        setHasOptionsMenu(true)
        // Set the view model and observe.
        setViewModel()
//        // Do file download if applicable.
//        setForDownload()
        // Set adapter.
//        raceAdapter = RaceDetailsAdapter(this)
        // Set recycler view.
//        setRecyclerView()
        // If bottom nav view was previously hidden by a New or Edit etc, then show again.
//        val bottomNavView = activity?.id_bottom_nav_view
//        if(bottomNavView?.visibility == View.GONE) {
//            bottomNavView.visibility = View.VISIBLE
//        }
        Log.d("TAG","MainFragment.onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(RaceViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    /**
     * Setup the RaceViewModel and related observer.
     */
    private fun setViewModel() {
//        raceViewModel.getRacesLD()
//            .observe(viewLifecycleOwner, RaceListObserver(raceViewModel))
    }

    private fun setForDownload() {
        // TBA
    }
}