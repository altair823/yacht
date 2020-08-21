package rule

import player.Player
import scoreboard.Board



//Game rule handler
object RuleHandler {

    //initialize player class instance.
    private val player1 = Player()
    private val player2 = Player()

    //make board instance
    private var board = Board()


    //call when a game start.
    fun gameStart() {
        board.initBoard()
        player1.setPlayerName(); player2.setPlayerName()
        board.setPlayerName(player1.playerName, player2.playerName)

    }

    fun turn() {

        player1.rollDice()


    }

    //call when it need to rolled.
    fun rollDiceHandler() {
        //each player roll the dice.
        player1.rollDice()
        player2.rollDice()

    }

}

//main function for test and debug.
fun main() {
    RuleHandler.gameStart()
    RuleHandler.rollDiceHandler()

}