package com.company.service;

import org.testng.annotations.Test;

import com.acneuro.orchestration.customtask.sendword.client.SendWordWorkItemHandler;

public class TestCTW {

    @Test
    public void test() {
        new SendWordWorkItemHandler().executeWorkItem("fgf","teg");
    }
    
}
