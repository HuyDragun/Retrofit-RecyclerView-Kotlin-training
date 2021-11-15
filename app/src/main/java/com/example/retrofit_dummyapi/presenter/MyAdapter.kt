package com.example.retrofit_dummyapi.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_dummyapi.databinding.UserCardRowBinding
import com.example.retrofit_dummyapi.model.User
import com.example.retrofit_dummyapi.model.UserPreview
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val userData: List<User>): RecyclerView.Adapter<MyAdapter.ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(UserCardRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    class ItemsViewHolder(binding: UserCardRowBinding) : RecyclerView.ViewHolder(binding.root) {
        var userID = binding.uid
        var userFullName = binding.fullName
        var userPicture = binding.picture
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val userList = userData[position]
        holder.userID.text = userList.id
        val fullName = "${userList.title} ${userList.firstName} ${userList.lastName}"
        holder.userFullName.text = fullName

        Picasso.get()
            .load(userList.picture)
            .into(holder.userPicture)

        holder.itemView.setOnClickListener{
            Toast.makeText(context, fullName, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return userData.size
    }
}