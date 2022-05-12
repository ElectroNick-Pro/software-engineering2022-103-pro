package com.group2022103.flightkiosk.util;

import java.util.Arrays;

import com.group2022103.flightkiosk.application.Application;

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
	
	public static String toMD5(String str) {
		var dig = Application.context.getAppConfig().getDigest();
        dig.reset();
        dig.update(str.getBytes());
        var bytes = dig.digest();
        var ret = new StringBuilder();
        for(var b : bytes) {
            ret.append(String.format("%02x", b & 0xff));
        }
        return ret.toString();
	}
}
