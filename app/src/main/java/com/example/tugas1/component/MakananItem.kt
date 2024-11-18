package com.example.tugas1.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas1.R
import com.example.tugas1.model.Makanan
import com.example.tugas1.ui.theme.Tugas1Theme

@Composable
fun MakananItem(
    makanan: Makanan,
    modifier: Modifier,
    onItemClicked: (Int) -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onItemClicked(makanan.id)
            }
    ){
        Image(
            painter = painterResource(id = makanan.photo),
            contentDescription = makanan.name,
            modifier = Modifier.clip(RectangleShape).size(80.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = makanan.name,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(170.dp),
                maxLines = 1
            )
            Text(
                text = makanan.category,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(170.dp),
                maxLines = 1
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MakananItemHorizontak(){
    Tugas1Theme {
        MakananItem(
            makanan = Makanan(
                id = 1,
                name = "Mie Bangka",
                category = "Makanan Berat",
                photo = R.drawable.miebangka
            ),
            onItemClicked = { makananId ->
                println("Makanan Id: $makananId")
            },
            modifier = Modifier
        )
    }
}
