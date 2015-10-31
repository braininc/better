package com.stepsoft.better.web.service;

/**
 * @author Eugene Stepanenkov
 */
public interface CrudService<M> {

    Long add(M model);

    void modify(M model);

    void remove(Long id);

    M find(Long id);
}
