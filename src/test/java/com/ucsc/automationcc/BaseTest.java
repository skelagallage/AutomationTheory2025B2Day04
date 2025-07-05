package com.ucsc.automationcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucsc.automationcc.fileio.ExcelHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class BaseTest {

    protected String resourceFilePath;

    @DataProvider
    public Object[][] commonDataProvider(Method method) throws IOException {
        String tcId = method.getAnnotation(Test.class).description();
        Class<?>[] paramTypes = method.getParameterTypes();
        Class<?> param = Arrays.stream(paramTypes).findFirst().get();

        List<Map<String, String>> excelData = ExcelHandler.readExcel(resourceFilePath, tcId);
        Object[][] returnArr = new Object[excelData.size()][1];
        ObjectMapper objectMapper = new ObjectMapper();
        IntStream.range(0, excelData.size()).forEach(index -> {
            returnArr[index][0] = objectMapper.convertValue(excelData.get(index), param);
        });
        return returnArr;
    }
}
