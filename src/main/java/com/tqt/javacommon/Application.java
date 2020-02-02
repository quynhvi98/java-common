package com.tqt.javacommon;

import com.tqt.javacommon.utils.model.SubmitCountStepRequest;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
//        SubmitCountStepRequest submitCountStepRequest = JSONUtils.jsonToObj(joConsumeData.getJsonObject("momoMsg"), SubmitCountStepRequest.class);

        SubmitCountStepRequest submitCountStepRequest = new SubmitCountStepRequest();

    }
}