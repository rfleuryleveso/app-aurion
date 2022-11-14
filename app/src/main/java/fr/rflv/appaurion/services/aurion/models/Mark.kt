package fr.rflv.appaurion.services.aurion.models

import kotlinx.datetime.LocalDate

interface Mark {
    val date: LocalDate;
    val id: String;
    val name: String;
    val mark: Float;
    val coefficient: Number;
}