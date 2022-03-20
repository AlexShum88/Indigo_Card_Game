package indigo.playType

import Dialogs.ByeDialog

interface Listen {
    fun userListen(): String {
        val str = readLine()!!
        if (str == "exit") {
            ByeDialog().execute()
        }
        return str
    }
}