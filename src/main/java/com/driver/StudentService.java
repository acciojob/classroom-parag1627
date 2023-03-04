package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    void addStudent(Student student) {
        repository.addStudent(student);
    }

    void addTeacher(Teacher teacher) {
        repository.addTeacher(teacher);
    }

    void addStudentTeacherPair(String student, String teacher) {
        repository.addStudentTeacherPair(student, teacher);
    }

    Student stbyN(String orderId) {
        return repository.stbyN(orderId);
    }

    Teacher tbyn(String teacher) {
        return repository.tbyn(teacher);
    }

    List<String> ListOfStudent(String dpId) {
        return repository.ListOfStudent(dpId);

    }
  List<String> ListOfAllStudents(){
        return repository.ListOfAllStudents();
  }
  void deleteTeacher(String id){
         repository.deleteTeacher(id);
  }
  void deleteAllTeacher(){
        repository.deleteAllTeacher();
  }

}
