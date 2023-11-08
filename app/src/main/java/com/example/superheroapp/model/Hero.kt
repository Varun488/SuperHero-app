package com.example.superheroapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroapp.R

data class Hero(
    @StringRes val name : Int,
    @StringRes val description : Int,
    @DrawableRes val imageRes : Int
)

    val heroes = listOf(
        Hero(
            name = R.string.hero1,
            description = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            name = R.string.hero2,
            description = R.string.description2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            name = R.string.hero3,
            description = R.string.description3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            name = R.string.hero4,
            description = R.string.description4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            name = R.string.hero5,
            description = R.string.description5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            name = R.string.hero6,
            description = R.string.description6,
            imageRes = R.drawable.android_superhero6
        )
    )

