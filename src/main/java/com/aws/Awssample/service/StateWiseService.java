package com.aws.Awssample.service;

import com.aws.Awssample.models.StateWise;

import java.io.IOException;
import java.util.List;

public interface StateWiseService {
    public List<StateWise> getStateWiseData() throws IOException, InterruptedException;
}
