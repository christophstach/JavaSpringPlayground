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

import edu.stach.university.api.data.model.Student;
import edu.stach.university.api.data.model.Student;

import java.math.BigInteger;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/12/16
 */

public interface StudentService {
    /**
     * Returns all students
     *
     * @return The students
     */
    public Iterable<Student> findAll();

    /**
     * Returns a student
     *
     * @param id The id of the students
     * @return The student
     */
    public Student findOne(BigInteger id);

    /**
     * Creates a new student
     *
     * @param data The new student
     * @return The new student
     */
    public Student create(Student data);

    /**
     * Updates an existing student
     *
     * @param data The student to update
     * @return The updated student
     */
    public Student update(Student data);

    /**
     * Deletes a student
     *
     * @param id The id of the student
     */
    public void delete(BigInteger id);
}
