package com.banlv.road.util;

import java.util.List;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/9/24 10:30
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class ReflectionsUtil {

    private Reflections reflections = new Reflections("com.banlv.road.util");

    public void getSubForList() {
        SubTypesScanner subTypesScanner = new SubTypesScanner();
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        FilterBuilder filter = new FilterBuilder()
                .includePackage("com.banlv.raod.model")
                .excludePackage("")
        subTypesScanner.filterResultsBy()
        Set<Class<? extends List>> listImpls = reflections.getSubTypesOf(List.class);
        listImpls.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ReflectionsUtil reflectionsUtil = new ReflectionsUtil();
        reflectionsUtil.getSubForList();
    }
}
