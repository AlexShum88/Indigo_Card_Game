package indigo

import java.util.*

class Deck {
    val cards = mutableListOf<Card>()

    init {
        makeDeck()
    }

    private fun makeDeck() {
        for (i in Suits.values()) {
            for (j in Ranks.values()) {
                cards.add(Card(j, i))
            }
        }
    }

    fun reset() {
        cards.clear()
        makeDeck()
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun getCard(n: Int): String {
        val num: Int
        if (n in 1..cards.size) num = n
        else
            if (n < 52 && n > cards.size) {
                return "The remaining cards are insufficient to meet the request."
            } else return "Invalid number of cards."
        val list = mutableListOf<Card>()
        repeat(num) { list.add(cards.removeLast()) }
        val sj = StringJoiner(" ")
        list.forEach { sj.add(it.toString()) }
        return sj.toString()
    }

    fun drawCard(n: Int): List<Card> {
        val list = mutableListOf<Card>()
        if (n in 1..cards.size) {
            repeat(n) { list.add(cards.removeLast()) }
        }
        return list
    }
}