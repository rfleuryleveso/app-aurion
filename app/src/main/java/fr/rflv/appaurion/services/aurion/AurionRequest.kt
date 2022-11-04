package fr.rflv.appaurion.services.aurion

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.CookieManager
import java.net.CookiePolicy


interface AurionRequest {
    suspend fun Login(email: String, password: String): Boolean;
    suspend fun GetHomePage(): Boolean;
}

class AurionRequestImpl : AurionRequest {
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

    override suspend fun Login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
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
                }
            return@withContext true;
        }

    }

    @WorkerThread()
    override suspend fun GetHomePage(): Boolean {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .get()
                .url("https://aurion.junia.com/")
                .build()

            client.newCall(request).execute();
            return@withContext true;
        }
    }
}