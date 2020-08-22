package iostream

class Stream(){
    fun verifyInput(rollableDiceCount: Int): MutableList<Int>{

        val returnInputDiceNumber: MutableList<Int> = mutableListOf()
        //section of verifying inputted numbers.
        verify@while (true) {
            print("""Input dice number(1~$rollableDiceCount)(split with blank) : """)
            //input dice number
            val inputDiceNumber = readLine()!!.split(" ")

            //verify inputted dice number's range(1~#)
            for (i in inputDiceNumber) {
                if (i !in "1"..rollableDiceCount.toString()){
                    //if one of the inputted number isn't in 1 to 5,
                    //if inputted number over the range that count of dice which is saved,
                    //input number again.
                    println("Range Error! Please input number range of 1 to $rollableDiceCount")
                    continue@verify
                }
            }

            //verify if there is same number in list.
            for (i in inputDiceNumber.indices) {
                for (j in ((i + 1) until inputDiceNumber.size)) {
                    if (inputDiceNumber[i] == inputDiceNumber[j]) {
                        //if there is same dice number,
                        //input numbers again.
                        println("Verify Error! Please don't input same numbers.")
                        continue@verify
                    }
                }
            }

            /*
            //compare input number with number of saved dice.
            for (i in alreadySavedDiceList){
                for (j in inputDiceNumber){
                    if (i == j.toInt()){
                        //if one of the inputted number is same with number of saved dice,
                        //input number again
                        println("Verify Error! Please input number doesn't exist.")
                        continue@verify
                    }
                }
            }
            if (diceCount)
            */

            //if verify complete, break the while(true) loop.
            for (i in (inputDiceNumber.indices)){
                returnInputDiceNumber.add(0)
                returnInputDiceNumber[i] = inputDiceNumber[i].toInt()
            }
            break@verify
        }

        //return list<int> of numbers of dice.
        return returnInputDiceNumber
    }
}

fun main() {
    val a = Stream()
    println(a.verifyInput(1))
}