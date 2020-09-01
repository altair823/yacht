/*
Latest update: 20-09-01 12:37

Current Version:
    Version 0.1
    Version 0.2

Contributor: altair823

Description:
    Singleton which is handler of game.
    Player instance, board instance initialize in this singleton.
 */


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

    //call when a game start.
    fun gameStart() {
        boardPlayer1.initBoard()
        boardPlayer2.initBoard()

        player1.setPlayerName(); player2.setPlayerName()

        /*
        boardPlayer1.playerName = player1.playerName
        boardPlayer2.playerName = player2.playerName

         */
        println()

    }

    //Encapsulation of each player's turn.
    fun turns(){
        turnPlayer(player1, boardPlayer1)
        turnPlayer(player2, boardPlayer2)
    }

    //if all turns end, calculate total point(include bonus) and print winner.
    fun end(){

        /*
        //if endPlayer function returns false,
        //there is blank in the board.
        if (!endPlayer(boardPlayer1)){
            throw NoSuchFieldException("There is null value in player1's board!")
        }
        if (!endPlayer(boardPlayer2)){
            throw NoSuchFieldException("There is null value in player2's board!")
        }

        //if endPlayer function return true(there is no blank),
        //

         */

        if (boardPlayer1.totalPoint > boardPlayer2.totalPoint){
            println()
            println()
            println("${player1.playerName} WIN!!")
        }
        if (boardPlayer1.totalPoint < boardPlayer2.totalPoint){
            println()
            println()
            println("${player2.playerName} WIN!!")

        }
        if (boardPlayer1.totalPoint == boardPlayer2.totalPoint){
            println()
            println()
            println("DRAW!!")
        }

    }

    //each player's turn has given parameters player instance, and its board instance.
    private fun turnPlayer(player: Player, boardPlayer: Board): Boolean{

        //init values
        //////////////////////
        player.initForTurn()

        //first turn
        //////////////////////
        Stream.boardPrint(player, boardPlayer)
        player.rollDice()
        player.selectDice()
        //values in pointListPlayer are available to save in the board.
        var pointListPlayer: MutableList<Int> = checkDice(player)
        Stream.boardPrint(player, boardPlayer)
        //value which check the choice of player. if the value is true,
        //it means that player has a choice, and handler passes its turn.
        var passTurnCheck: Boolean = choicePlayer(boardPlayer, pointListPlayer)

        //if player choose its number,
        //the player's turn end.
        if (passTurnCheck == true) {
            return true
        }

        //second turn
        //////////////////////
        player.rollDice()
        player.selectDice()
        pointListPlayer = checkDice(player)
        Stream.boardPrint(player, boardPlayer)
        passTurnCheck = choicePlayer(boardPlayer, pointListPlayer)
        println()

        if (passTurnCheck == true) {
            return true
        }

        //third, last turn
        //////////////////////
        player.rollDice()
        //last roll of a turn
        player.endPlayerTurn()
        pointListPlayer = checkDice(player)
        Stream.boardPrint(player, boardPlayer)
        passTurnCheck = choicePlayer(boardPlayer, pointListPlayer, 1)

        if (passTurnCheck == true) {
            return true
        }

        else{
            return false
        }
    }

    private fun checkDice(player: Player): MutableList<Int> {
        return CheckHands.checkDiceNumber(player.savedDiceNumberList)
    }

    private fun choicePlayer(boardPlayer: Board, pointList: MutableList<Int>, lastChoice: Int = 0): Boolean{

        var choice: Int

        while (true){
            choice = Stream.choiceInput(pointList)
            println()
            val verify = boardPlayer.setPoint(choice, pointList)
            //println(boardPlayer.pointList)
            if (((verify == 1) && (lastChoice == 1)) || (verify == -1)){
                println("Please input available choice.")
                continue
            }
            else{
                break
            }
        }

        //if the choice has a value(if the player choose),
        //the function returns 1 to pass the player's turn.
        //or else, returns 0 to do not pass the turn.
        //println("$choice--------------------------")
        if (choice == 0){
            return false
        }
        else{
            return true
        }
    }

    /*
    private fun endPlayer(boardPlayer: Board): Boolean {
        var sum: Int? = null
        for (i in 0..6){

            //if there is no null value in board,
            //and if sum of all number points(1~6) is 63 or more,
            if ((sum != null) && (boardPlayer.pointList[i] != null)) {
                sum += boardPlayer.pointList[i]!!
            }
            else{
                //if there is null value in board
                //return false to throw exception.
                return false
            }
        }

        //plus 35 point to total point.
        if (sum != null) {
            if (sum >= 63){
                boardPlayer.totalPoint += 35
            }
        }
        //there is no null value,
        //return true.
        return true
    }

     */
}