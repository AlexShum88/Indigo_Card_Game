package indigo.playType

import indigo.Card
import indigo.Player
import indigo.Table
import indigo.playType.aiStrategy.*


class AiPlay(
    override val player: Player,
    override val table: Table
) : Play, Listen, PlayCard {
    private val context = ContextAi()
    private val topCard: Card? = if (table.cards.isNotEmpty()) table.cards.last() else null

    private val hand = player.cards

    override fun execute() {
        val candidates = chooseCandidate()

        println(hand.joinToString(" "))

        if (hand.size == 1) {
            context.setStrategy(OneCard())

        } else
            if (candidates.isEmpty()) {
                context.setStrategy(NoCandidate(hand))

            } else
                if (candidates.size == 1) {
                    context.setStrategy(OneCandidate(candidates))

                } else
                    if (candidates.size > 1 && topCard != null) {
                        context.setStrategy(SeveralCandidates(candidates))

                    } else
                        if (topCard == null) {
                            context.setStrategy(NoTop(candidates))
                        }


        println("Computer plays " + playCard(player, context.execute()))
    }

    private fun chooseCandidate(): Map<Int, Card> {
        val cards = mutableMapOf<Int, Card>()
        for ((index, card) in hand.withIndex()) {
            if (card.suit == topCard?.suit || card.rank == topCard?.rank) {
                cards[index] = card
            }
        }
        if (topCard == null) {
            for (card in hand) {
                for ((index, anotherCard) in hand.withIndex()) {
                    if (card.suit == anotherCard.suit || card.rank == anotherCard.rank) {
                        if (card.suit == anotherCard.suit && card.rank == anotherCard.rank) {
                            continue
                        }
                        cards[index] = anotherCard
                    }
                }
            }
        }
        return cards
    }
}