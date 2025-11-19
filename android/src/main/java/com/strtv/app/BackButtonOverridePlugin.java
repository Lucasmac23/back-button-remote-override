package com.strtv.app;
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
        JSObject ret = new JSObject();
        implementation.enableOverride();
        call.resolve(ret);
    }

      @PluginMethod
    public void disableOverride(PluginCall call) {
        JSObject ret = new JSObject();
        implementation.disableOverride();
        call.resolve(ret);
    }

    @Override
        public void load() {
            // Called when the plugin is loaded
            this.bridge.getActivity().getOnBackPressedDispatcher().addCallback(
                this.bridge.getActivity(),
                new androidx.activity.OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        boolean handled = implementation.onBackPressed(BackButtonOverridePlugin.this);
                        if (!handled) {
                            // Let the default behavior run
                            setEnabled(false);
                            BackButtonOverridePlugin.this.bridge.getActivity().onBackPressed();
                            setEnabled(true);
                        }
                    }
                }
            );
        }


}
