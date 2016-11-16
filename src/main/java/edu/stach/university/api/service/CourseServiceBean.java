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
import edu.stach.university.api.data.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/13/16
 */
@Service
public class CourseServiceBean implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void init() {

    }

    @Override
    public Iterable<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findOne(String id) {
        return this.courseRepository.findOne(id);

    }

    @Override
    public Course create(Course data) {
        if (data.getId() == null) {
            return this.courseRepository.save(data);
        }

        return null;
    }

    @Override
    public Course update(Course data) {
        if (data.getId() != null) {
            if (this.courseRepository.exists(data.getId())) {
                return this.courseRepository.save(data);
            }
        }

        return null;
    }

    @Override
    public void delete(String id) {
        this.courseRepository.delete(id);
    }
}
