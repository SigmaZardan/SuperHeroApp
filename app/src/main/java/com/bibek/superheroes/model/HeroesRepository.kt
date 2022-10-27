package com.bibek.superheroes.model

import com.bibek.superheroes.R

object HeroesRepository {

    val heroes = listOf(

        Hero(
            nameRes = R.string.hero_1,
            descriptionRes = R.string.description_1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero_2,
            descriptionRes = R.string.description_2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero_3,
            descriptionRes = R.string.description__3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero_4,
            descriptionRes = R.string.description_4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero_5,
            descriptionRes = R.string.description_5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero_6,
            descriptionRes = R.string.description_6,
            imageRes = R.drawable.android_superhero6
        )
    )
}