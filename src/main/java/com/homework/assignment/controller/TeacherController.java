package com.homework.assignment.controller;

import com.homework.assignment.dto.HomeWorkDto;
import com.homework.assignment.dto.StudentDto;
import com.homework.assignment.dto.TeacherClassDto;
import com.homework.assignment.dto.TeacherDto;
import com.homework.assignment.model.HomeWork;
import com.homework.assignment.model.Teacher;
import com.homework.assignment.model.TeacherClass;
import com.homework.assignment.service.HomeworkService;
import com.homework.assignment.service.StudentService;
import com.homework.assignment.service.TeacherClassService;
import com.homework.assignment.service.TeacherService;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherClassService teacherClassService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody TeacherDto teacherDto) {
        Teacher teacher = this.teacherService.checkTeacherCredential(teacherDto.getUsername(), teacherDto.getPassword());
        if (teacher != null)
            return ResponseEntity.ok(new TeacherDto((teacher)));
        else
            return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<TeacherDto> register(@RequestBody TeacherDto teacherDto) {
        return new ResponseEntity<>(new TeacherDto(teacherService.add(new Teacher(teacherDto))), HttpStatus.OK);
    }

    @PostMapping("/add_homework")
    public ResponseEntity<?> registerHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        this.homeworkService.add(new HomeWork(homeWorkDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/student/list")
    public ResponseEntity<?> getStudentList() {
        return ResponseEntity.ok(Lists.from(studentService.findAll().iterator()).stream().map(s -> new StudentDto(s)));
    }

    @GetMapping("/courses/{teacherId}")
    public ResponseEntity<?> courseListByTeacherId(@PathVariable long teacherId) {
        return ResponseEntity.ok(this.teacherClassService.getByTeacherId(teacherId).stream().map(t -> new TeacherClassDto(t)));
    }

    @PostMapping("/class_assign")
    public ResponseEntity<?> assignToClass(@RequestBody TeacherClassDto teacherClassDto) {
        new TeacherClassDto(this.teacherClassService.add(new TeacherClass(teacherClassDto))).getTitle();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
