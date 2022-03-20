package indigo.Dialogs

import indigo.Player

class WinDialog(val winPlayer: Player, val anotherPlayer: Player) : Dialog {
    private var plName = if (winPlayer.isAi) {
        "Computer"
    } else "Player"
    private val aiPlayer = if (winPlayer.isAi) winPlayer else anotherPlayer
    private val userPlayer = if (!winPlayer.isAi) winPlayer else anotherPlayer
    override fun execute() {
        println("$plName wins cards")
        score()
    }

    fun score() {
        println("Score: Player ${userPlayer.score} - Computer ${aiPlayer.score}")
        println("Cards: Player ${userPlayer.winCards.size} - Computer ${aiPlayer.winCards.size}")
    }

}