package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.databinding.EditFragmentBinding
import com.mcssoft.racedayreminder.interfaces.ITimePicker
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.android.ext.android.bind

class EditFragment: Fragment(), View.OnClickListener, ITimePicker {

    //<editor-fold default state="collapsed" desc="Region: Lifecycle">
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = EditFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDisplayElements()
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Utility">
    /**
     * Setup base UI elements.
     * @Note Called by the initialiseUI() method.
     */
    private fun setupDisplayElements() {
        // Hide the bottom nav view.
        (activity?.findViewById(R.id.id_bottom_nav_view) as BottomNavigationView).visibility = View.GONE
        // Get the toolbar.
        toolBar = activity?.id_toolbar as Toolbar
        // Set other view components.
        tvLoc = binding.idTvLoc
        tvLoc.setOnClickListener(this)
        tvCode = binding.idTvCode
        tvCode.setOnClickListener(this)
        tvNum = binding.idTvNum
        tvNum.setOnClickListener(this)
        tvSel = binding.idTvSel
        tvSel.setOnClickListener(this)
        tvSel2 = binding.idTvSel2
        tvSel2.setOnClickListener(this)
        tvSel3 = binding.idTvSel3
        tvSel3.setOnClickListener(this)
        tvSel4 = binding.idTvSel4
        tvSel4.setOnClickListener(this)
        btnTime = binding.idBtnTime
        btnTime.setOnClickListener(this)

//        viewStub = binding.idViewStub  // <- this shows as an error but still compiles etc.
        viewStub = activity?.findViewById(R.id.id_view_stub) as ViewStub

    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: OnClickListener">
    override fun onClick(view: View) {
        when(view.id) {
            tvLoc.id -> {
                viewStub.layoutResource = R.layout.kbd_location
                viewStub.inflate()
                Toast.makeText(activity, "Location selected.", Toast.LENGTH_SHORT).show() }
        }
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: ITimePicker">
    override fun setTime(time: Long) {
        // TODO("Not yet implemented")
    }
    //</editor-fold>

    private lateinit var binding: EditFragmentBinding//? = null

    private lateinit var toolBar: Toolbar        // fragment's toolbar.

    private lateinit var tvLoc: TextView
    private lateinit var tvCode: TextView
    private lateinit var tvNum: TextView
    private lateinit var tvSel: TextView
    private lateinit var tvSel2: TextView
    private lateinit var tvSel3: TextView
    private lateinit var tvSel4: TextView

    private lateinit var btnTime: Button

    private lateinit var viewStub: ViewStub

}