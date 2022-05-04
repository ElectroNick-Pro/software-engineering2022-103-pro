package com.group2022103.flightkiosk.util;

import java.util.Arrays;

public class CsvUtil {

	public static String[] splitLine(String str) {
        if(str.endsWith(",")) {
            str += ",-";
            var res = str.split(",");
            return Arrays.copyOf(res, res.length - 1);
        } else {
            return str.split(",");
        }
    }
}
