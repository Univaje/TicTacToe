package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.tictactoev2.R

class configFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_config, container, false)
        val back = view.findViewById<Button>(R.id.Back_button)
        back.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_configFragment_to_gameFragment)
        }
        return view
    }

}