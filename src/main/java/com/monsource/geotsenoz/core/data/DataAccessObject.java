package com.monsource.geotsenoz.core.data;

import java.io.Serializable;

public interface DataAccessObject<E extends DataEntity> {

	/**
	 * 
	 * @param entity
	 */
	E merge(E entity);

	/**
	 * 
	 * @param entity
	 */
	E persist(E entity);

	/**
	 * 
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * 
	 * @param id
	 */
	E get(Serializable id);

    /**
     *
     */
    void flush();

    /**
     * @param autoFlush
     */
    public void setAutoFlush(boolean autoFlush);
}