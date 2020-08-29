package rule

import player.Player
import scoreboard.Board
import algorithm.CheckHands
import iostream.Stream


//Game rule handler
object RuleHandler {

    //initialize player class instance.
    private val player1 = Player()
    private val player2 = Player()

    //make board instance
    private val boardPlayer1 = Board()
    private val boardPlayer2 = Board()

    //available point list for each player
    private var pointListPlayer1 = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var pointListPlayer2 = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)


    //call when a game start.
    fun gameStart() {
        boardPlayer1.initBoard()
        boardPlayer2.initBoard()

        player1.setPlayerName(); player2.setPlayerName()

        boardPlayer1.setPlayerName(player1.playerName)
        boardPlayer2.setPlayerName(player2.playerName)

    }

    //
    fun turnPlayer1() {

        player1.rollDice()
        player1.selectDice()
        //println(CheckHands.checkDiceNumber(player1.savedDiceNumberList))
        checkDice()
        //print player1's board
        Stream.boardPrint(boardPlayer1)
        choicePlayer1()

        player1.rollDice()
        player1.selectDice()
        //println(CheckHands.checkDiceNumber(player1.savedDiceNumberList))
        checkDice()
        //print player1's board
        Stream.boardPrint(boardPlayer1)
        choicePlayer1()

        player1.rollDice()
        player1.endPlayerTurn()
        //println(CheckHands.checkDiceNumber(player1.savedDiceNumberList))
        checkDice()
        //there must be filled when it takes last turn.
        //print player1's board
        Stream.boardPrint(boardPlayer1)
        choicePlayer1(1)



    }

    fun turnPlayer2(): Boolean {
        player2.rollDice()
        player2.selectDice()
        //println(CheckHands.checkDiceNumber(player2.savedDiceNumberList))
        checkDice()
        //print player1's board
        Stream.boardPrint(boardPlayer2)
        if (choicePlayer2()){
            return true
        }

        player2.rollDice()
        player2.selectDice()
        //println(CheckHands.checkDiceNumber(player2.savedDiceNumberList))
        checkDice()
        //print player1's board
        Stream.boardPrint(boardPlayer2)
        if (choicePlayer2()){
            return true
        }

        player2.rollDice()
        player2.endPlayerTurn()
        //println(CheckHands.checkDiceNumber(player2.savedDiceNumberList))
        checkDice()
        //there must be filled when it takes last turn.
        //print player1's board
        Stream.boardPrint(boardPlayer2)
        if (choicePlayer2(1)){
            return true
        }


        else{
            return false
        }
    }

    fun checkDice() {

        pointListPlayer1 = CheckHands.checkDiceNumber(player1.savedDiceNumberList)
        pointListPlayer2 = CheckHands.checkDiceNumber(player2.savedDiceNumberList)

        //println(pointListPlayer1)
        //println(pointListPlayer2)

        //val player1SameNumberList = CheckHands.sameCheck(player1)
        //val player2SameNumberList = CheckHands.sameCheck(player2)

        //println(player1SameNumberList)
        //println(player2SameNumberList)
    }

    private fun choicePlayer1(lastChoice: Int = 0) {

        //print available points.
        while (true) {
            val choice = Stream.choiceInput(player1, pointListPlayer1)
            val verify = boardPlayer1.setPoint(choice, pointListPlayer1)
            if (((verify == 1) && (lastChoice == 1)) || (verify == -1)){
                println("please input available choice.")
                continue
            }
            else{
                break
            }
        }
        //println(boardPlayer1.pointList)
    }

    private fun choicePlayer2(lastChoice: Int = 0): Boolean {
        var choice: Int

        //print available points.
        while (true) {
            choice = Stream.choiceInput(player2, pointListPlayer2)
            val verify = boardPlayer2.setPoint(choice, pointListPlayer2)
            if (((verify == 1) && (lastChoice == 1)) || (verify == -1)){
                continue
            }
            else{
                break
            }

        }
        return choice != 0
        //println(boardPlayer2.pointList)
    }
}