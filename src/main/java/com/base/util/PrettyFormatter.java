package com.base.util;

import com.base.entity.Lector;

import java.util.List;

public class PrettyFormatter {

    public static String extractPrettyNamesForLectors(List<Lector> lectors) {
        final String[] result = {"Answer: "};
        if (lectors.isEmpty()) {
            result[0] = "Not found! Try another parameters.";
        } else {
            lectors.forEach(lector -> result[0] += "\n" + lector.getFirstName() + " " + lector.getLastName());
        }
        return result[0];
    }
}
