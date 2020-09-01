/*
Latest update: 20-08-31 16:27

Current Version:
    Version 0.1
    Version 0.2

Contributor: altair823

Description:
    The main function of yacht game program.
    only import rule handler, and only control sequence of the game.
 */


import rule.RuleHandler

fun main() {
    RuleHandler.gameStart()
    for (i in 1..12){
        RuleHandler.turns()
    }
    RuleHandler.end()
}

