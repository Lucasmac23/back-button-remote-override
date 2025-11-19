package com.strtv.app;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.getcapacitor.Logger;
import com.getcapacitor.Plugin;

public class BackButtonOverride {

    private boolean overrideEnabled = false;
    private boolean backPressedOnce = false;
    private final Handler handler = new Handler(Looper.getMainLooper());

    // --------------------------
    // Echo for testing
    // --------------------------
    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }

    // --------------------------
    // Enable back button override
    // --------------------------
    public void enableOverride() {
        overrideEnabled = true;
    }

    // --------------------------
    // Disable back button override
    // --------------------------
    public void disableOverride() {
        overrideEnabled = false;
    }

    // --------------------------
    // Called from Plugin.handleOnBackPressed()
    // --------------------------
    public boolean onBackPressed(Plugin plugin) {
        if (!overrideEnabled) {
            return false; // plugin should call super.handleOnBackPressed()
        }

        if (backPressedOnce) {
            return false; // second press → exit
        }

        backPressedOnce = true;

        // Show toast
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(() -> {
            Toast.makeText(plugin.getContext(), "Click back again to exit STR-TV", Toast.LENGTH_SHORT).show();
        });

        // Reset after 2 seconds
        mainHandler.postDelayed(() -> backPressedOnce = false, 2000);

        return true; // intercepted first press
    }
}
