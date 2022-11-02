package com.example.tictactoe

import android.content.Context
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.tictactoev2.R

// TODO: Rename parameter arguments, choose names that match
private lateinit var viewModel: GameViewModel

class gameFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("jpk", "gameFragment->onCreate()")
    }
    fun testVictory(): Boolean {
        var clickableButtons = Gamestorage.buttons
        var voitto = Gamestorage.voitto

        //pystyrivit
        for (i in 0..2) {
            if (clickableButtons[i]==clickableButtons[i + 3] && clickableButtons[i]==
                clickableButtons[i + 6] && clickableButtons[i] != ""
            )
                voitto = true
        }
        for (i in 0..8 step 3) {
            if (clickableButtons[i]==clickableButtons[i + 1] && clickableButtons[i] ==
                clickableButtons[i + 2]  && clickableButtons[i] != ""
            )
                voitto = true
        }
        if (clickableButtons[0]==clickableButtons[4] && clickableButtons[0]==
            clickableButtons[8] && clickableButtons[0] != ""
        )
            voitto = true
        else if (clickableButtons[2]==clickableButtons[4] && clickableButtons[2]==
            clickableButtons[6] && clickableButtons[2] != ""
        )
            voitto = true

        return voitto

    }
    private val sharedViewModel: GameViewModel by activityViewModels()

    private lateinit var Gamestorage: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_game, container, false)

        // Inflate the layout for this fragment
        d("jpk","Gamefragment->onCreateView")

        Gamestorage = sharedViewModel

        var playerx = "Player 1"
        var playero = "Player 2"

        val infotext = view.findViewById<TextView>(R.id.winner_info)
        val loota1 = view.findViewById<Button>(R.id.button1)
        val loota2 = view.findViewById<Button>(R.id.button2)
        val loota3 = view.findViewById<Button>(R.id.button3)
        val loota4 = view.findViewById<Button>(R.id.button4)
        val loota5 = view.findViewById<Button>(R.id.button5)
        val loota6 = view.findViewById<Button>(R.id.button6)
        val loota7 = view.findViewById<Button>(R.id.button7)
        val loota8 = view.findViewById<Button>(R.id.button8)
        val loota9 = view.findViewById<Button>(R.id.button9)
        //val rootConstraintLayout = view.findViewById<View>(R.id.frameLayout1)
        val clickableButtons1 =
            arrayOf(loota1, loota2, loota3, loota4, loota5, loota6, loota7, loota8, loota9)
        var Winner = ""
        var turn = Gamestorage.turn
        for (item in 0..8) {
            val button = clickableButtons1[item]

            button.setOnClickListener {

                if (button.text == "" && Winner == "") {
                    Gamestorage.buttons[item] = if (turn % 2 == 0) "O" else "X"

                    if (testVictory()) {

                        if (turn % 2 == 0)
                            Winner = playero
                        else
                            Winner = playerx
                        infotext.setText("Player ${Winner} is winner!!!")
                        Gamestorage.infobox = infotext.text.toString()
                    }
                    turn++
                    Gamestorage.turn = turn
                    button.text = Gamestorage.buttons[item]
                }
            }
        }

        val newGame = view.findViewById<Button>(R.id.newgame_button1)
        newGame.setOnClickListener {
            for (i in 0..8){
                Gamestorage.buttons[i] = ""
            }
            Gamestorage.infobox = ""
            Gamestorage.turn = 1

        }


        val _playerx = view.findViewById<TextView>(R.id.editPlayer1)
        _playerx.setOnClickListener {
            val nicknameTextView = view.findViewById<TextView>(R.id.editPlayer1)
            Gamestorage.playerx = nicknameTextView.text.toString()
        }

        val _playero = view.findViewById<TextView>(R.id.editPlayer2)
        _playero.setOnClickListener {
            val nicknameTextView = view.findViewById<TextView>(R.id.editPlayer2)
            Gamestorage.playero = nicknameTextView.text.toString()
        }

        val settings = view.findViewById<Button>(R.id.settings_button)
        settings.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_configFragment)
        }
        val ranking = view.findViewById<Button>(R.id.ranking_button)
        ranking.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_rankingFragment)
        }


        for (i in 0..8){
            clickableButtons1[i].text = Gamestorage.buttons[i]
        }
        infotext.text = Gamestorage.infobox


        return view
    }

    override fun onResume() {
        super.onResume()
        d("jpk","gameFragment->onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        d("jpk","gameFragment->onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        d("jpk","gameFragment->onDestroyView")
    }

    override fun onPause() {
        super.onPause()
        d("jpk","gameFragment->onPause")
    }

    override fun onStart() {
        super.onStart()
        d("jpk","gameFragment->onStart")
    }

    override fun onStop() {
        super.onStop()
        d("jpk","gameFragment->onStop")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        d("jpk","gameFragment->onViewCreated")
    }
}
