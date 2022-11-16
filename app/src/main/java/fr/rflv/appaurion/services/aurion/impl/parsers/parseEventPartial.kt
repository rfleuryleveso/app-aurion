package fr.rflv.appaurion.services.aurion.impl.parsers

import kotlinx.serialization.json.Json
import org.jsoup.Jsoup
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister

data class EventDetails(
    val teachers: List<Pair<String, String>>,
    val rooms: List<String>,
    val students: List<Pair<String, String>>,
    val groups: List<String>,
    val modules: List<Pair<String, String>>,
    val attributes: List<Pair<String, String>>,
);

data class ParseEventPartialResult(val viewState: String, val details: EventDetails);

private val format = Json { ignoreUnknownKeys = true }

fun parseEventPartial(doc: String): ParseEventPartialResult {
    val serializer: Serializer = Persister()
    val aurionChangesDescription: AurionPartialResponse =
        serializer.read(AurionPartialResponse::class.java, doc)
    val viewState = extractViewStateFromPartial(aurionChangesDescription);

    val planningUpdate =
        aurionChangesDescription.aurionChanges.find { it.id == "form:modaleDetail" }
    val doc = Jsoup.parse(planningUpdate!!.text);

    // Extract teachers informations
    val teachersElement = doc.getElementById("form:onglets:j_idt171_data")
    val teachersList = teachersElement!!.getElementsByTag("tr");
    val teachers = teachersList.map {
        val tdTags = it.getElementsByTag("td");
        if (tdTags.count() >= 2) {
            val firstName = tdTags[0].text()
            val lastName = tdTags[1].text();
            return@map Pair(firstName, lastName);
        } else {
            return@map Pair("", "");
        }
    }
    // Extract rooms
    val roomsElement = doc.getElementById("form:onglets:j_idt163_data")
    val roomsList = roomsElement!!.getElementsByTag("tr");
    val rooms = roomsList.map {
        val tdTags = it.getElementsByTag("td");
        if (tdTags.isNotEmpty()) {
            return@map tdTags[0].text();
        } else {
            return@map "Aucune classe";
        }
    }
    // Extract students
    val studentsElement = doc.getElementById("form:onglets:apprenantsTable_data")
    val studentsList = studentsElement!!.getElementsByTag("tr");
    val students = studentsList.map {
        val tdTags = it.getElementsByTag("td");
        if (tdTags.count() >= 2) {
            val firstName = tdTags[0].text()
            val lastName = tdTags[1].text();
            return@map Pair(firstName, lastName);
        } else {
            return@map Pair("", "");
        }
    }

    // Extract groups
    val groupsElements = doc.getElementById("form:onglets:j_idt210_data")
    val groupsList = groupsElements!!.getElementsByTag("tr");
    val groups = groupsList.map {
        val tdTags = it.getElementsByTag("td");
        if (tdTags.isNotEmpty()) {
            return@map tdTags[0].text();
        } else {
            return@map "Aucune classe";
        }
    }

    // Extract modules
    val modulesElements = doc.getElementById("form:onglets:j_idt215_data")
    val modulesList = modulesElements!!.getElementsByTag("tr");
    val modules = modulesList.map {
        val tdTags = it.getElementsByTag("td");
        if (tdTags.count() >= 2) {
            val course = tdTags[0].text()
            val module = tdTags[1].text();
            return@map Pair(course, module);
        } else {
            return@map Pair("", "");
        }
    }

    // Extract modules
    val attributesElements = doc.getElementById("form:j_idt151_content")
    val attributesList = attributesElements!!.children();
    val attributes = attributesList.map {
        val divAttributes = it.children();
        if (divAttributes.count() >= 2) {
            val name = divAttributes[0].text()
            val value = divAttributes[1].text();
            return@map Pair(name, value);
        } else {
            return@map Pair("", "");
        }

    }


    return ParseEventPartialResult(
        viewState,
        EventDetails(teachers, rooms, students, groups, modules, attributes)
    )
}