package com.mcssoft.racedayreminder.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "race_details")
data class RaceDetails(@ColumnInfo(name = "CityCode") var cityCode: String,
                       @ColumnInfo(name = "RaceCode") var raceCode: String,
                       @ColumnInfo(name = "RaceNum")  var raceNum: String,
                       @ColumnInfo(name = "RaceSel")  var raceSel: String,
                       @ColumnInfo(name = "RaceTimeS") var raceTimeS: String) : Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long? = null    // value inserted by Room.

    // Non-mandatory or default values.
    @ColumnInfo(name = "RaceDate")
    var raceDate: String = "01/01/1970"     // Race date.
    @ColumnInfo(name = "RaceTimeL")
    var raceTimeL: Long = 0                 // Race time as Long val.
    @ColumnInfo(name = "RaceSel2")
    var raceSel2: String = ""               // 2nd Race sel (multi sel).
    @ColumnInfo(name = "RaceSel3")
    var raceSel3: String = ""               // 3rd "    "    "
    @ColumnInfo(name = "RaceSel4")
    var raceSel4: String = ""               // 4th "    "    "
    @ColumnInfo(name = "Extras")
    var raceExtras: Boolean = false         // flag to indicate RaceExtras exist.

    /**
     * Get the meeting identifier.
     * @return The meeting identifier, e.g. "BR".
     */
    fun meetingCode(): String = """$cityCode$raceCode"""

    /**
     * Get the meeting identifier and race number.
     * @return The meeting identifier with race number, e.g. "BR1".
     */
    fun meetingCodeNum(): String = """$cityCode$raceCode$raceNum"""

    //<editor-fold default state="collapsed" desc="Region: Serializable">
    override fun toString(): String {
        return "cityCode=$cityCode, raceCode=$raceCode, raceNum=$raceNum," +
                " raceSel=$raceSel, raceTimeS=$raceTimeS, id=$id, raceDate=$raceDate," +
                " raceTimeL=$raceTimeL, raceSel2=$raceSel2, raceSel3=$raceSel3," +
                " raceSel4=$raceSel4, raceExtras=$raceExtras"
    }
    //</editor-fold>

}
