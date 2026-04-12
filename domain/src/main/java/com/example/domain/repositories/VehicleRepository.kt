package com.example.domain.repositories

import com.example.domain.models.Id
import com.example.domain.models.VehicleModel

interface VehicleRepository {

    suspend fun getVehicles(): List<VehicleModel>
    suspend fun getVehiclesById(ids: List<Id>): List<VehicleModel>

}