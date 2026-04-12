package com.example.data.repositories

import com.example.domain.models.Id
import com.example.domain.models.VehicleModel
import com.example.domain.repositories.VehicleRepository

class VehicleRepositoryImpl: VehicleRepository {
    override suspend fun getVehicles(): List<VehicleModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getVehiclesById(ids: List<Id>): List<VehicleModel> {
        TODO("Not yet implemented")
    }
}