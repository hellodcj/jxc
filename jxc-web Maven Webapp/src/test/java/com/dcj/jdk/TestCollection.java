package com.dcj.jdk;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class TestCollection extends TestCase {

	/**
	 * 数组转化为ArrayList
	 */
	@Test
	public void testArraysAsList(){
		List<Integer> list = Arrays.asList(1,2,3);
		System.out.println(list);
	}
}
