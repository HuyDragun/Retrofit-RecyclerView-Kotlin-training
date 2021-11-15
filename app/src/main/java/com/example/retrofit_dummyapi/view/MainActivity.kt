package com.example.retrofit_dummyapi.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_dummyapi.databinding.ActivityMainBinding
import com.example.retrofit_dummyapi.model.User
import com.example.retrofit_dummyapi.model.UserPreview
import com.example.retrofit_dummyapi.model.UserRepository
import com.example.retrofit_dummyapi.presenter.MyAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: MyAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        //multiple binding
        with(binding){
           recyclerView.setHasFixedSize(true)
           recyclerView.layoutManager = linearLayoutManager
        }

        val call = UserRepository().getUser()

        call.enqueue(object: retrofit2.Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val responseBody = response.body()!!
                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }
        } )

//        recyclerView.setHasFixedSize(true)
//        linearLayoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = linearLayoutManager
//
//        getUser()
    }

//    private fun getUser() {
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(Base_URL)
//            .build()
//            .create(RetrofitInterface::class.java)
//
//        val retrofitData = retrofitBuilder.getData()
//
//        retrofitData.enqueue(object: Callback<List<UserPreview>?> {
//            override fun onResponse(
//                call: Call<List<UserPreview>?>,
//                response: Response<List<UserPreview>?>
//            ) {
//                val responseBody = response.body()!!
//                myAdapter = MyAdapter(baseContext, responseBody)
//                myAdapter.notifyDataSetChanged()
//                recyclerView.adapter = myAdapter
//
//
//
//            }
//
//            override fun onFailure(call: Call<List<UserPreview>?>, t: Throwable) {
//                Log.d("MainActivity", "onFailure" + t.message)
//            }
//        })
//    }
}
