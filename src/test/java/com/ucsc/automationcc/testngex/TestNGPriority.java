package com.ucsc.automationcc.testngex;

import org.testng.annotations.Test;

public class TestNGPriority {

    @Test(priority = 4)
    public void priorityA(){
        System.out.println("priorityA");
    }

    @Test(priority = 2)
    public void priorityB(){
        System.out.println("priorityB");
    }

    @Test(priority = 3)
    public void priorityC(){
        System.out.println("priorityC");
    }

    @Test(priority = 1)
    public void priorityD(){
        System.out.println("priorityD");
    }

    @Test
    public void noPriority(){
        System.out.println("noPriority");
    }
}
