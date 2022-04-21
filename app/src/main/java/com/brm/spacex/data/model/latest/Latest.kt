package com.brm.spacex.data.model.latest

data class Latest(
    val details: Any,
    val id: String,
    val is_tentative: Boolean,
    val launch_date_local: String,
    val launch_date_unix: Int,
    val launch_date_utc: String,
    val launch_site: LaunchSite,
    val launch_success: Boolean,
    val launch_year: String,
    val links: Links,
    val mission_id: List<Any>,
    val mission_name: String,
    val rocket: Rocket,
    val ships: List<Ship>,
    val static_fire_date_unix: Int,
    val static_fire_date_utc: String,
    val telemetry: Telemetry,
    val tentative_max_precision: String,
    val upcoming: Boolean
)