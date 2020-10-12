package com.mcssoft.racedayreminder.interfaces

/**
 * An interface between the EditFragment and the TimePickDialog. The EditFragment implements the
 * interface and a reference is passed in the dialog's constructor.
 */
interface ITimePicker {

    /**
     * Set the time (in mSec).
     * @param time: The time in mSec.
     * @param hour: The hour value.
     * @param minute: The minute value.
     *
     */
    fun setTime(time: Long, hour: Int, minute: Int)
}