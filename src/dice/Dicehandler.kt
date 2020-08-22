package dice

//The class of a dice.
class Dice() {

    //Current number of dice.
    val numberList = mutableListOf<Int>()

    //Rolling the dice.
    fun roll(diceCount: Int): MutableList<Int>{
        for (i in 1..diceCount){
            val tempRandom = (1..6).random()
            numberList.add(tempRandom)
        }
        return numberList
    }
}

