package com.example.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroapp.model.Hero
import com.example.superheroapp.model.heroes
import com.example.superheroapp.ui.theme.SuperheroesTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHero("Android")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHero(name: String, modifier: Modifier = Modifier){
    Scaffold (
        topBar = {
             TopBar()
        }
    ){it ->
        LazyColumn (contentPadding = it ){
            items(heroes) {
                HeroesScreen(
                    hero = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier.padding(bottom= 20.dp)){
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 33.sp
                )
            }
        }

    )

}

@Composable
fun HeroesScreen(hero : Hero, modifier: Modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))){
   Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
   ){
      Row (
          modifier = modifier
              .fillMaxWidth()
              .padding(dimensionResource(R.dimen.padding_small)),
          horizontalArrangement = Arrangement.SpaceBetween

      ) {
          HeroInfo(hero.name, hero.description)
          Spacer(modifier = Modifier.weight(1f))
          HeroIcon(Icon = hero.imageRes)

      }
   }
}
@Composable
fun HeroIcon(
    @DrawableRes Icon : Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(80.dp)
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(RoundedCornerShape(10.dp))
           ,
         painter = painterResource(id = Icon),
        contentDescription = null
    )
}
@Composable
fun HeroInfo(
    @StringRes heroname : Int,
    @StringRes herodesc : Int,
    modifier: Modifier = Modifier
    ){
    Column(modifier = modifier
    ){
        Text(
            text = stringResource(id = heroname),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(id = herodesc),
            fontWeight = FontWeight.Normal,
            modifier = Modifier.width(230.dp)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun SuperHeroPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperHero("Android")
    }
}

