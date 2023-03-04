package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String,Teacher> teacherHashMap;
    HashMap<String, List<String>> listHashMap;

    public StudentRepository(){
        studentHashMap =  new HashMap<>();
        teacherHashMap = new HashMap<>();
        listHashMap = new HashMap<>();
    }
    void addStudent(Student student){
        studentHashMap.put(student.getName(), student);
    }
    void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }
   void addStudentTeacherPair(String student , String teacher){
    if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher)){
        if(listHashMap.containsKey(teacher)){
            listHashMap.get(teacher).add(student);
            teacherHashMap.get(teacher).setNumberOfStudents(listHashMap.get(teacher).size());
        }
        else{
            List<String> t = new ArrayList<>();
            t.add(student);
            listHashMap.put(teacher,t);
            teacherHashMap.get(teacher).setNumberOfStudents((listHashMap.get(teacher).size()));
        }
    }
   }
    Student stbyN(String orderId) {
        return studentHashMap.get(orderId);

    }
    Teacher tbyn(String teacher){
        return teacherHashMap.get(teacher);
    }
    List<String> ListOfStudent(String dpId) {
        List<String> ans = new ArrayList<>();//return type is Arraylist so create ans list
        if (listHashMap.containsKey(dpId)) {
            ans = listHashMap.get(dpId);
        }
        return ans;
    }
     List<String> ListOfAllStudents(){
            List<String>ans=new ArrayList<>(studentHashMap.keySet());
            return ans;
        }
    void deleteTeacher(String id){
       if(teacherHashMap.containsKey(id)){
           teacherHashMap.remove(id);
       }
       if(listHashMap.containsKey(id)){
           List<String> s = new ArrayList<>(listHashMap.get(id));
           for(String x : s){
               if(studentHashMap.containsKey(x)){
                   studentHashMap.remove(x);
               }
           }
           listHashMap.remove(id);
       }
    }
       void deleteAllTeacher(){
        for(String f : listHashMap.keySet()){
            List<String> s = new ArrayList<>(listHashMap.get(f));
            for(String x : s){
                if(studentHashMap.containsKey(x)){
                    studentHashMap.remove(x);
                }
            }
            listHashMap.remove(f);
        }
       }

    }




