package indigo.playType.aiStrategy

import indigo.Card
import kotlin.random.Random

abstract class SuperForAiStrategy(val cards: Map<Int, Card>) : Strategy {

    protected fun randomizer(): Int {
        val keys = cards.keys.toMutableList()
        val num = if (keys.size - 1 > 0) keys.size - 1 else keys.size
        return keys[Random.nextInt(num)]
    }

    protected fun randomizer(mapOfCards: Map<Int, Card>): Int {
        val keys = mapOfCards.keys.toMutableList()
        val num = if (keys.size - 1 > 0) keys.size - 1 else keys.size
        return keys[Random.nextInt(num)]
    }

    fun filterBySuitAndRankAndRandomize(): Int {
        val sameSuit = mutableMapOf<Int, Card>()
        val sameRank = mutableMapOf<Int, Card>()
        for (card in cards.entries) {
            for ((index, anotherCard) in cards.entries) {
                if (card.value.suit == anotherCard.suit) {
                    if (card.value == anotherCard) {
                        continue
                    }
                    sameSuit[index] = anotherCard
                }
            }
        }
        for (card in cards.entries) {
            for ((index, anotherCard) in cards.entries) {
                if (card.value.rank == anotherCard.rank) {
                    if (card.value == anotherCard) {
                        continue
                    }
                    sameRank[index] = anotherCard
                }
            }
        }

        if (sameSuit.isNotEmpty()) return randomizer(sameSuit)
        if (sameRank.isNotEmpty()) return randomizer(sameRank)
        return randomizer()
    }
}