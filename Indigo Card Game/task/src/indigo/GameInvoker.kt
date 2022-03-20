package indigo

import indigo.Dialogs.FirstPlayerDialog
import indigo.Dialogs.HalloDialog

class GameInvoker {
    val table = Table(Deck())
    val deck = table.deck
    val player = Player()
    val aiPlayer = Player(isAi = true)


    fun startGame() {
        deck.shuffle()
        player.cardsToPool(deck.drawCard(6))
        aiPlayer.cardsToPool(deck.drawCard(6))
        table.cardsToPool(deck.drawCard(4))
        HalloDialog().execute()
        FirstPlayerDialog(player, aiPlayer).execute()
        initialCardsOnTable()
        GameBody(player, aiPlayer, table).run()

    }

    private fun initialCardsOnTable() {
        val sb = StringBuilder()
            .append("Initial cards on the table: ")
        table.showCards().forEach { sb.append("$it ") }
        println(sb)
    }


}