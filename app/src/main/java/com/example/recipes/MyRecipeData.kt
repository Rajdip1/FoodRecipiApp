package com.example.recipes

data class MyRecipeData(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)