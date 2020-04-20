package com.testcases;

import org.testng.annotations.Factory;

import com.pages.WebTest;

public class WebTestFactory {
	  @Factory
	  public Object[] createInstances() {
	   Object[] result = new Object[10]; 
	   for (int i = 0; i < 10; i++) {
	      result[i] = new WebTest(i * 10);
	    }
	    return result;
	  }
	}
