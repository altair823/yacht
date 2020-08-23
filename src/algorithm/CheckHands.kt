package algorithm

import player.Player

object CheckHands {
    fun sameCheck(player: Player): List<Int> {

        //count of same numbers.
        val count = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0)

        for (i in player.savedDiceNumberList){ count[i] += 1 }
        return count
    }

    fun specialCheck(player: Player): List<Int> {
        val count = mutableListOf<Int>(0, 0, 0, 0, 0, 0)

        //check choice
        count[0] = choiceCheck(player.savedDiceNumberList)

        //four of kind
        count[1] = fourOfKind(player.savedDiceNumberList)

        return count
    }


    private fun choiceCheck(diceNumberList: List<Int>): Int {
        var sum = 0
        for (i in diceNumberList){
            sum += i
        }
        return sum
    }

    private fun fourOfKind(diceNumberList: List<Int>): Int {
        for (i in 0..1){
            var tempSameNumberCount = 1
            var tempSameNumber = 0
            for (j in (i+1) until diceNumberList.size){
                if (diceNumberList[i] == diceNumberList[j]){
                    tempSameNumberCount += 1
                    print("$i $j ")
                    println(tempSameNumberCount)
                    tempSameNumber = diceNumberList[i]
                }
            }
            if (tempSameNumberCount >= 4){
                return tempSameNumber
            }
        }
        return 0
    }

}
fun main() {
    val a = listOf<Int>(3, 3, 3, 1, 3)
}