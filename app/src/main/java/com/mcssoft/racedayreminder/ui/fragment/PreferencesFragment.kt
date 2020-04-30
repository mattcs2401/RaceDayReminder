package com.mcssoft.racedayreminder.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.preference.PreferenceFragmentCompat
import com.mcssoft.racedayreminder.R

class PreferencesFragment: PreferenceFragmentCompat() {

    //<editor-fold default state="collapsed" desc="Region: Lifecycle">
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set the preference values and listeners.
        initialise()
    }
    //</editor-fold>

    private fun initialise() {
        // TBA
    }
}