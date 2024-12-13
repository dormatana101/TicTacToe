package com.example.tictactoe

import android.app.GameState
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var topleft: Button
    private lateinit var topcenter: Button
    private lateinit var topright: Button
    private lateinit var middleleft: Button
    private lateinit var middlecenter: Button
    private lateinit var middleright: Button
    private lateinit var bottomleft: Button
    private lateinit var bottomcenter: Button
    private lateinit var bottomright: Button
    private lateinit var restartButton: Button
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var gameState: TextView
    private lateinit var Board: Array<IntArray>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize buttons and text views
        topleft = findViewById(R.id.button_00)
        topcenter = findViewById(R.id.button_01)
        topright = findViewById(R.id.button_02)
        middleleft = findViewById(R.id.button_10)
        middlecenter = findViewById(R.id.button_11)
        middleright = findViewById(R.id.button_12)
        bottomleft = findViewById(R.id.button_20)
        bottomcenter = findViewById(R.id.button_21)
        bottomright = findViewById(R.id.button_22)
        restartButton = findViewById(R.id.restart_button)
        score1 = findViewById(R.id.player1_label)
        score2 = findViewById(R.id.player2_score)
        gameState = findViewById(R.id.game_status)
        Board = Array(3) { IntArray(3) { 0 } } //0 is empty, 1 is X, 2 is O

        // Set listener for restart button
        restartButton.setOnClickListener {
            resetGame()
        }
    }

    private fun resetGame() {
        // Clear the board
        topleft.text = ""
        topcenter.text = ""
        topright.text = ""
        middleleft.text = ""
        middlecenter.text = ""
        middleright.text = ""
        bottomleft.text = ""
        bottomcenter.text = ""
        bottomright.text = ""
        // Reset scores
        score1.text = "0"
        score2.text = "0"
    }
    fun CheckifBoardFull(): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                if (Board[i][j] == 0) {
                    return false
                }
            }
        }
        return true
    }
}
