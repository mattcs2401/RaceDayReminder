package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.adapter.RaceDayAdapter
import com.mcssoft.racedayreminder.databinding.MainFragmentBinding
import com.mcssoft.racedayreminder.model.RaceViewModel
import com.mcssoft.racedayreminder.observer.RaceListObserver
import com.mcssoft.racedayreminder.utility.BackPressCB
import com.mcssoft.racedayreminder.utility.Constants
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    // DI.
    private val raceViewModel: RaceViewModel by viewModel()
    private val raceAdapter: RaceDayAdapter by inject()
    private val backPressCallback: BackPressCB by inject()

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)

        refreshMenuItem = menu.findItem(R.id.id_mnu_refresh_interval)
        deleteMenuItem = menu.findItem(R.id.id_mnu_delete_all)
        notifyMenuItem = menu.findItem(R.id.id_mnu_notifications)

        if(!raceViewModel.isEmpty()) {
            setToolbarIcons(true)
        } else {
            setToolbarIcons(false)
        }

        Log.d("TAG","MainFragment.onCreateOptionsMenu")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /* Note: Delete All is Preference controlled. Icon may not display even if the recycler view
                 has items. */
        when(item.itemId) {
            R.id.id_mnu_delete_all -> {
                if (!raceViewModel.isEmpty()) {
//                    iDialogManager.showDialog(
//                        Constants.DIALOG_DELETE_ALL, null,
//                        activity?.supportFragmentManager!!.beginTransaction(), this)
                }
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Utility - Toolbar.">
    private fun setToolbarIcons(setIcon: Boolean) {
        setRefreshIntervalMenuItem(setIcon)
        setDeleteMenuItem(setIcon)
        setNotifyMenuItem(setIcon)
    }

    /**
     * ToolBar: Delete (all) option.
     */
    private fun setDeleteMenuItem(setDelete: Boolean) {
//        if(setDelete) {
//            // Only set if the Preference is enabled to start with.
//            if(iRacePreferences.getRaceBulkDelete()) {
//                // The Delete all preference is enabled.
//                deleteMenuItem.isVisible = true
//            }
//        } else {
//            if(deleteMenuItem.isVisible) {
//                deleteMenuItem.isVisible = false
//            }
    }

    /**
     * Toolbar: Notifications being sent indicator.
     */
    private fun setNotifyMenuItem(doSetNotify: Boolean) {
//        if(doSetNotify) {
//            if (iRacePreferences.getRaceNotifyPost()) {
//                // The notifications preference is enabled.
//                notifyMenuItem.isVisible = true
//            }
//        } else {
//            notifyMenuItem.isVisible = false
//        }
    }

    /**
     * ToolBar: Refresh interval indicator.
     * @Note: Set by the DataMessage EventBus type (from RaceDetailsAdapter setData() method).
     */
    private fun setRefreshIntervalMenuItem(doSetRefresh: Boolean) {
//        if(doSetRefresh) {
//            if (iRacePreferences.getRefreshInterval()) {
//                // Preference is set.
//                refreshMenuItem.isVisible = true
//                val interval = iRacePreferences.getRefreshIntervalVal()
//                val rootView = refreshMenuItem.actionView as FrameLayout
//                val redCircle = rootView.findViewById<FrameLayout>(R.id.id_view_refresh_red_circle)
//                val intervalTextView = rootView.findViewById<TextView>(R.id.id_tv_refresh_period)
//                intervalTextView.text = interval.toString()
//                redCircle.visibility = View.VISIBLE
//
//                // Set alarm.
////                RaceAlarm.getInstance(activity!!).setAlarm(interval.toLong())
//                iRaceAlarm.setAlarm(interval.toLong())
//            }
//        } else {
//            refreshMenuItem.isVisible = false
//            // Cancel alarm.
//            iRaceAlarm.cancelAlarm()
//        }
    }
    //</editor-fold>

    private fun registerReceivers() {
        // TODO("Not yet implemented")
    }

    private fun unRegisterReceivers() {
        // TODO("Not yet implemented")
    }

    // View binding.
    private lateinit var binding: MainFragmentBinding      // view binding.
    private lateinit var recyclerView: RecyclerView        // implemented by view binding.

    // Menu items.
    private lateinit var refreshMenuItem: MenuItem
    private lateinit var deleteMenuItem: MenuItem
    private lateinit var notifyMenuItem: MenuItem
}