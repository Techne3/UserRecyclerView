package com.example.userrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this@MainActivity)[UserViewModel::class.java]
        with(binding){

            viewModel.users.observe(this@MainActivity){users ->
                userRv.apply{
                    adapter = UserAdapter(users)

                    layoutManager=
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                }
            }
            submitBtn.setOnClickListener{
                val firstName = firstNameEt.editText?.text.toString()
                val lastName = lastNameEt.editText?.text.toString()


                val user = User(firstName, lastName)

                viewModel.addUser(user)
            }

        }

    }
}