package com.brm.spacex.data.model.latest

data class CoreX(
    val asds_attempts: Int,
    val asds_landings: Int,
    val block: Int,
    val id: String,
    val missions: List<Mission>,
    val original_launch: String,
    val reuse_count: Int,
    val rtls_attempts: Int,
    val rtls_landings: Int,
    val status: String,
    val water_landing: Boolean
)