package com.Everness.cubeadventures

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Esto quita la barra de estado para que el juego use toda la pantalla
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.myWebView)
        val settings: WebSettings = webView.settings

        // Configuraciones vitales para que el juego funcione
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true // Para guardar datos de partida
        settings.allowFileAccess = true
        settings.allowContentAccess = true

        // Evita que los enlaces se abran en Chrome, que se queden en tu app
        webView.webViewClient = WebViewClient()

        // Carga tu juego desde la carpeta assets
        webView.loadUrl("file:///android_asset/index.html")
    }

    // Para que si el usuario da atrás, no se cierre la app si el juego tiene menús
    override fun onBackPressed() {
        val webView: WebView = findViewById(R.id.myWebView)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}