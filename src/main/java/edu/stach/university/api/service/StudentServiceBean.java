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
import edu.stach.university.api.data.model.Student;
import edu.stach.university.api.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/13/16
 */
@Service
public class StudentServiceBean implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init() {
    }

    @Override
    public Iterable<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findOne(String id) {
        return this.studentRepository.findOne(id);

    }

    @Override
    public Student create(Student data) {
        if (data.getId() == null) {
            return this.studentRepository.save(data);
        }

        return null;
    }

    @Override
    public Student update(Student data) {
        if (data.getId() != null) {
            if (this.studentRepository.exists(data.getId())) {
                return this.studentRepository.save(data);
            }
        }

        return null;
    }

    @Override
    public void delete(String id) {
        this.studentRepository.delete(id);
    }
}
