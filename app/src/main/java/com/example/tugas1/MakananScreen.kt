package com.example.tugas1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugas1.Data.DummyData
import com.example.tugas1.Navigation.Screen
import com.example.tugas1.component.MakananItem
import com.example.tugas1.model.Makanan

@Composable
fun MakananScreen(
    navController: NavHostController,
    makanan: List<Makanan> = DummyData.makanan
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(makanan, key = { it.id }){
                MakananItem(
                    makanan = it,
                    modifier = Modifier
                ) { makananId ->
                    navController.navigate(Screen.Detail.route + "/$makananId")
                }
            }
        }
    }
}
