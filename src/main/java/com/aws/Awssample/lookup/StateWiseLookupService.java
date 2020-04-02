package com.aws.Awssample.lookup;

import com.aws.Awssample.models.StateWise;

import java.io.IOException;
import java.util.List;

public interface StateWiseLookupService {
    public List<StateWise> get() throws IOException, InterruptedException;
}
