package com.mrms.suppletrack.presentation

import com.mrms.suppletrack.domain.supplement.Supplement
import com.mrms.suppletrack.presentation.convertor.toCommand
import com.mrms.suppletrack.presentation.dto.SupplementRegisterDto
import com.mrms.suppletrack.presentation.dto.SupplementUpdateDto
import com.mrms.suppletrack.usecase.SupplementUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api")
class SuppleTrackController
    @Autowired
    constructor(
        private val supplementUseCase: SupplementUseCase,
    ) {
        @PostMapping("/supplement")
        fun registerSupplement(
            @RequestBody supplementRegisterDto: SupplementRegisterDto,
        ): ResponseEntity<Unit> {
            supplementUseCase.createSupplement(supplementRegisterDto.toCommand())
            return ResponseEntity.ok().build()
        }

        @GetMapping("/supplements")
        fun getSupplements(): ResponseEntity<List<Supplement>> {
            val results = supplementUseCase.findAllSupplements()
            return ResponseEntity.ok(results)
        }

        @GetMapping("/supplement-group/")
        fun getSupplementGroup(): ResponseEntity<List<String>> {
            val results = supplementUseCase.findAllSupplementGroup()
            return ResponseEntity.ok(results)
        }

        @GetMapping("/supplement/{id}")
        fun getSupplementById(
            @PathVariable id: UUID,
        ): ResponseEntity<Supplement> {
            supplementUseCase.findSupplementById(id).let { result ->
                return if (result != null) {
                    ResponseEntity.ok(result)
                } else {
                    ResponseEntity.notFound().build()
                }
            }
        }

        @PatchMapping("/supplement/{id}")
        fun updateSupplement(
            @PathVariable id: UUID,
            @RequestBody supplementUpdateDto: SupplementUpdateDto,
        ): ResponseEntity<Unit> {
            supplementUseCase.updateSupplement(supplementUpdateDto.toCommand(id))
            return ResponseEntity.noContent().build()
        }

        @PatchMapping("/supplement/{id}/group")
        fun updateSupplementGroup(
            @PathVariable id: UUID,
            @RequestBody groupName: String?,
        ): ResponseEntity<Unit> {
            supplementUseCase.updateSupplementGroup(id, groupName)
            return ResponseEntity.noContent().build()
        }

        @DeleteMapping("/supplement/{id}")
        fun deleteSupplement(
            @PathVariable id: UUID,
        ): ResponseEntity<Unit> {
            supplementUseCase.deleteSupplement(id)
            return ResponseEntity.noContent().build()
        }

        @DeleteMapping("/supplement/group")
        fun deleteSupplementGroup(
            @RequestBody groupName: String,
        ): ResponseEntity<Unit> {
            supplementUseCase.deleteSupplementGroup(groupName)
            return ResponseEntity.noContent().build()
        }
    }
