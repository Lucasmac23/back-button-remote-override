package com.strtv.app;

import androidx.activity.OnBackPressedDispatcher;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BackButtonOverride")
public class BackButtonOverridePlugin extends Plugin {

    private BackButtonOverride implementation = new BackButtonOverride();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void enableOverride(PluginCall call) {
        implementation.enableOverride();
        call.resolve();
    }

    @PluginMethod
    public void disableOverride(PluginCall call) {
        implementation.disableOverride();
        call.resolve();
    }

    /**
     * New method exposed to JS: triggers the same logic as hardware back.
     */
    @PluginMethod
    public void homeBackPressed(PluginCall call) {
        boolean handled = implementation.handleBackPressFromJS(this);
        JSObject ret = new JSObject();
        ret.put("handled", handled);
        call.resolve(ret);
    }

    
    /**
     * Allows simulation of exiting from the app to the home screen
     */
    @PluginMethod
    public void exitToHomeScreen(PluginCall call) {
        implementation.exitToHomeScreen(this);
        JSObject ret = new JSObject();
        ret.put("handled", true);
        call.resolve(ret);
    }



    @Override
    public void load() {
        OnBackPressedDispatcher dispatcher = this.bridge.getActivity().getOnBackPressedDispatcher();
        dispatcher.addCallback(
            this.bridge.getActivity(),
            new androidx.activity.OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {

                    // 🔥 Emit event to Angular webview
                    notifyListeners("backButtonPressed", new JSObject());

                    boolean handled = implementation.onBackPressed(BackButtonOverridePlugin.this);

                    // if (!handled) {
                    //     // Allow system behavior
                    //     setEnabled(false);
                    //     dispatcher.onBackPressed();

                    //     setEnabled(true);
                    // }
                }
            }
        );
    }
}
