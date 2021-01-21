package br.com.pitagoras.rollsdice

/**
 * This class represents a dice, and you can choose the number of faces using the constructor
 *
 * The roll method generate a pseudo-random number, simulating rolling dices
 */
class Dice (private val sideNumber: Int) {
    fun roll() : Int {
        return ((1..this.sideNumber).random())
    }
}