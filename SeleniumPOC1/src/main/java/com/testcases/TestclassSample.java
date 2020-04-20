package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.MyRetry;
 
public class TestclassSample {
 
  @Test(retryAnalyzer = MyRetry.class)
  public void test2() {
	  System.out.println("retry analyse");
    Assert.fail();
  }
}
