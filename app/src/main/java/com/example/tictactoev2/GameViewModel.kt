package com.example.tictactoe

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init {
        Log.i("perkele", "GameViewModel created!")
    }
    var voitto: Boolean = false
    var buttons = arrayOf("","" ,"" ,"" , "", "", "", "", "")
    var turn=1
    var playerx="Player 1"
    var playero="Player 2"
    var infobox = ""

    override fun onCleared() {
        super.onCleared()
        Log.i("perkele","Gameviewmodel destroyed!")
    }
}