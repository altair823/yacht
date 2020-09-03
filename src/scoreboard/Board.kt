/*
Latest update: 20-09-01 13:44

Current Version:
    Version 0.1
    Version 0.2
    Version 0.3

Contributor: altair823

Description:
    Board class for game. there will be board instance for each player.
    Class include variable that player name, point list, subtotal(total sum for 1~6), and total point

 */


package scoreboard

//The class of game score board.
class Board {

    var pointList = mutableListOf<Int?>()
    var subTotal = 0
    var totalPoint = 0


    fun initBoard() {
        pointList = mutableListOf(null, null, null, null, null, null,
                                        null, null, null, null, null, null)
        subTotal = 0
        totalPoint = 0
    }

    fun setPoint(typeLocation: Int, pointListPlayer: MutableList<Int>): Int{

        return when {
            typeLocation == 0 -> {
                1
            }
            this.pointList[typeLocation-1] != null -> {
                -1
            }
            else -> {
                this.pointList[typeLocation - 1] = pointListPlayer[typeLocation - 1]
                0
            }
        }
    }

    fun calSubTotal(){
        var tempSubTotal = 0
        for (i in 0..5){
            tempSubTotal += if (pointList[i] != null){
                pointList[i]!!
            } else{
                0
            }
        }
        if (tempSubTotal >= 63){
            tempSubTotal += 35
        }
        subTotal = tempSubTotal
    }

    fun calTotal(){
        var tempTotal = 0
        for (i in 6..11){
            tempTotal += if (pointList[i] != null){
                pointList[i]!!
            } else{
                0
            }
        }
        totalPoint = tempTotal
        totalPoint += subTotal
    }


}