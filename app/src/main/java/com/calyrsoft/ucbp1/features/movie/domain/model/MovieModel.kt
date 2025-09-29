package com.calyrsoft.ucbp1.features.movie.domain.model

import com.calyrsoft.ucbp1.features.github.domain.model.UrlPath

data class MovieModel(
    val pathUrl: UrlPath,
    val title: String
)