package com.stpatrck.playground.koinexample.ui.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stpatrck.playground.koinexample.R
import com.stpatrck.playground.koinexample.viewmodels.LaunchListViewModel
import org.koin.android.scope.currentScope

/**
 * A simple [Fragment] subclass responsible for displaying a list of Launches. When a Launch is
 * selected the [LaunchDetailsFragment] destination is invoked.
 */
class LaunchListFragment : Fragment(),
    LaunchListAdapter.OnLaunchClickListener {

    private val launchListViewModel: LaunchListViewModel by currentScope.inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val launches = mutableListOf<String>()
        launches.addAll(launchListViewModel.getAllLaunches())

        view.findViewById<RecyclerView>(R.id.list_launches).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = LaunchListAdapter(
                launches,
                onLaunchClickListener = this@LaunchListFragment
            )
        }
    }

    override fun onLaunchClicked(launchName: String) {
        val action =
            LaunchListFragmentDirections.actionFirstFragmentToSecondFragment(
                launchName
            )
        findNavController().navigate(action)
    }
}
