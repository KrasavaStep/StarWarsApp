package com.example.domain.usecase

import com.example.domain.models.Id
import com.example.domain.models.VehicleModel
import com.example.domain.repositories.VehicleRepository

class GetVehicleUseCase(val repository: VehicleRepository) {

    suspend operator fun invoke(ids: List<Id> = emptyList()): List<VehicleModel> {
        return if (ids.isEmpty()) {
            repository.getVehicles()
        } else {
            repository.getVehiclesById(ids)
        }
    }

}