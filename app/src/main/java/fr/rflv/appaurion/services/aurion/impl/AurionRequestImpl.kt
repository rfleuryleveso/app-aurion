package fr.rflv.appaurion.services.aurion.impl

import fr.rflv.appaurion.services.aurion.impl.parsers.*
import fr.rflv.appaurion.services.aurion.interfaces.IAurionRequest
import fr.rflv.appaurion.services.aurion.interfaces.IAurionState
import kotlinx.datetime.*
import okhttp3.FormBody
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.koin.core.annotation.Single
import java.io.IOException
import java.net.CookieManager
import java.net.CookiePolicy
import java.time.format.DateTimeFormatter

@Single
class AurionRequestImpl(private val aurionState: IAurionState) : IAurionRequest {
    private val client: OkHttpClient;
    private val cookieManager = CookieManager();


    init {
        // Enforce the CookiePolicy
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        // Init the OkHttpClient with a cookiejar
        client = OkHttpClient()
            .newBuilder()
            .followRedirects(true)
            .cookieJar(JavaNetCookieJar(cookieManager))
            .build();
    }

    override fun Login(email: String, password: String): Boolean {
        // Create application/x-www-form-urlencoded form
        val formBody = FormBody.Builder()
            .add("username", email)
            .add("password", password)
            .add("j_idt38", "")
            .build()

        val request = Request.Builder()
            .post(formBody)
            .url("https://aurion.junia.com/login")
            .build()

        client.newCall(request)
            .execute()
            .use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")
                val body: String = response.body!!.string();
                val doc = Jsoup.parse(body);
                val viewStateValue = extractViewState(doc);
                this.aurionState.setState(viewStateValue);
                response.close();
            }
        return true;

    }

    override fun GetHomePage(): Boolean {
        val request = Request.Builder()
            .get()
            .url("https://aurion.junia.com/")
            .build()

        client.newCall(request).execute();
        return true;
    }

    override fun SwitchToPlanningView() {
        val formBody = FormBody.Builder()
            .add("form", "form")
            .add("form:largeurDivCenter", "69")
            .add("form:sauvegarde", "")
            .add("form:j_idt772_focus", "")
            .add("form:j_idt772_input", "44323")
            .add("javax.faces.ViewState", this.aurionState.getState())
            .add("form:sidebar", "form:sidebar")
            .add("form:sidebar_menuid", "1")
            .build()

        val request = Request.Builder()
            .post(formBody)
            .url("https://aurion.junia.com/faces/MainMenuPage.xhtml")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val body: String = response.body!!.string();
            val doc = Jsoup.parse(body);
            val viewStateValue = extractViewState(doc);
            this.aurionState.setState(viewStateValue);
            response.close();
        }
    }

    override fun GetPlanningPartial(
        start: LocalDateTime,
        end: LocalDateTime
    ): ArrayList<CoursesListCourse> {
        val dateInput =
            DateTimeFormatter.ofPattern("dd/MM/yyyy").format(start.toJavaLocalDateTime())
        val week = DateTimeFormatter.ofPattern("ww-yyyy").format(start.toJavaLocalDateTime())
        val formBody = FormBody.Builder()
            .add("javax.faces.partial.ajax", "true")
            .add("javax.faces.source", "form:j_idt117")
            .add("javax.faces.partial.execute", "form:j_idt117")
            .add("javax.faces.partial.render", "form:j_idt117")
            .add("form:j_idt117", "form:j_idt117")
            .add(
                "form:j_idt117_start",
                start.toInstant(TimeZone.UTC).toEpochMilliseconds().toString()
            )
            .add("form:j_idt117_end", end.toInstant(TimeZone.UTC).toEpochMilliseconds().toString())
            .add("form", "form")
            .add("form:largeurDivCenter", "")
            .add("form:date_input", dateInput)
            .add("form:week", week)
            .add("form:j_idt117_view", "agendaWeek")
            .add("form:offsetFuseauNavigateur", "0")
            .add("form:onglets_activeIndex", "0")
            .add("form:onglets_scrollState", "0")
            .add("form:j_idt236_focus", "")
            .add("form:j_idt236_input", "44323")
            .add("javax.faces.ViewState", this.aurionState.getState())

            .build()

        val request = Request.Builder()
            .post(formBody)
            .url("https://aurion.junia.com/faces/Planning.xhtml")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val body: String = response.body!!.string();
            val partialPlanningResult = parsePartialPlanning(body);
            this.aurionState.setState(partialPlanningResult.viewState)
            response.close();
            return partialPlanningResult.courses;
        }
    }

    override fun GetPlanningEventDetail(eventId: String): ParseEventPartialResult {
       val formBody = FormBody.Builder()
            .add("javax.faces.partial.ajax", "true")
            .add("javax.faces.source", "form:j_idt117")
            .add("javax.faces.partial.execute", "form:j_idt117")
            .add("javax.faces.partial.render", "form:modaleDetail form:confirmerSuppression")
            .add("javax.faces.behavior.event", "eventSelect")
            .add("javax.faces.partial.event", "eventSelect")
            .add("form:j_idt117_selectedEventId", eventId)
            .add("javax.faces.ViewState", this.aurionState.getState())

            .build()

        val request = Request.Builder()
            .post(formBody)
            .url("https://aurion.junia.com/faces/Planning.xhtml")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val body: String = response.body!!.string();
            val partialPlanningResult = parseEventPartial(body);
            this.aurionState.setState(partialPlanningResult.viewState)
            response.close();
            return partialPlanningResult;
        }
    }
}