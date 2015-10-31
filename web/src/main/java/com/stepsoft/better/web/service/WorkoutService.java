package com.stepsoft.better.web.service;

import com.stepsoft.better.web.model.WorkoutModel;
import org.springframework.stereotype.Service;

/**
 * @author Eugene Stepanenkov
 */
@Service
public class WorkoutService implements CrudService<WorkoutModel> {

    @Override
    public Long add(final WorkoutModel model) {
        return null;
    }

    @Override
    public void modify(final WorkoutModel model) {

    }

    @Override
    public void remove(final Long id) {

    }

    @Override
    public WorkoutModel find(final Long id) {
        return null;
    }
}
