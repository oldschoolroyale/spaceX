package com.brm.spacex.data.model.latest

data class Core(
    val block: Int,
    val core: CoreX,
    val flight: Int,
    val gridfins: Boolean,
    val land_success: Boolean,
    val landing_intent: Boolean,
    val landing_type: String,
    val landing_vehicle: String,
    val legs: Boolean,
    val reused: Boolean
)