package com.mcssoft.racedayreminder.ui.dialog

import android.os.Bundle
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.interfaces.IDeleteAll

/**
 * A simple Yes/No type dialog as to whether to bulk delete all RaceDetails entered.
 */
class DeleteAllDialog(private var delAll: IDeleteAll) : DialogFragment(), DialogInterface.OnClickListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle(getString(R.string.title_delete_all))
        dialog.setMessage(getString(R.string.message_delete_all))
        dialog.setPositiveButton(getString(R.string.lbl_ok), this)
        dialog.setNegativeButton(getString(R.string.lbl_cancel), this)
        return dialog.create()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        when(which) {
            DialogInterface.BUTTON_POSITIVE -> {
                delAll.deleteAll(true)
                this.dialog!!.cancel()
            }
        }
    }
}