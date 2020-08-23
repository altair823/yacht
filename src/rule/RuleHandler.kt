package rule

import player.Player
import scoreboard.Board
import algorithm.CheckHands


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

    //
    fun turn() {

        player1.rollDice()
        player1.selectDice()

        player1.rollDice()
        player1.selectDice()

        player1.rollDice()
        player1.endPlayerTurn()


        player2.rollDice()
        player2.selectDice()

        player2.rollDice()
        player2.selectDice()

        player2.rollDice()
        player2.endPlayerTurn()

    }

    fun checkDice() {
        val player1SameNumberList = CheckHands.sameCheck(player1)
        val player2SameNumberList = CheckHands.sameCheck(player2)

        println(player1SameNumberList)
        println(player2SameNumberList)
    }
}