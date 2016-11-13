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

import java.math.BigInteger;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/12/16
 */
public class Person {
    private static BigInteger nextId = BigInteger.ONE;
    protected BigInteger id;
    protected String firstName;
    protected String lastName;

    public Person() {
        Person.nextId = Person.nextId.add(BigInteger.ONE);
    }

    public Person(String firstName, String lastName) {
        this.id = Person.nextId;
        this.firstName = firstName;
        this.lastName = lastName;

        Person.nextId = Person.nextId.add(BigInteger.ONE);
    }

    public static BigInteger getNextId() {
        return nextId;
    }

    public BigInteger getId() {
        return id;
    }

    public static void setNextId(BigInteger nextId) {
        Person.nextId = nextId;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
