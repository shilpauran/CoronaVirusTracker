package com.aws.Awssample.service;


import com.aws.Awssample.lookup.StateWiseLookupService;
import com.aws.Awssample.models.StateWise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("stateWiseService")
public class StateWiseServiceImpl implements StateWiseService{
    @Autowired
    private StateWiseLookupService stateWiseLookupService;
    @Override
    public List<StateWise> getStateWiseData() throws IOException, InterruptedException {

        return stateWiseLookupService.get();
    }
}
