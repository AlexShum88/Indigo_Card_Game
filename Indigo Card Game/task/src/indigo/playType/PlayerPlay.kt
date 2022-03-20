package indigo.playType

import indigo.Player
import indigo.Table

class PlayerPlay(
    override val player: Player,
    override val table: Table
) : Play, Listen, PlayCard {

    override fun execute() {
        val hand = player.showCards()
        println("Choose a card to play (1-${hand.lastIndex + 1}):")
        val ans = userListen()
        if (ans !in "1".."${hand.lastIndex + 1}") this.execute()
        var ind = 0
        try {
            ind = ans.toInt()
        } catch (e: Exception) {
        }

        if (ind in 1..hand.lastIndex + 1) {
            playCard(player, ind - 1)
        }
    }


}