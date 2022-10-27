    package com.bibek.superheroes

import SuperHeroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bibek.superheroes.model.Hero
import com.bibek.superheroes.model.HeroesRepository.heroes

    class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   SuperHeroApp()
                }
            }
        }
    }
}



@Composable
fun SuperHeroApp(modifier : Modifier = Modifier) {
    Scaffold(
       topBar = { SuperHeroAppBar() }
    )
    {
        LazyColumn(
            modifier = modifier.background(MaterialTheme.colors.background)
        ) {
           items(heroes){
               SuperHeroItem(superhero = it)
           }
        }
    }

}

@Composable
fun SuperHeroItem(superhero : Hero, modifier : Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 2.dp
    ) {

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            SuperHeroInformation(superhero.nameRes , superhero.descriptionRes)
            SuperHeroIcon(superHeroIcon = superhero.imageRes)



        }



    }

}


    @Composable
    fun SuperHeroInformation(
        @StringRes superHeroName : Int ,
        @StringRes superHeroDescription : Int,
        modifier : Modifier = Modifier
    ) {

        Column(

            modifier = modifier.width(265.dp)


        ) {

            Text(
                modifier= modifier.padding(start = 16.dp),
                text = stringResource(superHeroName),
                style = MaterialTheme.typography.h3

            )
            Text(
                modifier = modifier.padding(start = 16.dp),
                text = stringResource(superHeroDescription),
                style = MaterialTheme.typography.body1 ,


            )
        }

    }

    @Composable
    fun SuperHeroIcon(
        @DrawableRes superHeroIcon : Int,
        modifier : Modifier = Modifier) {

    Image(
        modifier = modifier
            .size(100.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp)),
        painter = painterResource(superHeroIcon) ,
        contentDescription = null )

    }

    @Composable
    fun SuperHeroAppBar(modifier : Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background) ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.app_name) ,
                style = MaterialTheme.typography.h1
            )
        }
    }








@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroesTheme {
       SuperHeroApp()
    }
}