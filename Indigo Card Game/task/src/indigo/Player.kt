package indigo

class Player(
    val isAi: Boolean = false,
    var first: Boolean = false,
    var score: Int = 0
) : CardCeeper {
    override val cards: MutableList<Card> = mutableListOf()
    val winCards = mutableListOf<Card>()


    fun getWinCards(list: MutableList<Card>) {
        winCards.addAll(list)
    }

}