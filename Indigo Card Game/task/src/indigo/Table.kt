package indigo

class Table(val deck: Deck) : CardCeeper {
    override val cards: MutableList<Card> = mutableListOf()

}