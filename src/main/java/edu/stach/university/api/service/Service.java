/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.api.service;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/13/16
 */
public interface Service<T> {
    /**
     * returns all entities
     *
     * @return the entities
     */
    public Collection<T> findAll();

    /**
     * returns an entity
     *
     * @param id the id of the entity
     * @return the entity
     */
    public T findOne(BigInteger id);

    /**
     * creates a new entity
     *
     * @param data the new entity
     * @return the new entity
     */
    public T create(T data);

    /**
     * updates an existing entity
     *
     * @param data the entity to update
     * @return the updated entity
     */
    public T update(T data);

    /**
     * deletes an entity
     *
     * @param id the id of the entity
     */
    public void delete(BigInteger id);
}
