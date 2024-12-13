package com.example.tictactoe

import android.app.GameState
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.widget.Toast


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
    private var PlayerTurn: Int? = null
    private var ButtonStatus: Boolean = true
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
        score1 = findViewById(R.id.player1_score)
        score2 = findViewById(R.id.player2_score)
        gameState = findViewById(R.id.game_status)

        PlayerTurn=1
        Board = Array(3) { IntArray(3) { 0 } } //0 is empty, 1 is X, 2 is O

        // Set listener for restart button
        restartButton.setOnClickListener {
            resetGame()
        }
        topleft.setOnClickListener(){
            if (topleft.text == ""){
                if(PlayerTurn==1)
                {
                    topleft.text = "X"
                    Board[0][0] = 1
                    PlayerTurn=2
                }
                else
                {
                    topleft.text = "O"
                    Board[0][0] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        topcenter.setOnClickListener(){
            if (topcenter.text == ""){
                if(PlayerTurn==1)
                {
                    topcenter.text = "X"
                    Board[0][1] = 1
                    PlayerTurn=2
                }
                else
                {
                    topcenter.text = "O"
                    Board[0][1] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        topright.setOnClickListener(){
            if (topright.text == ""){
                if(PlayerTurn==1)
                {
                    topright.text = "X"
                    Board[0][2] = 1
                    PlayerTurn=2
                }
                else
                {
                    topright.text = "O"
                    Board[0][2] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        middleleft.setOnClickListener(){
            if (middleleft.text == ""){
                if(PlayerTurn==1)
                {
                    middleleft.text = "X"
                    Board[1][0] = 1
                    PlayerTurn=2
                }
                else
                {
                    middleleft.text = "O"
                    Board[1][0] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        middlecenter.setOnClickListener(){
            if (middlecenter.text == ""){
                if(PlayerTurn==1)
                {
                    middlecenter.text = "X"
                    Board[1][1] = 1
                    PlayerTurn=2
                }
                else
                {
                    middlecenter.text = "O"
                    Board[1][1] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        middleright.setOnClickListener(){
            if (middleright.text == ""){
                if(PlayerTurn==1)
                {
                    middleright.text = "X"
                    Board[1][2] = 1
                    PlayerTurn=2
                }
                else
                {
                    middleright.text = "O"
                    Board[1][2] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        bottomleft.setOnClickListener(){
            if (bottomleft.text == ""){
                if(PlayerTurn==1)
                {
                    bottomleft.text = "X"
                    Board[2][0] = 1
                    PlayerTurn=2
                }
                else
                {
                    bottomleft.text = "O"
                    Board[2][0] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        bottomcenter.setOnClickListener(){
            if (bottomcenter.text == ""){
                if(PlayerTurn==1)
                {
                    bottomcenter.text = "X"
                    Board[2][1] = 1
                    PlayerTurn=2
                }
                else
                {
                    bottomcenter.text = "O"
                    Board[2][1] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }
        bottomright.setOnClickListener(){
            if (bottomright.text == ""){
                if(PlayerTurn==1)
                {
                    bottomright.text = "X"
                    Board[2][2] = 1
                    PlayerTurn=2
                }
                else
                {
                    bottomright.text = "O"
                    Board[2][2] = 2
                    PlayerTurn=1
                }
            }
            updateGameUI()
        }

        restartButton.setOnClickListener(){
            if(restartButton.text=="Play Again")
            {
                ClearBoard()
                restartButton.text="Restart"
            }
            else if(restartButton.text=="Restart")
            {
                resetGame()
            }
            updateGameUI()
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
        PlayerTurn = 1
        Board = Array(3) { IntArray(3) { 0 } }
        // Reset scores
        score1.text = "0"
        score2.text = "0"
        ButtonStatus=true
        DisableAndEnableButton()
        updateGameUI()
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
    private fun updateGameUI() {
        if(CheckIfWin()){
            ButtonStatus=false
            restartButton.text="Play Again"
            DisableAndEnableButton()
            return
        }
            if(CheckifBoardFull())
        {
            gameState.text = "Its a Draw"
            restartButton.text="Play Again"
            return
        }
        gameState.text = if (PlayerTurn == 1) "Player X's Turn" else "Player O's Turn"
    }

    private fun CheckIfWin(): Boolean {
        // Check rows
        for (i in 0..2) {
            if (Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2] && Board[i][0] != 0) {
                if (Board[i][0] == 1) {
                    gameState.text = "Player X Wins"
                    score1.text = (score1.text.toString().toInt() + 1).toString()
                } else {
                    gameState.text = "Player O Wins"
                    score2.text = (score2.text.toString().toInt() + 1).toString()
                }
                return true
            }
        }

        // Check columns
        for (i in 0..2) {
            if (Board[0][i] == Board[1][i] && Board[1][i] == Board[2][i] && Board[0][i] != 0) {
                if (Board[0][i] == 1) {
                    gameState.text = "Player X Wins"
                    score1.text = (score1.text.toString().toInt() + 1).toString()
                } else {
                    gameState.text = "Player O Wins"
                    score2.text = (score2.text.toString().toInt() + 1).toString()
                }
                return true
            }
        }

        // Check diagonals
        if (Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2] && Board[0][0] != 0) {
            if (Board[0][0] == 1) {
                gameState.text = "Player X Wins"
                score1.text = (score1.text.toString().toInt() + 1).toString()
            } else {
                gameState.text = "Player O Wins"
                score2.text = (score2.text.toString().toInt() + 1).toString()
            }
            return true
        }

        if (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0] && Board[0][2] != 0) {
            if (Board[0][2] == 1) {
                gameState.text = "Player X Wins"
                score1.text = (score1.text.toString().toInt() + 1).toString()
            } else {
                gameState.text = "Player O Wins"
                score2.text = (score2.text.toString().toInt() + 1).toString()
            }
            return true
        }

        return false // No win found
    }

    private fun ClearBoard() {

        Board = Array(3) { IntArray(3) { 0 } }
        topleft.text = ""
        topcenter.text = ""
        topright.text = ""
        middleleft.text = ""
        middlecenter.text = ""
        middleright.text = ""
        bottomleft.text = ""
        bottomcenter.text = ""
        bottomright.text = ""
        ButtonStatus=true
        DisableAndEnableButton()
        if (PlayerTurn == 1) {
            PlayerTurn = 2
        } else {
            PlayerTurn = 1
        }

    }
    private fun DisableAndEnableButton(){
        if(ButtonStatus==false)
        {
            topleft.isEnabled=false
            topcenter.isEnabled=false
            topright.isEnabled=false
            middleleft.isEnabled=false
            middlecenter.isEnabled=false
            middleright.isEnabled=false
            bottomleft.isEnabled=false
            bottomcenter.isEnabled=false
            bottomright.isEnabled=false
            ButtonStatus=true
        }
        else
        {
            topleft.isEnabled=true
            topcenter.isEnabled=true
            topright.isEnabled=true
            middleleft.isEnabled=true
            middlecenter.isEnabled=true
            middleright.isEnabled=true
            bottomleft.isEnabled=true
            bottomcenter.isEnabled=true
            bottomright.isEnabled=true
            ButtonStatus=false
        }
    }
}
