package scoreboard

//The class of game score board.
class Board {

    var playerName = ""
    var pointList = mutableListOf<Int?>()
    var totalPoint = 0


    fun initBoard() {
        playerName = ""
        pointList = mutableListOf<Int?>(null, null, null, null, null, null,
                                        null, null, null, null, null, null)
        totalPoint = 0
    }

    fun setPoint(typeLocation: Int, pointListPlayer: MutableList<Int>): Int{

        if (typeLocation == 0){
            return 1
        }
        if (this.pointList[typeLocation-1] != null){
            return -1
        }
        else {
            this.pointList[typeLocation - 1] = pointListPlayer[typeLocation - 1]
            return 0
        }

    }


}