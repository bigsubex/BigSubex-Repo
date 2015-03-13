package com.doj.big.web.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.doj.big.web.config.BigSubexContextLoadingTest;

public class MyTestRunner {
	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(BigSubexContextLoadingTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	  }
}
