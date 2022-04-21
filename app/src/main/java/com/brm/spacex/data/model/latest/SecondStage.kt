package com.brm.spacex.data.model.latest

data class SecondStage(
    val block: Int,
    val payloads: List<Payload>
)