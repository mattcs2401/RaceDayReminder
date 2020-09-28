package com.mcssoft.raceday.ui.dialog

import java.util.*
import android.os.Bundle
import android.app.Dialog
import android.widget.TimePicker
import android.app.TimePickerDialog
import androidx.fragment.app.DialogFragment
import com.mcssoft.racedayreminder.interfaces.ITimePicker

/**
 * Simple dialog to get a time value.
 * @param iTime: Interface reference to the EditFragment.
 */
class TimePickDialog(private val iTime: ITimePicker) : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    // TODO: https://hackernoon.com/how-to-use-new-material-date-picker-for-android-s7k32w0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var hour: Int = -1
        var minute: Int = -1
        val time = arguments?.getString("key")?.split(":")

        if(time != null) {
            // Use the values passed in the arguments.
            hour = time[0].toInt()
            minute = time[1].toInt()
        } else {
            // Use the current time as the default values for the picker
            val calendar = Calendar.getInstance()
            hour = calendar.get(Calendar.HOUR_OF_DAY)
            minute = calendar.get(Calendar.MINUTE)
        }

        // A time picker with 24 hour format.
        return TimePickerDialog(activity, this, hour, minute, true)
    }

    /**
     * TimePickerDialog.OnTimeSetListener
     */
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Get local calendar.
        val calendar = Calendar.getInstance(Locale.getDefault())
        // Set calendar values.
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        iTime.setTime(calendar.timeInMillis)
        this.dialog!!.cancel()
    }
}