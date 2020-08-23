package algorithm

object CheckHands {

    //checking section 1

    //checking section 2
    fun checkDiceNumber(diceNumberList: List<Int>): List<Int> {
        val point = mutableListOf<Int>()

        point.addAll(sameCheck(diceNumberList))

        //check choice
        point.add(choiceCheck(diceNumberList))

        //four of a kind
        point.add(fourOfKind(diceNumberList))

        //full house
        point.add(fullHouse(diceNumberList))

        //small straight
        point.add(sStraight(diceNumberList))

        //large straight
        point.add(lStraight(diceNumberList))

        //yacht
        point.add(yacht(diceNumberList))

        //println(point)
        return point
    }

    //check same number
    private fun sameCheck(diceNumberList: List<Int>): List<Int> {

        //count of same numbers.
        val count = mutableListOf<Int>(0, 0, 0, 0, 0, 0)

        //store each number's count in the list.
        for (i in diceNumberList){ count[i-1] += i }
        return count
    }

    //check choice
    private fun choiceCheck(diceNumberList: List<Int>): Int {
        var sum = 0
        for (i in diceNumberList){
            sum += i
        }
        return sum
    }

    //check four of a kind
    private fun fourOfKind(diceNumberList: List<Int>): Int {
        for (i in 0..1){
            var tempSameNumberCount = 1
            for (j in (i+1) until diceNumberList.size){
                if (diceNumberList[i] == diceNumberList[j]){
                    tempSameNumberCount += 1
                }
            }
            if (tempSameNumberCount >= 4){
                var total = 0
                for (k in diceNumberList) { total += k }
                return total
            }
        }
        return 0
    }

    //check full house
    private fun fullHouse(diceNumberList: List<Int>): Int {

        val tempDiceNumberList = diceNumberList.sorted()
        for (i in bruteForceDateFH){
            val tempList = i.sorted()
            if (tempDiceNumberList == tempList){
                val tripleNumber = i[0]
                val pairNumber = i[4]
                return (tripleNumber * 3) + (pairNumber * 2)
            }
        }
        return 0
    }

    //check small straight
    private fun sStraight(diceNumberList: List<Int>): Int {

        //search small straight with brute force algorithm
        for (i in bruteForceDataSS){

            if (diceNumberList.containsAll(i)){
                return 15
            }
        }
        return 0
    }

    //check large straight
    private fun lStraight(diceNumberList: List<Int>): Int {

        //search large straight with brute force algorithm.
        for (i in bruteForceDataLS){
            if (diceNumberList.containsAll(i)){
                return 30
            }
        }
        return 0
    }

    //check yacht
    private fun yacht(diceNumberList: List<Int>): Int {

        for (i in bruteForceDataY){
            if (diceNumberList == i){
                return 50
            }
        }
        return 0
    }
}