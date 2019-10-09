package com.stpatrck.playground.koinexample.ui.launches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stpatrck.playground.koinexample.R
import com.stpatrck.playground.koinexample.ui.launches.LaunchListAdapter.OnLaunchClickListener

/**
 * A [RecyclerView.Adapter] responsible for inflating and binding the Launch list item layouts as
 * well as reporting back user selections through an [OnLaunchClickListener].
 *
 * @param items Mutable list of items to be displayed.
 * @param onLaunchClickListener [OnLaunchClickListener] that will receive click events when a Launch
 * is selected.
 */
class LaunchListAdapter(
    private val items: MutableList<String>,
    private val onLaunchClickListener: OnLaunchClickListener
) :
    RecyclerView.Adapter<LaunchListAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder =
        LaunchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listitem_launch,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(items[position], onLaunchClickListener)
    }

    override fun getItemCount() = items.count()

    /**
     * A simple [RecyclerView.ViewHolder] subclass that contains the Launch list item layout data.
     */
    class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String, onLaunchClickListener: OnLaunchClickListener) {
            itemView.findViewById<TextView>(R.id.textview_launch_name).text = item
            itemView.setOnClickListener { onLaunchClickListener.onLaunchClicked(item) }
        }
    }

    /**
     * A callback interface from which Launch selections are reported.
     */
    interface OnLaunchClickListener {

        /**
         * Invoked when a Launch list item is selected.
         *
         * @param launchName Name of the selected Launch item.
         */
        fun onLaunchClicked(launchName: String)
    }
}