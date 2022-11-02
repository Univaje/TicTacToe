package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.tictactoev2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [rankingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class rankingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_ranking, container, false)

        val back = view.findViewById<Button>(R.id.back_button)
        back.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_rankingFragment_to_gameFragment)
        }
        return view
    }


}