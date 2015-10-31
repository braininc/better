package com.stepsoft.better.web.controller;

import com.stepsoft.better.web.service.CrudService;

/**
 * @author Eugene Stepanenkov
 */
public abstract class CrudController<M> extends AbstractCrudController<M> {

    protected abstract CrudService<M> getCrudService();

    @Override
    protected final Long add(final M model) {

        return getCrudService().add(model);
    }

    @Override
    protected final void modify(final M model) {

        getCrudService().modify(model);
    }

    @Override
    protected final void remove(final Long id) {

        getCrudService().remove(id);
    }

    @Override
    protected final M find(final Long id) {

        return getCrudService().find(id);
    }
}
