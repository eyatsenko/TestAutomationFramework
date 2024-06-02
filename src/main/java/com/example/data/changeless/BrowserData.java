package com.example.data.changeless;

import java.util.Arrays;
import java.util.List;

public final class BrowserData {

    private BrowserData() {
    }

    private static final String START_MAXIMIZED = "--start-maximized";
    private static final String DISABLE_INFOBARS = "--disable-infobars";
    private static final String DISABLE_NOTIFICATIONS = "--disable-notifications";
    private static final String REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";
    private static final String GENERIC_HEADLESS = "-headless";
    private static final String CHROME_HEADLESS = "--headless=new";

    public static List<String> getDefaultOptions() {
        return Arrays.asList(
                START_MAXIMIZED,
                DISABLE_INFOBARS,
                DISABLE_NOTIFICATIONS,
                REMOTE_ALLOW_ORIGINS
        );
    }

    public static String getChromeHeadlessOption() {
        return CHROME_HEADLESS;
    }

    public static String getGenericHeadlessOption() {
        return GENERIC_HEADLESS;
    }


}
