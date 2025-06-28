package com.ucsc.automationcc.testngex;

import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class DependsOnEx {

    @Test(dependsOnMethods = "verifyLogin")
    public void verifyDisplayUsername(){
        System.out.println("verifyDisplayUsername");
    }

    @Test
    public void verifyLogin(){
        System.out.println("verifyLogin");
    }

    @Test(dependsOnMethods = "verifyDisplayUsername")
    public void verifyFollowingMenu(){
        System.out.println("verifyFollowingMenu");
    }
}
