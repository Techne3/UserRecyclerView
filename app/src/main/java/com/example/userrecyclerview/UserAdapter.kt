package com.example.userrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userrecyclerview.databinding.UserItemBinding

class UserAdapter(
    private val userList: List<User>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent,false)
        return UserViewHolder(binding)

    }


    /// inflating the VIEWHOLDER
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }


    // /this is the size of the item
    override fun getItemCount(): Int {
        return userList.size
    }


    //Attaches data to xml or our item
    class UserViewHolder(private val binding: UserItemBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            with(binding){
                firstNameTv.text = user.firstName
                lastNameTv.text = user.firstName
            }
        }
    }
}


