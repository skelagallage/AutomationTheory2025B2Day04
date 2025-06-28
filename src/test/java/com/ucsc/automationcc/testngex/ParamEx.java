package com.ucsc.automationcc.testngex;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamEx {

    @Test
    @Parameters("browserName")
    public void displayDetails(@Optional("firefox") String browserName){
        System.out.printf("Browser name is %s", browserName);
    }
}
