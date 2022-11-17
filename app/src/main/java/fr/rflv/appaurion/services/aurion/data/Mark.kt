package fr.rflv.appaurion.services.aurion.data

import fr.rflv.appaurion.services.aurion.models.IMark
import kotlinx.datetime.LocalDate

data class Mark(
    override val id: String,
    override val date: LocalDate,
    override val name: String,
    override val mark: Float,
    override val coefficient: Number
) : IMark {
    constructor(iMark: IMark) : this(
        id = iMark.id,
        date = iMark.date,
        name = iMark.name,
        mark = iMark.mark,
        coefficient = iMark.coefficient
    )
}