package algorithm

import player.Player

object CheckHands {
    fun upperCheck(player: Player): Map<Int, Int> {

        //value which is going to return.
        val resultMap = hashMapOf<Int, Int>()

        var oneCount = 0
        var twoCount = 0
        var threeCount = 0
        var fourCount = 0
        var fiveCount = 0
        var sixCount = 0

        val count = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0)

        for (i in player.savedDiceNumber){
            when (i){
                1 -> count[1]
                2 -> count[2]
                3 -> count[3]
                4 -> count[4]
                5 -> count[5]
                6 -> count[6]
                else -> println("Dice Check Range Error!")
            }
        }
        for (i in 1..6){
            if (count[i] >= 1){

            }
        }
    }
}