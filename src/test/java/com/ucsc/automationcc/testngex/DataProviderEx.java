package com.ucsc.automationcc.testngex;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {

    @Test(dataProvider = "detailProvider")
    public void displayDetails(String name, int age){
        System.out.printf("Name is %s and age is %d \n", name, age);
    }

    @DataProvider
    public Object[][] detailProvider(){
        return new Object[][]{
                {"Shama", 22},
                {"Ishini", 26},
                {"Hashini", 33}
        };
    }
}
