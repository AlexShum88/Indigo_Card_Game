package indigo.playType.aiStrategy

import indigo.Card

class SeveralCandidates(cards: Map<Int, Card>) : SuperForAiStrategy(cards) {
    override fun playCard(): Int {
        return filterBySuitAndRankAndRandomize()
    }

}
