package com.stepsoft.better.web.controller;

import com.stepsoft.better.web.model.WorkoutModel;
import com.stepsoft.better.web.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.stepsoft.better.web.util.WebContextConstants.WORKOUTS;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Eugene Stepanenkov
 */
@Controller
@RequestMapping(value = WORKOUTS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class WorkoutController extends CrudController<WorkoutModel> {

    @Autowired
    private WorkoutService service;

    @Override
    protected final WorkoutService getCrudService() {
        return service;
    }
}
