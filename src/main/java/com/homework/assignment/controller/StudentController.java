package com.homework.assignment.controller;

import com.homework.assignment.dto.*;
import com.homework.assignment.model.HomeWork;
import com.homework.assignment.model.Student;
import com.homework.assignment.model.StudentHomeWork;
import com.homework.assignment.model.TeacherClass;
import com.homework.assignment.service.HomeworkService;
import com.homework.assignment.service.StudentService;
import com.homework.assignment.service.TeacherClassService;
import org.apache.coyote.Response;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherClassService teacherClassService;
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody StudentDto student) {
        Student loginStudent = studentService.findByStudentCredential(student.getUsername(), student.getPassword());

        if (loginStudent == null)
            return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);
        else
            return ResponseEntity.ok(new StudentDto(loginStudent));
    }

    @PostMapping("/register")
    public ResponseEntity<StudentDto> register(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<StudentDto>(new StudentDto(studentService.add(new Student(studentDto))), HttpStatus.OK);
    }

    @GetMapping("/course/list")
    public ResponseEntity<?> getClassList() {
        return ResponseEntity.ok(Lists.from(teacherClassService.getList().iterator()).stream().map(course -> new TeacherClassDto(course)));
    }

    @PostMapping("/join")
    public ResponseEntity<?> assignmentToClass(@RequestBody StudentClassDto studentClassDto) {
        this.teacherClassService.joinToClass(studentClassDto.getStudentId(), studentClassDto.getClassId());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/course/homework_list/{courseId}")
    public ResponseEntity<?> getHomeworkByClassId(@PathVariable long courseId) {
        return ResponseEntity.ok(homeworkService.getHomeworkByTeacherClassId(courseId).stream().map(homeWork -> new HomeWorkDto(homeWork)));
    }

    @GetMapping("/course/homework_list")
    public ResponseEntity<?> getHomeworkByClassIdAndStudentId(@RequestParam long studentId, @RequestParam long classId) {
        //return ResponseEntity.ok(homeworkService.getHomeworkByTeacherClassId(courseId).stream().map(homeWork -> new HomeWorkDto(homeWork)));
        List<HomeWorkDto> studentHomeworkDto = new ArrayList<>();
        List<HomeWork> homeworkList = homeworkService.getHomeworkByTeacherClassId(classId);
        List<StudentHomeWork> studentHomeworkList = Lists.from(studentService.findById(studentId).getStudentHomeWorks().iterator());

        for (HomeWork homeWork : homeworkList) {
            boolean equal = false;
            for (StudentHomeWork studentHomework : studentHomeworkList) {
                if (homeWork.getHomeWorkId() == studentHomework.getHomeWork().getHomeWorkId()) {
                    studentHomeworkDto.add(new HomeWorkDto(homeWork, true));
                    equal = true;
                }
            }
            if (!equal)
                studentHomeworkDto.add(new HomeWorkDto(homeWork, false));
        }
        return ResponseEntity.ok(studentHomeworkDto);
    }

    @GetMapping("/class/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable long studentId) {
        List<StudentClassDto> studentClasses = new ArrayList<>();
        List<TeacherClass> teacherClassList = Lists.from(this.teacherClassService.getList().iterator());
        List<TeacherClass> studentClassList = Lists.from(this.studentService.findById(studentId).getTeacherClass().iterator());
        for (TeacherClass teacherClass : teacherClassList) {
            boolean equal = false;
            for (TeacherClass studentClass : studentClassList) {
                if (teacherClass.getClassId() == studentClass.getClassId()) {
                    studentClasses.add(new StudentClassDto(teacherClass, true));
                    equal = true;
                }
            }
            if (!equal)
                studentClasses.add(new StudentClassDto(teacherClass, false));
        }

        return ResponseEntity.ok(studentClasses);
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitHomework(@RequestBody StudentHomeworkDto studentHomework) {
        this.homeworkService.submitHomework(studentHomework.getHomeworkId(), studentHomework.getStudentId(), new Date());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
