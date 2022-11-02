package com.example.tictactoe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tictactoev2.R
import com.google.android.material.bottomnavigation.BottomNavigationView

/*
v1->v2
1) Add Navigation resource file
2) Add ConfigFragment, GameFragment and RankingFragment
3) Insert Navigation Paths between game->ranking and game->config
4) Move Buttons, TableLayout and everything else from activity_main.xml to fragment_game.xml
5) Insert NavHostFragment to activity_main.xml
6) Move game logic from MainActivity.kt to gameFragment.kt. Note that you shall not use kotlinx.android.synthetic.main...
   delivered labels. Instead, use  "val btn11=view.findViewById<Button>(R.id.button11)". You may remove
   androidx.lifecycle:lifecycle-viewmodel-ktx from build.gradle (:app).
7) Insert Log message to each of following methods and find out when fragments are created:
     - onCreate()
     - onCreateView()
     - onResume()
     - onDestroy()
     - onDestroyView()
     - onPause()
     - onStart()
     - onStop()
     - onViewCreated()
8) Find out why game state is lost when fragment is changed when game is on.

v2->v3
1) Create a new Kotlin class MainViewModel
2) Add init, and onCleared(), add log print on them
3) Add following to gameFragment:
  private lateinit var viewModel : MainViewModel
  private val sharedViewModel: MainViewModel by activityViewModels()

  and to gameFragment.onCreateView():
  viewModel=sharedViewModel

5) If build does not complete, add to build.gradle (:app)
    compileOptions {
        sourceCompatibility = 1.8
        targetCompatibility = 1.8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

v3->v4
1) build.gradle (:app):
    apply plugin: 'kotlin-kapt'

    .
    .
    .

    implementation "androidx.room:room-ktx:$room_version"
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"

2) build.gradle (TicTacToe):
    ext.room_version = '2.2.5'
3) Create GameTables.kt
@Entity
data class Game(
    @PrimaryKey val id : Int,
    @ColumnInfo(name="playerX") val playerX : String,
    @ColumnInfo(name="player0") val player0 : String,
    @ColumnInfo(name="winner") val winner : Int
)

4) Create ScoreDatabaseDao.kt - Contains ScoreDatabaseDAO interface

5) Create ScoreDatabase.kt

6) When game ends, save result to database. In addition, read content of the DB

 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

}