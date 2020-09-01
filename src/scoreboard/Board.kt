/*
Latest update: 20-09-01 13:44

Current Version:
    Version 0.1
    Version 0.2

Contributor: altair823

Description:
    Board class for game. there will be board instance for each player.
    Class include variable that player name, point list, subtotal(total sum for 1~6), and total point

 */


package scoreboard

//The class of game score board.
class Board {

    //var playerName = ""
    var pointList = mutableListOf<Int?>()
    var subTotal = 0
    var totalPoint = 0


    fun initBoard() {
        //playerName = ""
        pointList = mutableListOf<Int?>(null, null, null, null, null, null,
                                        null, null, null, null, null, null)
        subTotal = 0
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

    fun calSubTotal(){
        var tempSubTotal = 0
        for (i in 0..5){
            if (pointList[i] != null){
                tempSubTotal += pointList[i]!!
            }
            else{
                tempSubTotal += 0
            }
        }
        subTotal = tempSubTotal
    }

    fun calTotal(){
        var tempTotal = 0
        for (i in pointList){
            if (i != null){
                tempTotal += i
            }
            else{
                tempTotal += 0
            }
        }
        totalPoint = tempTotal
    }


}