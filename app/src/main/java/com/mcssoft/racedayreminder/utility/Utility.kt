package com.mcssoft.racedayreminder.utility

import com.mcssoft.racedayreminder.database.entity.Race

class Utility {

    companion object {
        val tag = "something"
    }

    fun deSerialise(param: String): Race {

        val lRaceInfo = ArrayList<String>()
        val lDetails = param.split(",")

        for (value: String in lDetails) {
            val str = value.split("=")[1]
            lRaceInfo.add(str)
        }

        val race = Race(lRaceInfo[0], lRaceInfo[1], lRaceInfo[2], lRaceInfo[3], lRaceInfo[4])

        return race
    }
}
/* Others:
   race.id = lRaceInfo[5].toLong()
   race.raceDate = lRaceInfo[6]
   race.raceTimeL = lRaceInfo[7].toLong()
   race.raceSel2 = lRaceInfo[8]
   race.raceSel3 = lRaceInfo[9]
   race.raceSel4 = lRaceInfo[10]
 */