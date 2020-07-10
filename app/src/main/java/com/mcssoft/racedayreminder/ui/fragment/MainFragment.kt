package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.adapter.RaceDayAdapter
import com.mcssoft.racedayreminder.databinding.MainFragmentBinding
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.observer.RaceListObserver
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.main_activity.*

class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null

    // lazy.
    private val raceViewModel: RaceViewModel by inject()

    // Set as null due to Leak Canary testing.
    private var raceAdapter: RaceDayAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set toolbar. Note: synthetic used here because can't use view binding.
        (activity?.id_toolbar)?.title = getString(R.string.title_race_day)

        // Set for menu.
        setHasOptionsMenu(true)

        // Set the view model and observe.
        raceViewModel.getRacesLD().observe(viewLifecycleOwner, RaceListObserver(raceViewModel))

        // Set adapter/recyclerview.
        raceAdapter = RaceDayAdapter()
        recyclerView = binding!!.idRecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(context)
        recyclerView!!.adapter = raceAdapter

        // If bottom nav view was previously hidden by a New or Edit etc, then show again.
        val bottomNavView = activity?.id_bottom_nav_view
        if(bottomNavView?.visibility == View.GONE) {
            bottomNavView.visibility = View.VISIBLE
        }
        Log.d("TAG","MainFragment.onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TBA - set viewmodel here ?.
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}