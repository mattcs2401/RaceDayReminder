package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.adapter.RaceDayAdapter
import com.mcssoft.racedayreminder.databinding.MainFragmentBinding
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.observer.RaceListObserver
import com.mcssoft.racedayreminder.utility.BackPressCB
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    // DI.
    private val raceViewModel: RaceViewModel by viewModel()
    private val raceAdapter: RaceDayAdapter by inject()
    private val backPressCallback: BackPressCB by inject()

    // View binding.
    private lateinit var binding: MainFragmentBinding      // view binding.
    private lateinit var recyclerView: RecyclerView        // implemented by view binding.

    //<editor-fold default state="collapsed" desc="Region: Lifecycle">
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set toolbar. Note: synthetic used here because can't seem to use view binding.
        (activity?.id_toolbar)?.title = getString(R.string.title_race_day)

        // Set for menu.
        setHasOptionsMenu(true)

        // Set the view model and observe.
        raceViewModel.cache.observe(viewLifecycleOwner, RaceListObserver())

        // Set recyclerview.
        recyclerView = binding.idRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = raceAdapter

        // If bottom nav view was previously hidden by a New or Edit etc, then show again.
        val bottomNavView = activity?.id_bottom_nav_view
        if(bottomNavView?.visibility == View.GONE) {
            bottomNavView.visibility = View.VISIBLE
        }
        Log.d("TAG","MainFragment.onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        // Add on back pressed handler.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressCallback)
        Log.d("TAG","MainFragment.onStart")
    }

    override fun onResume() {
        super.onResume()
        registerReceivers()
    }

    override fun onPause() {
        super.onPause()
        unRegisterReceivers()
    }

    override fun onStop() {
        // Cancel alarm (method checks if previously cancelled).
//        iRaceAlarm.cancelAlarm()
        // Remove back press handler callback.
        backPressCallback.removeCallback()
        // Super.
        super.onStop()
        Log.d("TAG","MainFragment.onStop")
    }
    //</editor-fold>

    private fun registerReceivers() {
        // TODO("Not yet implemented")
    }

    private fun unRegisterReceivers() {
        // TODO("Not yet implemented")
    }
}