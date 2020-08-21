/**
 *
 *
 * 2020 - 08 - 16
 * Version 0.0
 *
 * Yacht Game
 *
 * */


fun main(){
    val testDice = Dice()
    val test2Dice = Dice()
    testDice.rollTheDice()
    test2Dice.rollTheDice()
    print(testDice.number)
    println(test2Dice.number)
    testDice.rollTheDice()
    test2Dice.rollTheDice()
    print(testDice.number)
    println(test2Dice.number)
    testDice.rollTheDice()
    test2Dice.rollTheDice()
    print(testDice.number)
    println(test2Dice.number)

    val test3Dice = Dice()
    test3Dice.roll()
    println(test3Dice.number)
}



class Dice(var number: Int? = null){
    fun rollTheDice(){
        val randomNum = (1..6).random()
        number = randomNum
    }
    /*
    fun numberOut(): Int? {
        return number
    }
    */
}
fun Dice.roll(){
    val randomNum: Int = (1..6).random()
    number = randomNum
}