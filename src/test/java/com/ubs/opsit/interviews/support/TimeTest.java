package com.ubs.opsit.interviews.support;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ubs.opsit.interviews.Time;

public class TimeTest {

	@Test
	public void testParse() {
		String aTime = "24:00:00";
		assertEquals(Time.parse(aTime).toString(), aTime);
	}

}
