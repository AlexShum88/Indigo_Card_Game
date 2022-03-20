package indigo.playType

import indigo.Card
import indigo.Player
import indigo.Table

interface PlayCard {
    val table: Table
    fun playCard(player: Player, ind: Int): Card {
        val card = player.playCard(ind)
        table.cardsToPool(card)
        return card
    }
}
