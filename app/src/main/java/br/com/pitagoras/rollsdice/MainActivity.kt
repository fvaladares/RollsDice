package br.com.pitagoras.rollsdice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.pitagoras.rollsdice.databinding.ActivityMainBinding


/**
 * This app simulate two dices that are rolled when the bottom is clicked.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Here we use the binding resource that makes easy work with the XML
     */
    private lateinit var binding: ActivityMainBinding
    private lateinit var dice: Dice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rollDice()
    }


    /**
     * This method rolls the dices and change the image images according
     * to the random number generated.
     */
    private fun rollDice() {
        dice = Dice(6)
        binding.btnRollDice.setOnClickListener {
            val diceRoll = dice.roll()
            val diceRoll2 = dice.roll()

            binding.dice1Image.setImageResource(selectResourceImage(diceRoll))
            binding.dice2Image.setImageResource(selectResourceImage(diceRoll2))
            binding.dice1Image.contentDescription = diceRoll.toString()
            binding.dice1Image.contentDescription = diceRoll2.toString()
        }
    }

    /**
     * Returns the image according to the dice face.
     */
    private fun selectResourceImage(diceFace: Int): Int {
        return when (diceFace) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}