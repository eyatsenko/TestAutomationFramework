package com.example.report;

import com.example.enums.Target;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static com.example.config.ConfigurationManager.configuration;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        var basicInfo = new HashMap<>(Map.of(
                "Test URL", configuration().url(),
                "Target execution", configuration().target(),
                "Global timeout", String.valueOf(configuration().timeout()),
                "Headless mode", String.valueOf(configuration().headless()),
                "Faker locale", configuration().faker(),
                "Local browser", configuration().browser()
        ));

        if (configuration().target().equals(Target.SELENIUM_GRID.name())) {
            var gridMap = Map.of("Grid URL", configuration().gridUrl(), "Grid port", configuration().gridPort());
            basicInfo.putAll(gridMap);
        }

        AllureEnvironmentWriter.allureEnvironmentWriter(ImmutableMap.copyOf(basicInfo));
    }
}
