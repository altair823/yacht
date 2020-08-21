package dice

//The class of a dice.
class Dice(val diceNumber: Int) {

    //Current number of dice.
    var number: Int = 0

    //Rolling the dice.
    fun roll(){
        val tempRandom = (1..6).random()
        this.number = tempRandom
        /*
        println(this.number)
        println(tempRandom)

         */
    }
}

