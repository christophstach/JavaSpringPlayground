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

import edu.stach.university.api.data.model.Course;
import edu.stach.university.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/12/16
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * returns all courses
     *
     * @return all courses
     */
    @RequestMapping(value = "/api/course", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Course>> getCourses() {
        return new ResponseEntity<>(this.courseService.findAll(), HttpStatus.OK);
    }

    /**
     * returns one course
     *
     * @param id the id of the course
     * @return the course
     */
    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourse(@PathVariable("id") BigInteger id) {
        return new ResponseEntity<>(this.courseService.findOne(id), HttpStatus.OK);
    }

    /**
     * creates a new course
     *
     * @param course the new course
     * @return the new course
     */
    @RequestMapping(value = "/api/course", method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        course = this.courseService.create(course);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * updates an existing course
     *
     * @param course the course
     * @return the course
     */
    @RequestMapping(value = "/api/course", method = RequestMethod.PUT)
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        course = this.courseService.update(course);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * deletes a course
     *
     * @param course the course
     */
    @RequestMapping(value = "/api/course", method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse(@RequestBody Course course) {
        course = this.courseService.findOne(course.getId());

        if (course != null) {
            this.courseService.delete(course.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
