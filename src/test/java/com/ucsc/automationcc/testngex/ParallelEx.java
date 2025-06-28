package com.ucsc.automationcc.testngex;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelEx {

    public long startExecutionTimeInMills;

    @BeforeClass
    public void getStartTimeInMills(){
        startExecutionTimeInMills = System.currentTimeMillis();
    }

    @AfterClass
    public void displayExecutionTimeInMills(){
        System.out.println(System.currentTimeMillis() -
                startExecutionTimeInMills);
    }

    @Test
    public void method1() throws InterruptedException {
        for (int i=0; i<5; i++){
            Thread.sleep(5000);
            System.out.println("method1 :: " + i);
        }
    }

    @Test
    public void method2() throws InterruptedException {
        for (int i=0; i<5; i++){
            Thread.sleep(3000);
            System.out.println("method2 :: " + i);
        }
    }

    @Test
    public void method3() throws InterruptedException {
        for (int i=0; i<5; i++){
            Thread.sleep(2000);
            System.out.println("method3 :: " + i);
        }
    }

    @Test
    public void method4() throws InterruptedException {
        for (int i=0; i<5; i++){
            Thread.sleep(1000);
            System.out.println("method4 :: " + i);
        }
    }
}
