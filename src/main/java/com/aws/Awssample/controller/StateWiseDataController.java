package com.aws.Awssample.controller;

import com.aws.Awssample.models.StateWise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aws.Awssample.service.StateWiseService;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@RestController
public class StateWiseDataController {
    @Autowired
    private StateWiseService stateWiseService;

    public static List<StateWise> stateWiseList;

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void init(){
        try {
            stateWiseList=stateWiseService.getStateWiseData();
            System.out.println(stateWiseList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/AllData")
    public ResponseEntity test(){
        try {
            return new ResponseEntity<>(stateWiseService.getStateWiseData(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Some IO error occurred "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Some Interrupted error occurred "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/test")
    public String test1(){
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/state/{stateName}")
    public ResponseEntity getStateData(@PathVariable("stateName") String stateName){
        //stateWiseList.stream().filter(p->p.getState().equals(stateName)).forEach(p-> System.out.println(p.toString()));
        return new ResponseEntity<>(stateWiseList.stream().filter(p->p.getState().contains(stateName)),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/India")
    public ResponseEntity getIndiaData(){
        //stateWiseList.stream().filter(p->p.getState().equals(stateName)).forEach(p-> System.out.println(p.toString()));
        return new ResponseEntity<>(stateWiseList.stream().filter(p->p.getState().contains("Total")),HttpStatus.OK);
    }
}
