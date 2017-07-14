package test;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import util.DateUtil;

public class TimeTest {
	public static void main(String[] args) {
		Integer interval = 5;
		Boolean isEndTime = true;
		Map<String, String> mapStr = DateUtil.getDate(
				DateUtil.getString(new Date()), interval, isEndTime);
		for (Entry<String, String> string : mapStr.entrySet()) {
			System.out.println("key:" + string.getKey() + "  value:"
					+ string.getValue());
		}

	}
}