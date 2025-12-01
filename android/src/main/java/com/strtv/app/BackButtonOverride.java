package com.strtv.app;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.getcapacitor.Logger;
import com.getcapacitor.Plugin;

public class BackButtonOverride {

    private boolean overrideEnabled = false;
    private boolean backPressedOnce = false;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }

    public void enableOverride() {
        overrideEnabled = true;
    }

    public void disableOverride() {
        overrideEnabled = false;
    }

    /**
     * Simulate pressing the Home button (send app to background).
     */
    public void exitToHomeScreen(Plugin plugin) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        plugin.getActivity().startActivity(intent);
        Toast.makeText(plugin.getContext(), "Click the STR-TV icon to return anytime.", Toast.LENGTH_LONG).show();

    }


    /**
     * Logic shared by both hardware back and JS-triggered back.
     */
    private boolean handleBack(Plugin plugin, Boolean isJS) {
        if (!overrideEnabled) {
            return false;
        }

        if (backPressedOnce) {
            this.exitToHomeScreen(plugin);
            return false; // second press → exit
        }
        
        if(isJS){
            backPressedOnce = true;

            // Show toast
            mainHandler.post(() ->
                Toast.makeText(plugin.getContext(), "Click back again to exit STR-TV", Toast.LENGTH_SHORT).show()
            );

            // Reset flag after 2 seconds
            mainHandler.postDelayed(() -> backPressedOnce = false, 2000);
        }
        

        return true; // handled
    }

    /**
     * Called from plugin's hardware back handler
     */
    public boolean onBackPressed(Plugin plugin) {
        return handleBack(plugin, false);
    }

    /**
     * Called from JS (homeBackPressed)
     */
    public boolean handleBackPressFromJS(Plugin plugin) {
         return handleBack(plugin, true);
    }
}
