package player

import dice.Dice

class Player(){
    var playerName: String = "null"

    //number of each player's dice.
    //the default count is DefaultDiceCount(5)
    //why variable of enum class does not treat as Int? need to fix it later.
    var diceCount: Int = 5

    //list of dice instance of each players.
    val plyDice = mutableListOf<Dice>()

    val savedDice = mutableListOf<Dice>()


    init {
        for (i in (0 until diceCount)){
            plyDice.add(Dice(i))
        }
    }

    fun setPlayerName() {
        //input players name
        this.playerName = readLine().toString()
    }

    fun rollDice() {
        for (i in (0..4)){
            plyDice[i].roll()
            //print(ply1Dice[i].diceNumber)
            //println(ply1Dice[i].number)
        }
    }

    fun selectDice() {
        verify@while (true) {
            print("""Input dice number(1~$)(split with blank) : """)
            //input dice number
            val inputDiceNumber = readLine()!!.split(" ")

            //verify inputted dice number's range(1~6)
            for (i in inputDiceNumber) {
                if (i !in "1".."6"){
                    //if one of the inputted number isn't in 1 to 6,
                    //input number again.
                    println("Range Error! Please input number range of 1 to 6")
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
            //if same numbers doesn't exist, break the while(true) loop.
            break@verify
        }
    }

    fun numberPrint() {
        print("player's name : ")
        println(playerName)

        print("")
    }
}

fun main() {
    val a = Player()
    a.selectDice()
}