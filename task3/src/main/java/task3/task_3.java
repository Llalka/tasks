package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class task_3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper yamlMapper = new YAMLMapper(new YAMLFactory());

        ValuesDTO testResults = yamlMapper.readValue(new File("values.json"), ValuesDTO.class);
        StructureDTO structure = yamlMapper.readValue(new File("tests.json"), StructureDTO.class);

        for (TestResult testResult : testResults.values) {
            insertTestResultsIntoStructure(structure.tests, testResult);
        }

        yamlMapper.writeValue(new File("report.json"), structure);
    }

    public static void insertTestResultsIntoStructure(List<TestResult> results, TestResult testResult) {
        for (TestResult emptyTestResult : results) {
            if (emptyTestResult.values != null && !emptyTestResult.values.isEmpty()) {
                insertTestResultsIntoStructure(emptyTestResult.values, testResult);
            }
            if (emptyTestResult.id == testResult.id) {
                emptyTestResult.value = testResult.value;
            }
        }
    }

    @Data
    static class TestResult {
        int id;
        String title;
        String value;
        List<TestResult> values;

    }

    @Data
    static class ValuesDTO {
        List<TestResult> values;
    }

    @Data
    static class StructureDTO {
        List<TestResult> tests;
    }
}