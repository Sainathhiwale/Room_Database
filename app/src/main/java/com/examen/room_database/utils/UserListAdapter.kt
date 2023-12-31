package com.examen.room_database.utils

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.examen.room_database.data.UserRegister
/*https://developer.android.com/codelabs/android-room-with-a-view-kotlin#11
*/
class UserListAdapter: ListAdapter<UserRegister, UserListAdapter.UserViewHolder>(WordsComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    class UserViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

    }

    class WordsComparator : DiffUtil.ItemCallback<UserRegister>() {
        override fun areItemsTheSame(oldItem: UserRegister, newItem: UserRegister): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UserRegister, newItem: UserRegister): Boolean {
           // return oldItem.word == newItem.word
            return oldItem == newItem
        }
    }

}


