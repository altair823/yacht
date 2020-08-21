package rule

import rule.*
import player.Player
import dice.Dice
import scoreboard.Board



//Game rule handler
object RuleHandler {

    //initialize player class instance.
    private val player1 = Player()
    private val player2 = Player()

    //make board instance
    var board = Board()


    //call when a game start.
    fun gameStart() {
        board.initBoard()

        //set player names.
        board.setPlayerName(player1.player1Name, player2.player2Name)
    }

    //call when it need to rolled.
    fun rollTheDice() {




    }

}

//main function for test and debug.
fun main() {
    RuleHandler.gameStart()


}

fun main() {

}