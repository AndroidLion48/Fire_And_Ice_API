package com.eaglewarrior.gameofthronesinfoapp.repository.models


data class CharacterModel(
    var family: String,
    var firstName: String,
    var fullName: String,
    var id: Int,
    var image: String,
    var imageUrl: String,
    var lastName: String,
    var title: String
)
