package indigo

import Dialogs.ByeDialog
import indigo.Dialogs.PlayerCardPlayDialog
import indigo.Dialogs.TableDialog
import indigo.Dialogs.UserListen
import indigo.Dialogs.WinDialog
import indigo.playType.AiPlay
import indigo.playType.PlayerPlay

class GameBody(
    private val player1: Player,
    private val player2: Player,
    private val table: Table
) : UserListen {
    private var wonLast: Player = Player()
    private var turnIs = Player()
    override var isRun: Boolean = true

    init {
        turnIs = if (player1.first) player1
        else player2
    }

    fun run() {
        while (isRun) {
            enafCards()
            TableDialog(table).execute()
            when (turnIs) {
                player1 -> {
                    executeTurn(player1, player2)
                }
                player2 -> {
                    executeTurn(player2, player1)
                }
            }
            isGameEnd()
        }
    }

    private fun isGameEnd() {
        if (table.deck.cards.isEmpty() && player1.cards.isEmpty() && player2.cards.isEmpty()) {
            TableDialog(table).execute()
            wonLast.getWinCards(table.cards)
            Rules().scoreForRank(wonLast, table.cards)
            Rules().scoreForNum(player1, player2)
            Rules().lastRule(player1, player2)

            WinDialog(player1, player2).score()
            ByeDialog().execute()
        }
    }

    private fun enafCards() {
        if (player1.showCards().isEmpty() && player2.showCards().isEmpty()) {
            player1.cardsToPool(table.deck.drawCard(6))
            player2.cardsToPool(table.deck.drawCard(6))
        }
    }

    fun executeTurn(first: Player, second: Player) {
        PlayerCardPlayDialog(first).execute()
        choseCardToPlay(first)
        winCards(first)
        turnIs = second

    }

    private fun choseCardToPlay(player: Player) {
        if (player.isAi) {
            AiPlay(player, table).execute()
        } else PlayerPlay(player, table).execute()
    }

    fun winCards(player: Player) {
        if (table.cards.size >= 2) {
            if (table.cards.last().rank == table.cards[table.cards.size - 2].rank
                ||
                table.cards.last().suit == table.cards[table.cards.size - 2].suit
            ) {
                player.getWinCards(table.cards)

                Rules().scoreForRank(player, table.cards)
                val anotherP = if (player == player1) player2 else player1
                WinDialog(player, anotherP).execute()
                wonLast = player
                table.cards.clear()
            }
        }
    }

}