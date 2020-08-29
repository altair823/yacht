package player

import algorithm.CheckHands
import dice.Dice
import iostream.Stream

class Player(){
    var playerName: String = ""

    //number of each player's dice.
    //the default count is DefaultDiceCount(5)
    //why variable of enum class does not treat as Int? need to fix it later.
    private var remainDiceCount: Int = 5

    //list of numbers of rolled dice.
    private var diceNumberList = mutableListOf<Int>()

    //list of numbers which player picked
    var savedDiceNumberList = mutableListOf<Int>()

    fun setPlayerName() {
        //input player name
        playerName = Stream.nameIO()
    }

    fun rollDice() {

        //reassign list of dice number.
        this.diceNumberList = Dice().roll(this.remainDiceCount)

        Stream.numPrint(diceNumberList, listType = "Rolled", playerName = playerName)
        //print("<Dice> : "); println(this.diceNumberList)
    }

    fun selectDice() {
        //////////////////////////
        //First section: saving numbers of dice.
        //////////////////////////
        //numbers are inputting and verifying.
        val tempInputSaveNumberList = Stream.verifyInput(this.remainDiceCount)
        //save number of dice which has same index number(actually, it has index-1)
        //with inputted number.
        for (i in tempInputSaveNumberList){
            this.savedDiceNumberList.add(this.diceNumberList[i-1])
        }
        this.remainDiceCount = this.remainDiceCount - tempInputSaveNumberList.size
        //////////////////////////
        //////////////////////////

        numberPrint()

        //////////////////////////
        //Second section: deleting numbers of dice from savedDiceNumber for re-rolling
        //////////////////////////
        //numbers are inputting and verifying
        var tempInputThrowNumberList = Stream.verifyInput(5-this.remainDiceCount)
        //sort the list which include numbers has to throw away.
        tempInputThrowNumberList = tempInputThrowNumberList.sortedDescending().toMutableList()
        //throw away numbers which has inputted index number.
        for (i in tempInputThrowNumberList) {
            this.savedDiceNumberList.removeAt(i - 1)
        }
        this.remainDiceCount = this.remainDiceCount + tempInputThrowNumberList.size
        //////////////////////////
        //////////////////////////

        numberPrint()
        println()
        //println(CheckHands.checkDiceNumber(this.savedDiceNumberList))
    }

    fun endPlayerTurn() {
        savedDiceNumberList.addAll(diceNumberList)
        numberPrint()
        println()
    }

    private fun numberPrint() {
        Stream.numPrint(savedDiceNumberList, listType = "Saved" , playerName = playerName)
        //print("|Saved : "); println(savedDiceNumber)
    }
}