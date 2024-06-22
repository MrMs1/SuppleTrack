package com.mrms.suppletrack.usecase

import com.mrms.suppletrack.domain.repository.SupplementRepository
import com.mrms.suppletrack.domain.supplement.Supplement
import com.mrms.suppletrack.usecase.dto.SupplementRegisterCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupplementUseCase
    @Autowired
    constructor(
        private val supplementRepository: SupplementRepository,
    ) {
        fun createSupplement(command: SupplementRegisterCommand) {
            val supplement =
                Supplement.create(
                    name = command.name,
                    quantity = command.quantity,
                    dosagePerUse = command.dosagePerUse,
                    dailyIntakeFrequency = command.dailyIntakeFrequency,
                    expiredAt = command.expiredAt,
                    startAt = command.startAt,
                    groupName = command.groupName,
                )
            supplementRepository.save(supplement)
        }
    }