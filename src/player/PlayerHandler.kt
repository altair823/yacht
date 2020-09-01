/*
Latest update: 20-08-31 16:17

Current Version:
    Version 0.1
    Version 0.2

Contributor: altair823

Description:
    File which is define the player class.
    in the player class,
    Player name variable, number of dice which is remain and saved in player's hand variable
    is defined and initialized.
    Need two instance of player for a game.

*/


package player

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
        this.playerName = Stream.nameIO()
    }

    fun initForTurn(){
        this.remainDiceCount = 5
        this.savedDiceNumberList = mutableListOf<Int>()
    }

    fun rollDice() {

        //reassign list of dice number.
        this.diceNumberList = Dice().roll(this.remainDiceCount)

        Stream.numPrint(this.diceNumberList, listType = "Rolled", playerName = this.playerName)
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
        this.savedDiceNumberList.addAll(this.diceNumberList)
        numberPrint()
        println()
    }

    private fun numberPrint() {
        Stream.numPrint(savedDiceNumberList, listType = "Saved" , playerName = this.playerName)
        //print("|Saved : "); println(savedDiceNumber)
    }
}