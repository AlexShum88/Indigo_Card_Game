package indigo

interface CardCeeper {
    val cards: MutableList<Card>


    fun cardsToPool(source: List<Card>) {
        cards.addAll(source)
    }

    fun cardsToPool(source: Card) {
        cards.add(source)
    }

    fun showCards(): List<Card> {
        return cards.toList()
    }

    fun playCard(index: Int): Card {
        return cards.removeAt(index)
    }
}