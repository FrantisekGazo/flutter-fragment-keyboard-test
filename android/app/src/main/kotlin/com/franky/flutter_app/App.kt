package com.franky.flutter_app

import io.flutter.app.FlutterApplication

class App : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()

        initFlutterEngine(this)
    }
}
