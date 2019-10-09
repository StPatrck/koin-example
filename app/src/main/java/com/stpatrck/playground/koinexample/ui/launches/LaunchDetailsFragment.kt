package com.stpatrck.playground.koinexample.ui.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.stpatrck.playground.koinexample.R
import com.stpatrck.playground.koinexample.viewmodels.LaunchDetailViewModel
import org.koin.android.scope.currentScope

/**
 * A simple [Fragment] subclass responsible for displaying details for a specific Launch.
 */
class LaunchDetailsFragment : Fragment() {

    private val args: LaunchDetailsFragmentArgs by navArgs()
    private val launchDetailViewModel: LaunchDetailViewModel by currentScope.inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_second).text =
            launchDetailViewModel.getLaunchDetails(args.myArg)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_pop)
        }
    }
}
