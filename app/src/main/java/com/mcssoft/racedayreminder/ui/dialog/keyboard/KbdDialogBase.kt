package com.mcssoft.racedayreminder.ui.dialog.keyboard

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.mcssoft.racedayreminder.interfaces.IKeyboard

abstract class KbdDialogBase: DialogFragment(), View.OnClickListener {

    abstract override fun onClick(view: View)

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDisplayElements()
    }

    abstract fun setupDisplayElements()
}