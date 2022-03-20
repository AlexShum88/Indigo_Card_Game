package indigo.playType.aiStrategy

import indigo.Card

class OneCandidate(private val candidates: Map<Int, Card>) : Strategy {
    override fun playCard(): Int {
        return candidates.keys.toMutableList()[0]
    }


}
