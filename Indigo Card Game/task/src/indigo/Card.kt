package indigo

class Card(
    val rank: Ranks,
    val suit: Suits
) {
    override fun toString(): String {
        return "${rank.getRank()}${suit.getSuit()}"
    }
}


enum class Suits {
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠"),
    CLUBS("♣");

    private val suit: String

    constructor(s: String) {
        this.suit = s;
    }

    fun getSuit() = this.suit
}


enum class Ranks(ss: String) {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private val rank: String = ss

    fun getRank() = this.rank
}