package com.ucsc.automationcc.pkg001;

import com.ucsc.automationcc.models.databind.Student;
import org.testng.annotations.Test;

public class StudentTest extends Pkg001BaseTest {

    @Test(description = "TC-001", dataProvider = "commonDataProvider")
    public void verifyThatStudentDetailsAreCorrect(Student student){

        System.out.println(student.getName() + " : " + student.getAge());
    }
}
