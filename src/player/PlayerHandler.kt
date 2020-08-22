package player

import dice.Dice
import iostream.Stream

class Player(){
    var playerName: String = "null"

    //number of each player's dice.
    //the default count is DefaultDiceCount(5)
    //why variable of enum class does not treat as Int? need to fix it later.
    private var remainDiceCount: Int = 5

    //list of numbers of rolled dice.
    private var diceNumberList = mutableListOf<Int>()

    //list of numbers which player picked
    private var savedDiceNumber = mutableListOf<Int>()


    init {
        /*
        for (i in (0 until diceCount)){
            plyDice.add(Dice(i))
        }

         */
    }

    fun setPlayerName() {
        //input players name
        this.playerName = readLine().toString()
    }

    fun rollDice() {
        /*
        for (i in (0..4)){
            plyDice[i].roll()
            //print(ply1Dice[i].diceNumber)
            //println(ply1Dice[i].number)
        }

         */

        //reassign list of dice number.
        this.diceNumberList = Dice().roll(this.remainDiceCount)
        //println(this.diceNumberList)
    }

    fun selectDice() {

        //number input and verify.
        val tempInputNumberList = Stream().verifyInput(this.remainDiceCount)


        //println(tempInputNumberList)
        //println(this.savedDiceNumber)

        //save number of dice which has same index number(actually, it has index-1)
        //with inputted number.
        for (i in tempInputNumberList){
            this.savedDiceNumber.add(this.diceNumberList[i-1])
        }
        this.remainDiceCount = this.remainDiceCount - this.savedDiceNumber.size

    }

    fun numberPrint() {
        print("player's name : ")
        println(this.playerName)

        print("")
    }
}

fun main() {
    val a = Player()
    a.rollDice()
    a.selectDice()
}