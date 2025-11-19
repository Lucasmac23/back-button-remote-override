package com.strtv.app;

import com.getcapacitor.Logger;

public class BackButtonOverride {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }
}
