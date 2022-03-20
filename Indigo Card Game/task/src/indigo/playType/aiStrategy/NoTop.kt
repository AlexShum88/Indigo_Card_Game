package indigo.playType.aiStrategy

import indigo.Card

class NoTop(candidates: Map<Int, Card>) : SuperForAiStrategy(candidates) {
    override fun playCard(): Int {

        return filterBySuitAndRankAndRandomize()
    }


}
