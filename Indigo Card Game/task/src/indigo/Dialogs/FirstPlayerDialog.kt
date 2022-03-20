package indigo.Dialogs

import indigo.Player

class FirstPlayerDialog(
    val player: Player,
    val aiPlayer: Player,

    ) : Dialog, UserListen {

    override var isRun: Boolean = true

    override fun execute() {
        while (isRun) {
            println("Play first?")
            when (userListen()) {
                "yes" -> {
                    player.first = true
                    isRun = false
                }
                "no" -> {
                    aiPlayer.first = true
                    isRun = false
                }
                else -> {}
            }
        }
    }


}