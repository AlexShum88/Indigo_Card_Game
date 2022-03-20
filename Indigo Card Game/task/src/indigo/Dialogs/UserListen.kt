package indigo.Dialogs

import Dialogs.ByeDialog

interface UserListen {
    var isRun: Boolean

    fun userListen(): String {
        val str = readLine()!!
        if (str == "exit") {
            isRun = false
            ByeDialog().execute()
        }
        return str
    }
}