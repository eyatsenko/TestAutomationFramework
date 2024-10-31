package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

@AllArgsConstructor
@Getter
public enum Target {

    LOCAL("local"),
    LOCAL_SUITE("local-suite"),
    SELENIUM_GRID("selenium-grid"),
    TESTCONTAINERS("testcontainers");

    private final String value;
    private static final Map<String, Target> ENUM_MAP;

    static {
        Map<String, Target> map = new HashMap<>();
        stream(Target.values()).forEach(instance -> map.put(instance.value.toLowerCase(),
                                                    map.getOrDefault(instance.value.toLowerCase(), instance)));
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Target get(String value) {
        if (!ENUM_MAP.containsKey(value.toLowerCase()))
            throw new IllegalArgumentException(String.format("Value %s not valid. Use one of the TARGET enum values",
                                                                                                                value));
        return ENUM_MAP.get(value.toLowerCase());
    }
}
