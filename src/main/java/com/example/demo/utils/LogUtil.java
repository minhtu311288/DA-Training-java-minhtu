package com.example.demo.utils;

import org.slf4j.LoggerFactory;

public class LogUtil {
	
	public static void info(Class<?> log, String msg) {
		
		 LoggerFactory.getLogger(log).info(msg);
		 
	}
	public static void debug(Class<?> log, String msg) {
		
		 LoggerFactory.getLogger(log).debug(msg);
		 
	}
	public static void error(Class<?> log, String msg) {
		
		 LoggerFactory.getLogger(log).error(msg);
		 
	}
	public static void warn(Class<?> log, String msg) {
		
		 LoggerFactory.getLogger(log).warn(msg);
		 
	}
}
