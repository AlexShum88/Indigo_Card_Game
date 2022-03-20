package indigo.playType.aiStrategy

import indigo.Card

class NoCandidate(
    private val hand: List<Card>,
    private val mapHand: MutableMap<Int, Card> = mutableMapOf()
) : SuperForAiStrategy(mapHand) {

    override fun playCard(): Int {
        for ((index, card) in hand.withIndex()) {
            mapHand[index] = card
        }
        return filterBySuitAndRankAndRandomize()
    }

}
