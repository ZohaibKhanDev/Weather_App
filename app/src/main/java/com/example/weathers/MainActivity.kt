package com.example.weathers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathers.di.appMoudle.appModule
import com.example.weathers.presentation.ui.navigation.NavEntry
import com.example.weathers.presentation.viewModel.MainViewModel
import com.example.weathers.ui.theme.WeathersTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeathersTheme {
                startKoin {
                    androidContext(this@MainActivity)
                    androidLogger()
                    modules(appModule)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavEntry()
                }
            }
        }
    }
}

