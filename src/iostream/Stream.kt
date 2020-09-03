/*
Latest update: 20-09-01 13:44

Current Version:
    Version 0.1
    Version 0.2
    Version 0.3

Contributor: altair823

Description:
    Print everything related with needed to running program
    and input all variable we need.
 */


package iostream

import player.Player
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

    fun boardPrint(player: Player, boardPlayer: Board){
        println("${player.playerName}'s board >> ")

        //mutableList for printing board.
        val tempPointList = mutableListOf("", "", "", "", "", "", "", "", "", "", "", "")
        for (i in 0..11){
            //if there is no value in the board point list,
            if (boardPlayer.pointList[i] == null){
                //print zero
                //need to change because we need to differentiate
                //with point section in the board which has value.
                tempPointList[i] = "-"
            }
            else{
                //there is value, print that value.
                tempPointList[i] = "${boardPlayer.pointList[i]}"
            }
        }

        //print all inputable section of board.
        for (i in 0..5 step 2) {
            when (i) {
                0 -> {
                    print("1. one: [${tempPointList[0]}]             |  ")
                    println("2. two: [${tempPointList[1]}]")
                }
                2 -> {
                    print("3. three: [${tempPointList[2]}]           |  ")
                    println("4. four: [${tempPointList[3]}]")
                }
                4 -> {
                    print("5. five: [${tempPointList[4]}]            |  ")
                    println("6. six: [${tempPointList[5]}]")
                }
            }
        }

        boardPlayer.calSubTotal()

        println("Subtotal: [${boardPlayer.subTotal}]")

        for (i in 6..11 step 2){
            when (i) {
                6 -> {
                    print("7. choice: [${tempPointList[6]}]          |  ")
                    println("8. four of a kind: [${tempPointList[7]}]")
                }
                8 -> {
                    print("9. full house: [${tempPointList[8]}]      |  ")
                    println("10. small straight: [${tempPointList[9]}]")
                }
                10 -> {
                    print("11. large straight: [${tempPointList[10]}] |  ")
                    println("12. yacht: [${tempPointList[11]}]")
                }
            }
        }

        boardPlayer.calTotal()

        println("total point: [${boardPlayer.totalPoint}]")
        println()
    }

    fun restartInput(): Boolean{
        println()
        while (true) {
            print("Do you want play again?(y or n) >> ")
            val restart = readLine().toString()
            return if ((restart == "y") || (restart == "Y")){
                true
            } else if ((restart == "n") || (restart == "N")){
                println("Game Over")
                false
            } else {
                println("Please input correct answer!")
                continue
            }

        }
    }
}
