package indigo

class Rules {
    val forNumBouns = 3
    val forRank = 1
    val totalScore = 23
    fun scoreForRank(player: Player, cards: List<Card>) {
        for (card in cards) {
            if (
                card.rank == Ranks.TEN ||
                card.rank == Ranks.ACE ||
                card.rank == Ranks.JACK ||
                card.rank == Ranks.QUEEN ||
                card.rank == Ranks.KING
            ) player.score = player.score + forRank
        }
    }

    fun scoreForNum(player1: Player, player2: Player) {
        if (player1.winCards.size > player2.winCards.size)
            player1.score = player1.score + forNumBouns
        if (player2.winCards.size > player1.winCards.size)
            player2.score = player2.score + forNumBouns
        if (player1.winCards.size == player2.winCards.size)
            if (player1.first) player1.score = player1.score + forNumBouns
            else player2.score = player2.score + forNumBouns
    }

    fun lastRule(player1: Player, player2: Player) {
        if (player1.winCards.size == 0 && player2.winCards.size == 0) {
            if (player1.first) player1.score = totalScore
            else player2.score = totalScore
        }
    }
}