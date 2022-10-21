package fr.rflv.appaurion.services.aurion

import android.icu.util.TimeUnit
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import java.net.CookieManager
import java.net.CookiePolicy


class AurionRequest {
    private val client: OkHttpClient;
    private val cookieManager = CookieManager();


    init {
        // Enforce the CookiePolicy
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        // Init the OkHttpClient with a cookiejar
        client = OkHttpClient()
            .newBuilder()
            .cookieJar(JavaNetCookieJar(cookieManager))
            .build();
    }


    fun Login(email: String, password: String) {

    }
}