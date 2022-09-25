package com.lihan.japanesenote.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lihan.japanesenote.core.model.BottomItem


@Composable
fun AppBottomBar(
    modifier : Modifier = Modifier,
    items : List<BottomItem>,
    onItemClick : (String) -> Unit,
    navController: NavController,
    itemTextSize  : TextUnit = 9.sp
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation{
        items.forEach {  item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                modifier = modifier.background(Color.White),
                selected =selected ,
                onClick = {
                    onItemClick(item.route)
                },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = item.image,
                            contentDescription = "${item.name}",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.name,
                            fontSize = itemTextSize,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            )
        }
    }
}