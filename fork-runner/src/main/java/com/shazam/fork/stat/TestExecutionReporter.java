package com.shazam.fork.stat;

import com.shazam.fork.model.Device;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TestExecutionReporter {

    private final ConcurrentHashMap<Device, List<TestExecution>> tests = new ConcurrentHashMap<>();

    public void add(Device device, TestExecution time) {
        tests.computeIfPresent(device, (testIdentifier, testExecutionTimes) -> {
            testExecutionTimes.add(time);
            return testExecutionTimes;
        });
        tests.computeIfAbsent(device, testIdentifier -> new ArrayList<>());
    }

    public List<TestExecution> getTests(Device device) {
        List<TestExecution> list = tests.get(device);
        return list == null ? Collections.emptyList() : list;
    }
}
