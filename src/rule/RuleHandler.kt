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

    //Encapsulation of each player's turn.
    fun turns(){
        turnPlayer(player1, boardPlayer1)
        turnPlayer(player2, boardPlayer2)
    }

    //each player's turn has given parameters player instance, and its board instance.
    private fun turnPlayer(player: Player, boardPlayer: Board){

        //first turn
        //////////////////////
        player.rollDice()
        player.selectDice()
        //values in pointListPlayer are available to save in the board.
        var pointListPlayer: MutableList<Int> = checkDice(player)
        Stream.boardPrint(boardPlayer)
        choicePlayer(player, boardPlayer, pointListPlayer)

        //second turn
        //////////////////////
        player.rollDice()
        player.selectDice()
        pointListPlayer = checkDice(player)
        Stream.boardPrint(boardPlayer)
        choicePlayer(player, boardPlayer, pointListPlayer)

        //third, last turn
        //////////////////////
        player.rollDice()
        player.endPlayerTurn()
        pointListPlayer = checkDice(player)
        Stream.boardPrint(boardPlayer)
        choicePlayer(player, boardPlayer, pointListPlayer, 1)
    }

    private fun checkDice(player: Player): MutableList<Int> {
        return CheckHands.checkDiceNumber(player.savedDiceNumberList)
    }

    private fun choicePlayer(player: Player, boardPlayer: Board, pointList: MutableList<Int>, lastChoice: Int = 0){

        while (true){
            val choice = Stream.choiceInput(player, pointList)
            val verify = boardPlayer.setPoint(choice, pointList)
            if (((verify == 1) && (lastChoice == 1)) || (verify == -1)){
                println("Please input available choice.")
                continue
            }
            else{
                break
            }
        }
    }
}