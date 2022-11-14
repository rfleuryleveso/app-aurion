package fr.rflv.appaurion.services.aurion.impl.parsers

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister


@Serializable
data class CoursesListCourse(val id: String)

@Serializable
data class CoursesList(val events: Array<CoursesListCourse>)

val format = Json { ignoreUnknownKeys = true }


fun parsePartialPlanning(doc: String) {
    val serializer: Serializer = Persister()
    val aurionChangesDescription: AurionPartialResponse =
        serializer.read(AurionPartialResponse::class.java, doc)
    val viewState = extractViewStateFromPartial(aurionChangesDescription);

    val planningUpdate = aurionChangesDescription.aurionChanges.find { it.id == "form:j_idt117" }
    if (planningUpdate != null) {
        val courses: CoursesList = format.decodeFromString<CoursesList>(planningUpdate.text)
        println("Slava Ukraini");
    };

}