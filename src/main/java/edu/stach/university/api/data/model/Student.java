/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.api.data.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigInteger;
import java.util.List;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/12/16
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private BigInteger id;

    private String firstName;
    private String lastName;

    @ManyToMany
    private List<Course> courses;


    /**
     * Constructor
     */
    public Student() {

    }

    /**
     * Constructor
     *
     * @param firstName The firstName
     * @param lastName  The lastName
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor
     *
     * @param firstName The firstName
     * @param lastName  The lastName
     * @param courses   The courses
     */
    public Student(String firstName, String lastName, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    /**
     * Getter for id
     *
     * @return The id
     */
    public BigInteger getId() {
        return this.id;
    }

    /**
     * Setter for id
     *
     * @param id The id
     */
    public void setId(BigInteger id) {
        this.id = id;
    }

    /**
     * Getter for firstName
     *
     * @return The firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for firstName
     *
     * @param firstName The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName
     *
     * @return The lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for lastName
     *
     * @param lastName The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for courses
     *
     * @return The courses
     */
    public List<Course> getCourses() {
        return this.courses;
    }

    /**
     * Setter for courses
     *
     * @param courses The courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Creates a string representation of the student
     *
     * @return The string representation of student student
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
