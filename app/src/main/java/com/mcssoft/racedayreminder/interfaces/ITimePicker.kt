package com.mcssoft.racedayreminder.interfaces

/**
 * An interface between the EditFragment and the TimePickDialog. The EditFragment implements the
 * interface and a reference is passed in the dialog's constructor.
 */
interface ITimePicker {

    /**
     * Set the time (in mSec).
     * @param time: The time in mSec.
     */
    fun setTime(time: Long)
}