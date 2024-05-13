package com.example.myretrofitproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofitproject.repository.Repository
import com.example.myretrofitproject.ui.theme.MyRetrofitProjectTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(owner = this, factory = viewModelFactory).get(
            MainViewModel::class.java
        )

        viewModel.getPost()
        viewModel.myResponse.observe(
            this,
            Observer {
                Log.d("Response: ", it.userId.toString())
                Log.d("Response: ", it.id.toString())
                Log.d("Response: ", it.title)
                Log.d("Response: ", it.body)
            }
        )


    }
}


