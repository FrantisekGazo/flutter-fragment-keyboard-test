package com.franky.flutter_app

import android.content.Context
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.FlutterJNI
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.engine.loader.FlutterLoader
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry
import io.flutter.plugins.GeneratedPluginRegistrant

private const val FLUTTER_ENGINE_ID = "flutter_engine"

fun initFlutterEngine(context: Context) {
    // Instantiate cached FlutterEngine.
    val flutterEngine = FlutterEngine(
            context,
            FlutterLoader.getInstance(),
            FlutterJNI(),
            arrayOf<String>(), // or an empty array if no args needed
            false // this arg instructs the FlutterEngine NOT to register plugins automatically
    )

    // Start executing Dart code in the FlutterEngine.
    val dartEntrypoint = DartExecutor.DartEntrypoint.createDefault()
    flutterEngine.dartExecutor.executeDartEntrypoint(dartEntrypoint)

    // Cache the pre-warmed FlutterEngine to be used later by FlutterFragment.
    FlutterEngineCache.getInstance().put(FLUTTER_ENGINE_ID, flutterEngine)

    // Immediately add plugins to the cached FlutterEngine.
    // The ShimPluginRegistry is how the v2 embedding works with v1 plugins.
//    val shimPluginRegistry = ShimPluginRegistry(flutterEngine)

    // Add any v1 plugins to the shim
    GeneratedPluginRegistrant.registerWith(flutterEngine)

    // Add any v2 plugins that you want
    // engine.getPlugins().add(new MyPlugin());
}

fun initFlutterFragment(): FlutterFragment {
    return FlutterFragment.withCachedEngine(FLUTTER_ENGINE_ID)
            .build()
}
