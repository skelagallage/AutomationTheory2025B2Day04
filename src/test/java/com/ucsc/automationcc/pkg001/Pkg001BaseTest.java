package com.ucsc.automationcc.pkg001;

import com.ucsc.automationcc.BaseTest;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class Pkg001BaseTest extends BaseTest {

    @BeforeClass
    public void setResourceFilePath(){
        resourceFilePath = System.getProperty("user.dir")+ File.separator +"src"+
                File.separator +"main" +File.separator+ "resources" +File.separator+
                "AssertData" +File.separator+ "pkg001.xlsx";
    }
}
