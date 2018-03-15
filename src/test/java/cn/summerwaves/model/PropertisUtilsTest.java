package cn.summerwaves.model;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class PropertisUtilsTest {

    @Test
    public void getProperties() {
        Map testMap = null;
        try {
            testMap = PropertisUtils.getProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(testMap);

    }
}