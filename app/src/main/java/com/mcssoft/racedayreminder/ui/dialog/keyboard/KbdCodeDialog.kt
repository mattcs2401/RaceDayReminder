package com.mcssoft.racedayreminder.ui.dialog.keyboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mcssoft.racedayreminder.databinding.KbdCodeBinding
import com.mcssoft.racedayreminder.interfaces.IKeyboard

class KbdCodeDialog(private var iKeyboard: IKeyboard): KbdDialogBase() {

    companion object {
        const val TAG = "KbdCodeDialog"
    }

    //<editor-fold default state="collapsed" desc="Region: Lifecycle">
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = KbdCodeBinding.inflate(inflater, container, false)
        return binding.root
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Click Listener">
    override fun onClick(view: View) {
        when(view.id) {
            btnCodeR.id -> value = "R"
            btnCodeT.id -> value = "T"
            btnCodeG.id -> value = "G"
            btnCodeS.id -> value = "S"
        }
        iKeyboard.setKbdCodeValue(value)
        dismiss()
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Utility">
    override fun setupDisplayElements() {
        btnCodeR = binding.idBtnCodeR
        btnCodeR.setOnClickListener(this)
        btnCodeT = binding.idBtnCodeT
        btnCodeT.setOnClickListener(this)
        btnCodeG = binding.idBtnCodeG
        btnCodeG.setOnClickListener(this)
        btnCodeS = binding.idBtnCodeS
        btnCodeS.setOnClickListener(this)
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Private vars">
    private lateinit var binding: KbdCodeBinding

    private lateinit var btnCodeR: Button
    private lateinit var btnCodeT: Button
    private lateinit var btnCodeG: Button
    private lateinit var btnCodeS: Button

    private lateinit var value: String
    //</editor-fold>
}