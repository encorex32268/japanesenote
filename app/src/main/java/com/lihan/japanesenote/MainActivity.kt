package com.lihan.japanesenote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Today
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lihan.japanesenote.core.model.BottomItem
import com.lihan.japanesenote.core.ui.AppBottomBar
import com.lihan.japanesenote.presentation.component.navigation.Route
import com.lihan.japanesenote.presentation.daily.DailyScreen
import com.lihan.japanesenote.presentation.home.HomeScreen
import com.lihan.japanesenote.ui.theme.JapanesenoteTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JapanesenoteTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomBar(
                            items = arrayListOf(
                                BottomItem(
                                    name = "Home",
                                    image = Icons.Default.Home,
                                    route = Route.HOME
                                ),
                                BottomItem(
                                    name = "Daily",
                                    image = Icons.Default.Today,
                                    route = Route.DAILY
                                )
                            ),
                            onItemClick ={
                                navController.navigate(it)
                            },
                            navController = navController
                        )
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.HOME)
                    {
                        composable(route = Route.HOME){
                            HomeScreen()
                        }
                        composable(route = Route.DAILY){
                            DailyScreen()
                        }
                    }
                }
            }
        }
    }
}
