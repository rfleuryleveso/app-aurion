package fr.rflv.appaurion.services.aurion.data

import fr.rflv.appaurion.services.aurion.models.IMark
import kotlinx.datetime.LocalDate

data class Mark(
    override val id: String,
    override val date: LocalDate,
    override val name: String,
    override val mark: Float,
    override val coefficient: Number
) : IMark