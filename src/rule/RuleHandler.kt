package rule

import player.Player
import scoreboard.Board
import algorithm.CheckHands
import iostream.Stream
import kotlin.test.assertFalse


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

        boardPlayer1.setPlayerName(player1.playerName)
        boardPlayer2.setPlayerName(player2.playerName)

    }

    //Encapsulation of each player's turn.
    fun turns(){
        turnPlayer(player1, boardPlayer1)
        turnPlayer(player2, boardPlayer2)
    }

    //each player's turn has given parameters player instance, and its board instance.
    private fun turnPlayer(player: Player, boardPlayer: Board): Boolean{

        //first turn
        //////////////////////
        player.rollDice()
        player.selectDice()
        //values in pointListPlayer are available to save in the board.
        var pointListPlayer: MutableList<Int> = checkDice(player)
        Stream.boardPrint(boardPlayer)
        //value which check the choice of player. if the value is true,
        //it means that player has a choice, and handler passes its turn.
        var passTurnValue: Boolean = choicePlayer(player, boardPlayer, pointListPlayer)

        //if player choose its number,
        //the player's turn end.
        if (passTurnValue == true) {
            return true
        }

        //second turn
        //////////////////////
        player.rollDice()
        player.selectDice()
        pointListPlayer = checkDice(player)
        Stream.boardPrint(boardPlayer)
        passTurnValue = choicePlayer(player, boardPlayer, pointListPlayer)

        if (passTurnValue == true) {
            return true
        }

        //third, last turn
        //////////////////////
        player.rollDice()
        player.endPlayerTurn()
        pointListPlayer = checkDice(player)
        Stream.boardPrint(boardPlayer)
        passTurnValue = choicePlayer(player, boardPlayer, pointListPlayer, 1)

        if (passTurnValue == true) {
            return true
        }

        else{
            return false
        }
    }

    private fun checkDice(player: Player): MutableList<Int> {
        return CheckHands.checkDiceNumber(player.savedDiceNumberList)
    }

    private fun choicePlayer(player: Player, boardPlayer: Board, pointList: MutableList<Int>, lastChoice: Int = 0): Boolean{

        var choice: Int

        while (true){
            choice = Stream.choiceInput(player, pointList)
            val verify = boardPlayer.setPoint(choice, pointList)
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
        println("$choice--------------------------")
        if (choice == 0){
            return false
        }
        else{
            return true
        }
    }
}