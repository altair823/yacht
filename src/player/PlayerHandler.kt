package player

import dice.Dice

class Player(){
    //Each player's name. Initialized with null value.
    var player1Name: String = "null"
    var player2Name: String = "null"

    //number of each player's dice.
    //the default count is DefaultDiceCount(5)
    //why variable of enum class does not treat as Int? need to fix it later.
    var ply1DiceCount: Int = 5
    var ply2DiceCount: Int = 5

    //list of dice instance of each players.
    private val ply1Dice = mutableListOf<Dice>()
    private val ply2Dice = mutableListOf<Dice>()


    init {
        for (i in (1..ply1DiceCount)){
            ply1Dice.add(Dice(i))
        }
        for (i in (1..ply2DiceCount)){
            ply2Dice.add(Dice(i))
        }
    }

    fun setPlayerName() {
        //input players name
        this.player1Name = readLine().toString()
        this.player2Name = readLine().toString()
    }

    fun rollDice() {
        for (i in (1..ply1DiceCount)){
            ply1Dice[i].roll()
        }
        for (i in (1..ply2DiceCount)){
            ply2Dice[i].roll()
        }
    }

    fun selectDice() {

    }
}
