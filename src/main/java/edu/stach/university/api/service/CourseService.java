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

import edu.stach.university.api.data.model.Course;

import java.math.BigInteger;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/12/16
 */

public interface CourseService {
    /**
     * Returns all courses
     *
     * @return Rhe courses
     */
    public Iterable<Course> findAll();

    /**
     * Returns a course
     *
     * @param id the id of the courses
     * @return the course
     */
    public Course findOne(BigInteger id);

    /**
     * Creates a new course
     *
     * @param data The new course
     * @return The new course
     */
    public Course create(Course data);

    /**
     * Updates an existing course
     *
     * @param data The course to update
     * @return The updated course
     */
    public Course update(Course data);

    /**
     * Deletes a course
     *
     * @param id The id of the course
     */
    public void delete(BigInteger id);
}
