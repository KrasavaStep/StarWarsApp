package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToVehicle
import com.example.domain.models.Id
import com.example.domain.models.VehicleModel
import com.example.domain.repositories.VehicleRepository

class VehicleRepositoryImpl(
    private val dao: StarWarsDao
): VehicleRepository {
    override suspend fun getVehicles(): List<VehicleModel> {
        return dao.getVehicles().map { it.mapToVehicle() }
    }

    override suspend fun getVehiclesById(ids: List<Id>): List<VehicleModel> {
        return dao.getVehiclesById(ids).map { it.mapToVehicle() }
    }
}