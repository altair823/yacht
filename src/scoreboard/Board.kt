package scoreboard

//The class of game score board.
class Board {

    /*
    //The first section of the Score board.
    //The sum of these number over 35, the player given bonus points.
    var onePly1Cnt: Int = 0; var onePly2Cnt: Int = 0 //number of player1's dice which has 1
    var twoPly1Cnt: Int = 0; var twoPly2Cnt: Int = 0 //number of player2's dice which has 2
    var threePly1Cnt: Int = 0; var threePly2Cnt: Int = 0
    var forthPly1Cnt: Int = 0; var forthPly2Cnt: Int = 0
    var fivePly1Cnt: Int = 0; var fivePly2Cnt: Int = 0
    var sixPly1Cnt: Int = 0; var sixPly2Cnt: Int = 0

    //The second section of the Score board.
    var choicePly1: Int = 0; var choicePly2: Int = 0 //Choice
    var fourOfKindPly1: Int = 0; var fourOfKindPly2: Int = 0 //Four of kind
    var fullHousePly1: Int = 0; var fullHousePly2: Int = 0 //Full house
    var sStraightPly1: Int = 0; var sStraightPly2: Int = 0 //Small straight
    var lStraightPly1: Int = 0; var lStraightPly2: Int = 0 //Large straight
    var yachtPly1: Int = 0; var yachtPly2: Int = 0 //Yacht

    var totalPly1: Int = 0; var totalPly2: Int = 0 //Total scores of each player.


    //The third section which is included information of player's name and who is win or not.
    var player1Name: String? = null; var player2Name: String? = null

    //If winner variable is 0, there is no winner yet.
    var winner: Int = 0

     */

    var playerName = ""
    var pointList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    var totalPoint = 0


    fun initBoard() {
        /*
        this.player1Name = null;   this.player2Name = null

        this.onePly1Cnt = 0;       this.onePly2Cnt = 0
        this.twoPly1Cnt = 0;       this.twoPly2Cnt = 0
        this.threePly1Cnt = 0;     this.threePly2Cnt = 0
        this.forthPly1Cnt = 0;     this.fourOfKindPly2 = 0
        this.fivePly1Cnt = 0;     this.fivePly2Cnt = 0
        this.sixPly1Cnt = 0;     this.sixPly2Cnt = 0

        this.choicePly1 = 0;       this.choicePly2 = 0
        this.fourOfKindPly1 = 0;   this.fourOfKindPly2 = 0
        this.fullHousePly1 = 0;    this.fourOfKindPly2 = 0
        this.sStraightPly1 = 0;    this.sStraightPly2 = 0
        this.lStraightPly1 = 0;    this.lStraightPly2 = 0
        this.yachtPly1 = 0;        this.yachtPly2 = 0

        this.totalPly1 = 0;        this.totalPly2 = 0
        this.winner = 0

         */

        playerName = ""
        pointList = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        totalPoint = 0
    }

    //function to set player name on the board.
    //if this is really needed?
    //player name still remain and needed to player class.
    //if we could access player.player#Name freely on the handler,
    //this function doesn't need anymore.
    fun setPlayerName(nameParameter: String): Boolean{
        this.playerName = nameParameter

        //if player's name doesn't exist, return false.
        //to verify name input.
        return this.playerName != ""
    }

    fun setPoint(typeLocation: Int, point: Int){

    }


}