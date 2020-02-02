package com.tqt.javacommon.utils.model;

import java.util.ArrayList;
import java.util.List;

public class SubmitCountStepRequest {

    public List<StepCountUnit> listCountStep = new ArrayList<>();

    public SubmitCountStepRequest(List<StepCountUnit> listCountStep) {
        this.listCountStep = listCountStep;
    }

    public SubmitCountStepRequest() {
    }
}
