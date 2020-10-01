package com.mcssoft.racedayreminder.ui.dialog.keyboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mcssoft.racedayreminder.databinding.KbdLocationBinding
import com.mcssoft.racedayreminder.interfaces.IKeyboard

class KbdLocationDialog(private var iKeyboard: IKeyboard): KbdDialogBase() {

    companion object {
        const val TAG = "KbdLocationDialog"
    }

    //<editor-fold default state="collapsed" desc="Region: Lifecycle">
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = KbdLocationBinding.inflate(inflater, container, false)
        return binding.root
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Click Listener">
    override fun onClick(view: View) {
        when(view.id) {
            btnLocA.id -> value = "A"
            btnLocB.id -> value = "B"
            btnLocC.id -> value = "C"
            btnLocD.id -> value = "D"
            btnLocE.id -> value = "E"
            btnLocF.id -> value = "F"
            btnLocI.id -> value = "I"
            btnLocL.id -> value = "L"
            btnLocM.id -> value = "M"
            btnLocN.id -> value = "N"
            btnLocO.id -> value = "O"
            btnLocP.id -> value = "P"
            btnLocQ.id -> value = "Q"
            btnLocS.id -> value = "S"
            btnLocT.id -> value = "T"
            btnLocV.id -> value = "V"
            btnLocX.id -> value = "X"
            btnLocZ.id -> value = "Z"
        }
        iKeyboard.setKbdLocValue(value)
        dismiss()
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Utility">
    override fun setupDisplayElements() {
        btnLocA = binding.idBtnLocA
        btnLocA.setOnClickListener(this)
        btnLocB = binding.idBtnLocB
        btnLocB.setOnClickListener(this)
        btnLocC = binding.idBtnLocC
        btnLocC.setOnClickListener(this)
        btnLocD = binding.idBtnLocD
        btnLocD.setOnClickListener(this)
        btnLocE = binding.idBtnLocE
        btnLocE.setOnClickListener(this)
        btnLocF = binding.idBtnLocF
        btnLocF.setOnClickListener(this)
        btnLocI = binding.idBtnLocI
        btnLocI.setOnClickListener(this)
        btnLocL = binding.idBtnLocL
        btnLocL.setOnClickListener(this)
        btnLocM = binding.idBtnLocM
        btnLocM.setOnClickListener(this)
        btnLocN = binding.idBtnLocN
        btnLocN.setOnClickListener(this)
        btnLocO = binding.idBtnLocO
        btnLocO.setOnClickListener(this)
        btnLocP = binding.idBtnLocP
        btnLocP.setOnClickListener(this)
        btnLocQ = binding.idBtnLocQ
        btnLocQ.setOnClickListener(this)
        btnLocS = binding.idBtnLocS
        btnLocS.setOnClickListener(this)
        btnLocT = binding.idBtnLocT
        btnLocT.setOnClickListener(this)
        btnLocV = binding.idBtnLocV
        btnLocV.setOnClickListener(this)
        btnLocX = binding.idBtnLocX
        btnLocX.setOnClickListener(this)
        btnLocZ = binding.idBtnLocZ
        btnLocZ.setOnClickListener(this)
    }
    //</editor-fold>

    //<editor-fold default state="collapsed" desc="Region: Private vars">
    private lateinit var binding: KbdLocationBinding

    private lateinit var btnLocA: Button
    private lateinit var btnLocB: Button
    private lateinit var btnLocC: Button
    private lateinit var btnLocD: Button
    private lateinit var btnLocE: Button
    private lateinit var btnLocF: Button
    private lateinit var btnLocI: Button
    private lateinit var btnLocL: Button
    private lateinit var btnLocM: Button
    private lateinit var btnLocN: Button
    private lateinit var btnLocO: Button
    private lateinit var btnLocP: Button
    private lateinit var btnLocQ: Button
    private lateinit var btnLocS: Button
    private lateinit var btnLocT: Button
    private lateinit var btnLocV: Button
    private lateinit var btnLocX: Button
    private lateinit var btnLocZ: Button

    private lateinit var value: String
    //</editor-fold>
}