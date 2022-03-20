package indigo.playType

import indigo.Player

interface Play {
    val player: Player
    fun execute()
}