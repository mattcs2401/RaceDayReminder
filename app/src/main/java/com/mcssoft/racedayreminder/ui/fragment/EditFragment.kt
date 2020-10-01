package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.databinding.EditFragmentBinding
import com.mcssoft.racedayreminder.interfaces.IKeyboard
import com.mcssoft.racedayreminder.interfaces.ITimePicker
import com.mcssoft.racedayreminder.ui.dialog.keyboard.KbdLocationDialog
import com.mcssoft.racedayreminder.ui.dialog.keyboard.KbdCodeDialog
import kotlinx.android.synthetic.main.main_activity.*

class EditFragment: Fragment(), View.OnClickListener, ITimePicker, IKeyboard {

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
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: OnClickListener">
    override fun onClick(view: View) {
        val bp = ""
        when(view.id) {
            tvLoc.id -> {
                KbdLocationDialog(this).show(requireActivity().supportFragmentManager, KbdLocationDialog.TAG)
            }
            tvCode.id -> {
                KbdCodeDialog(this).show(requireActivity().supportFragmentManager, KbdCodeDialog.TAG)
            }
        }
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: ITimePicker">
    override fun setTime(time: Long) {
        // TODO("Not yet implemented")
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: IKeyboard">
    override fun setKbdLocValue(value: String) {
        tvLoc.text = value
    }

    override fun setKbdCodeValue(value: String) {
        tvCode.text = value
    }

    override fun setKbdNumValue(value: String) {
        tvNum.text = value
    }

    override fun setKbdSelValue(value: String) {
        tvSel.text = value
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
}