package com.gabrielguimaraes.mappers;

import com.gabrielguimaraes.entities.Student;
import java.util.List;

public class StudentConverter {

  public List<Student> convertStudents(List<Student> students) {

    return students.stream()
        .map(
            student -> {
              Student result = new Student();

              result.setName(student.getName());
              result.setAge(student.getAge());
              result.setGrade(student.getGrade());

              if (student.getGrade() > 90) {
                if (student.getAge() < 21) {
                  result.setExceptional(true);
                } else {
                  result.setHonorRoll(true);
                }
              } else {
                boolean passed = student.getGrade() > 70;
                result.setPassed(passed);
              }
              return result;
            })
        .toList();
  }
}
