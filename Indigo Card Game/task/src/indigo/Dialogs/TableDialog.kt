package indigo.Dialogs

import Dialogs.ByeDialog
import indigo.CardCeeper

class TableDialog(val table: CardCeeper): Dialog {

    override fun execute() {
        tableview()
        if (table.cards.size==52) ByeDialog().execute()
    }


    fun tableview(){
        println()

        if (table.cards.isEmpty()) println("No cards on the table")else
        println("${table.showCards().size} cards on the table, and the top card is ${table.showCards().last()}")
    }
}