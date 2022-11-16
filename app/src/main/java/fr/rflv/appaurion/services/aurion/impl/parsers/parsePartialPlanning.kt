package fr.rflv.appaurion.services.aurion.impl.parsers

import kotlinx.datetime.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME
import java.util.*
import kotlin.collections.ArrayList


@Serializable
data class CoursesListCourse(
    val id: String,
    val title: String,
    val start: String,
    val end: String,
    val allDay: Boolean,
    val editable: Boolean,
    val className: String
) {
    fun startDate(): LocalDateTime {
        val sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        val javaOffsetTime = OffsetDateTime.parse(this.start, sourceFormatter).toLocalDateTime();
        return javaOffsetTime.toKotlinLocalDateTime();
    }
    fun endDate(): LocalDateTime {
        val sourceFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        val javaOffsetTime = OffsetDateTime.parse(this.end, sourceFormatter).toLocalDateTime();
        return javaOffsetTime.toKotlinLocalDateTime();
    }
}

@Serializable
data class CoursesList(val events: ArrayList<CoursesListCourse>)

private val format = Json { ignoreUnknownKeys = true }

data class ParsePartialPlanningResult(val viewState: String, val courses: ArrayList<CoursesListCourse>);

fun parsePartialPlanning(doc: String): ParsePartialPlanningResult {
    val serializer: Serializer = Persister()
    val aurionChangesDescription: AurionPartialResponse =
        serializer.read(AurionPartialResponse::class.java, doc)
    val viewState = extractViewStateFromPartial(aurionChangesDescription);

    val planningUpdate = aurionChangesDescription.aurionChanges.find { it.id == "form:j_idt117" }
    if (planningUpdate != null) {
        val courses: CoursesList = format.decodeFromString<CoursesList>(planningUpdate.text)
        return ParsePartialPlanningResult(viewState, courses.events);
    };
    throw Error("Could not extract update courselist from AurionChanges");
}