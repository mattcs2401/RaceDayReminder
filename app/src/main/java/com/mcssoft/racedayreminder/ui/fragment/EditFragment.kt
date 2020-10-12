package com.mcssoft.racedayreminder.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.database.entity.Race
import com.mcssoft.racedayreminder.databinding.EditFragmentBinding
import com.mcssoft.racedayreminder.interfaces.ITimePicker
import com.mcssoft.racedayreminder.ui.dialog.TimePickDialog
import com.mcssoft.racedayreminder.utility.Constants
import kotlinx.android.synthetic.main.main_activity.*

class EditFragment: Fragment(), View.OnClickListener, ITimePicker {

    //<editor-fold default state="collapsed" desc="Region: Lifecycle">
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = EditFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set for soft keyboard.
        imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // Set other display elements.
        setupDisplayElements()
        // A 'blank' Race object.
        race = Race("", "", "", "", "")
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Listener">
    override fun onClick(view: View) {
        when(view.id) {
            etCityCode.id -> {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
            etRaceCode.id -> {}

            etRaceNum.id -> {}

            etRaceSel.id -> {}

            btnTime.id -> {
                TimePickDialog(this).show(requireActivity().supportFragmentManager, TimePickDialog.TAG)
            }
            btnSave.id -> {
                if(doValidation()) {
                    // Base set of values entered so save to dB.
                    // TODO - Implement an 'edit type' value for New, Copy or Update.
                    navigate(Constants.EDIT_RACE_NEW, race) // testing.
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: ITimePicker">
    override fun setTime(time: Long, hour: Int, minute: Int) {
        // Basically just an indicator that a time value has been selected.
        val theTime = "$hour:$minute"
        btnTime.text = theTime
        race.raceTimeS = theTime

    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Utility">
    /**
     * Setup the base UI elements.
     */
    private fun setupDisplayElements() {
        // Hide the bottom nav view.
        (activity?.findViewById(R.id.id_bottom_nav_view) as BottomNavigationView).visibility = View.GONE
        // Get the toolbar.
        toolBar = activity?.id_toolbar as Toolbar
        // Set other view components.
        etCityCode = binding.idEtCityCode
        etCityCode.setOnClickListener(this)
        etRaceCode = binding.idEtRaceCode
        etRaceCode.setOnClickListener(this)
        etRaceNum = binding.idEtRaceNum
        etRaceNum.setOnClickListener(this)
        etRaceSel = binding.idEtRaceSel
        etRaceSel.setOnClickListener(this)
        etRaceSel2 = binding.idEtRaceSel2
        etRaceSel2.setOnClickListener(this)
        etRaceSel3 = binding.idEtRaceSel3
        etRaceSel3.setOnClickListener(this)
        etRaceSel4 = binding.idEtRaceSel4
        etRaceSel4.setOnClickListener(this)
        btnTime = binding.idBtnTime
        btnTime.setOnClickListener(this)
        btnSave = binding.idBtnSave
        btnSave.setOnClickListener(this)
    }

    private fun doValidation(): Boolean {
        when {
            race.cityCode == "" -> {
                Toast.makeText(requireContext(), "City Code must be entered.", Toast.LENGTH_SHORT).show()
                return false
            }
            race.raceCode == "" -> {
                Toast.makeText(requireContext(), "Race Code must be entered.", Toast.LENGTH_SHORT).show()
                return false
            }
            race.raceNum == "" -> {
                Toast.makeText(requireContext(), "Race Num must be entered.", Toast.LENGTH_SHORT).show()
                return false
            }
            race.raceSel == "" -> {
                Toast.makeText(requireContext(), "Race Sel must be entered.", Toast.LENGTH_SHORT).show()
                return false
            }
            race.raceTimeS == "" -> {
                Toast.makeText(requireContext(), "Race Time must be entered.", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> return true
        }
    }

    /**
     * Navigate back to the MainFragment.
     * @param type: A constant indicating the type of edit performed, e.g. new, update or copy.
     * @param race: The RaceDetails object.
     */
    private fun navigate(type: Int, race: Race?) {
        val bundle = Bundle()
        when(type) {
            Constants.EDIT_RACE_UPDATE -> {
                // TBA.
                Navigation.findNavController(requireActivity(), R.id.id_nav_host_fragment)
                    .navigate(R.id.id_main_fragment)
            }
            Constants.EDIT_RACE_NEW -> {
                // This is New.
                bundle.putSerializable("key_new_arguments", race.toString())
                Navigation.findNavController(requireActivity(), R.id.id_nav_host_fragment)
                    .navigate(R.id.id_main_fragment, bundle)
            }
            Constants.EDIT_RACE_COPY -> {
                // TBA - This is Copy
            }
        }
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Private vars">
    private lateinit var binding: EditFragmentBinding//? = null

    private lateinit var imm: InputMethodManager

    private lateinit var toolBar: Toolbar        // fragment's toolbar.

    private lateinit var etCityCode: EditText
    private lateinit var etRaceCode: EditText
    private lateinit var etRaceNum: EditText
    private lateinit var etRaceSel: EditText
    private lateinit var etRaceSel2: TextView
    private lateinit var etRaceSel3: TextView
    private lateinit var etRaceSel4: TextView

    private lateinit var btnTime: Button
    private lateinit var btnSave: Button

    private lateinit var race: Race
    //</editor-fold>
}