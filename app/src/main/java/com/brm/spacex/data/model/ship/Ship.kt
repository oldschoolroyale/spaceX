package com.brm.spacex.data.model.ship

data class Ship(
    val abs: Int,
    val active: Boolean,
    val attempted_landings: Any,
    val `class`: Int,
    val course_deg: Any,
    val home_port: String,
    val id: String,
    val image: String,
    val imo: Int,
    val missions: List<Mission>,
    val mmsi: Int,
    val model: Any,
    val name: String,
    val position: Position,
    val roles: List<String>,
    val speed_kn: Any,
    val status: String,
    val successful_landings: Any,
    val type: String,
    val url: String,
    val weight_kg: Int,
    val weight_lbs: Int,
    val year_built: Int
)