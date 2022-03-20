package indigo.Dialogs

import indigo.Player

class PlayerCardPlayDialog(
    private val player1: Player
) : Dialog {


    override fun execute() {
        if (!player1.isAi) showCardInHand()

    }


    private fun showCardInHand() {
        val sb = StringBuilder()
            .append("Cards in hand:")
        player1.showCards().forEach { sb.append("${player1.showCards().indexOf(it) + 1})$it ") }
        println(sb)
    }


}