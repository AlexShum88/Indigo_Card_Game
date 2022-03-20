package Dialogs

import indigo.Dialogs.Dialog
import kotlin.system.exitProcess

class ByeDialog : Dialog {

    override fun execute() {
        try {
            throw Exception()
        } catch (e: Exception) {
            println("Game Over")
            exitProcess(-1)
        }

    }

}