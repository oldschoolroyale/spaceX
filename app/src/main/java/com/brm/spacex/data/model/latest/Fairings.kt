package com.brm.spacex.data.model.latest

data class Fairings(
    val recovered: Any,
    val recovery_attempt: Boolean,
    val reused: Boolean,
    val ship: String
)