package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create new Dices object with 6 sides
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        // Find dices' ImageView in the layout
        val dice1Image: ImageView = findViewById(R.id.dice1ImageView)
        val dice2Image: ImageView = findViewById(R.id.dice2ImageView)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(dice1, dice1Image)
            rollDice(dice2, dice2Image)
        }

        rollDice(dice1, dice1Image)
        rollDice(dice2, dice2Image)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(dice: Dice, diceImage: ImageView) {
        val diceRoll = dice.roll()
        setDiceImage(diceRoll, diceImage)
    }

    private fun setDiceImage (diceRoll: Int, diceImageView: ImageView) {
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImageView.setImageResource(drawableResource)

        // Update the content description
        diceImageView.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}