/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.stach.university.api.controller;

import edu.stach.university.api.data.model.Student;
import edu.stach.university.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/12/16
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * returns all students
     *
     * @return all students
     */
    @RequestMapping(value = "/api/student", method = RequestMethod.GET)
    public ResponseEntity<Collection<Student>> getStudents() {
        return new ResponseEntity<>(this.studentService.findAll(), HttpStatus.OK);
    }

    /**
     * returns one student
     *
     * @param id the id of the student
     * @return the student
     */
    @RequestMapping(value = "/api/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable("id") BigInteger id) {
        System.out.println(id);
        return new ResponseEntity<>(this.studentService.findOne(id), HttpStatus.OK);
    }

    /**
     * creates a new student
     *
     * @param student the new student
     * @return the new student
     */
    @RequestMapping(value = "/api/student", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student existingStudent = this.studentService.findOne(student.getId());

        if (existingStudent == null) {
            return new ResponseEntity<>(this.studentService.create(student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * updates an existing student
     *
     * @param student the student
     * @return the student
     */
    @RequestMapping(value = "/api/student", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student existingStudent = this.studentService.findOne(student.getId());

        if (existingStudent != null) {
            return new ResponseEntity<>(this.studentService.update(student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * deletes a student
     *
     * @param student the student
     */
    @RequestMapping(value = "/api/student", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        student = this.studentService.findOne(student.getId());

        if (student != null) {
            this.studentService.delete(student.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
