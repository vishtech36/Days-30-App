package com.vishtech.create30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishtech.create30daysapp.data.DataSource
import com.vishtech.create30daysapp.model.DayItem
import com.vishtech.create30daysapp.ui.theme.Create30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Create30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Create30DaysApp()
            }
        }
    }
}

@Composable
fun Create30DaysApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var index = 1
        LazyColumn {
            items(DataSource.getDayItems()) { item ->
                DayCard("Day $index", dayItem = item)
                index++
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Create30DaysAppTheme {
        Create30DaysApp()
    }
}

@Composable
fun DayCard(day: String, dayItem: DayItem) {

    var expand by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                expand = !expand
            },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Text(
                text = day,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = stringResource(id = dayItem.title),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )
            Image(
                painter = painterResource(id = dayItem.image),
                contentDescription = stringResource(id = dayItem.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop,
            )
            if (expand) {
                Text(
                    text = stringResource(id = dayItem.description),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}