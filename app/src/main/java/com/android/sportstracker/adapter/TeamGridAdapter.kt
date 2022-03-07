package com.android.sportstracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.sportstracker.databinding.TeamPickerFragmentBinding
import com.android.sportstracker.network.Team

class TeamGridAdapter :
    ListAdapter<Team, TeamGridAdapter.TeamViewHolder>(DiffCallback) {

        open class TeamViewHolder(
            private var binding: TeamPickerFragmentBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(team: Team) {
                binding.team = team

                binding.executePendingBindings()
            }
        }


        companion object DiffCallback : DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
                return oldItem.strTeamLogo == newItem.strTeamLogo
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ) : TeamViewHolder {
            return TeamViewHolder(
                TeamPickerFragmentBinding.inflate(LayoutInflater.from(parent.context))
            )
        }

        override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
            val team = getItem(position)
            holder.bind(team)
        }
}