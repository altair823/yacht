package iostream

import scoreboard.Board

object Stream{

    //check inputted numbers.
    fun verifyInput(rollableDiceCount: Int): MutableList<Int>{

        val returnInputDiceNumber: MutableList<Int> = mutableListOf()
        //section of verifying inputted numbers.
        verify@while (true) {
            print("""Input dice number(1~$rollableDiceCount)(split with blank) : """)
            //input dice number
            val inputDiceNumber = readLine()!!.split(" ")

            //if there is no choice,
            //break the loop and do nothing.
            if (inputDiceNumber[0] == ""){
                break@verify
            }
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

    //function for setting player's name.
    fun nameIO(nameIn: String? = null): String {
        var nameOut: String?
        while(true) {
            print("Please input player's name : ")
            nameOut = readLine()

            //if there is no input,
            //or if inputted name is same as another player,
            //require re-input.
            return if ((nameOut == null)||(nameOut == nameIn)||(nameOut == "")) {
                println("invalid name input.")
                continue
            } else {
                nameOut.also { println("Set player's name as $nameOut") }
            }
        }
    }

    //
    fun numPrint(diceList: MutableList<Int>,listType: String = "" , playerName: String = "") {
        if (playerName != ""){
            print(playerName)
        }

        if (listType != ""){
            print(" | $listType Dice >>")
        }
        else{
            print(" | Dice >>")
        }

        for (i in diceList){
            print(" [$i] ")
        }
        println()
    }

    //input choice of player's hands.
    fun choiceInput(playerPoint: List<Int>): Int{

        println("Available point list >> ")
        for (i in 0..11 step 2){
            println("${i + 1}. [${playerPoint[i]}]  |  ${i + 2}. [${playerPoint[i+1]}]")
        }

        while (true) {
            print("Please input point number >> ")
            val choice = readLine().toString()

            /*
            //section of checking null and range of choice input.
            if (choice == ""){
                println("Input checking Error! Please input again.")
                continue
            }

             */
            if (choice == ""){
                return 0
            }
            if ((choice.toInt()>12)||(choice.toInt()<1)){
                println("Input range Error! Please input again.")
                continue
            }

            return choice.toInt()


        }
    }

    fun boardPrint(boardPlayer: Board){
        println("${boardPlayer.playerName}'s board >> ")

        //mutableList for printing board.
        val tempPointList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        for (i in 0..11){
            //if there is no value in the board point list,
            if (boardPlayer.pointList[i] == null){
                //print zero
                //need to change because we need to differentiate
                //with point section in the board which has value.
                tempPointList[i] = 0
            }
            else{
                //there is value, print that value.
                tempPointList[i] = boardPlayer.pointList[i]!!
            }
        }

        //print all inputable section of board.
        for (i in 0..11 step 2){
            when (i){
                0 -> {
                    print("one: [${tempPointList[0]}]             |  ")
                    println("two: [${tempPointList[1]}]")
                }
                2 -> {
                    print("three: [${tempPointList[2]}]           |  ")
                    println("four: [${tempPointList[3]}]")
                }
                4 -> {
                    print("five: [${tempPointList[4]}]            |  ")
                    println("six: [${tempPointList[5]}]")
                }
                6 -> {
                    print("choice: [${tempPointList[6]}]          |  ")
                    println("four of a kind: [${tempPointList[7]}]")
                }
                8 -> {
                    print("full house: [${tempPointList[8]}]      |  ")
                    println("small straight: [${tempPointList[9]}]")
                }
                10 -> {
                    print("large straight: [${tempPointList[10]}]  |  ")
                    println("yacht: [${tempPointList[11]}]")
                }
            }
        }

        //print total point
        println("total point: [${boardPlayer.totalPoint}]")
        println()
    }

}
