package com.gabrielguimaraes.mappers;

import com.gabrielguimaraes.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentConverterTest {

    private final StudentConverter converter = new StudentConverter();

    private void assertStudentFields(Student expected, Student actual) {
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getAge(), actual.getAge());
        Assertions.assertEquals(expected.getGrade(), actual.getGrade());
    }

    @Nested
    class PositiveTests {

        @Test
        public void testHighAchiever() {
            Student student = new Student();
            student.setName("John");
            student.setAge(21);
            student.setGrade(95);
            List<Student> students = Collections.singletonList(student);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(1, result.size());
            Assertions.assertTrue(result.get(0).isHonorRoll());
            Assertions.assertFalse(result.get(0).isExceptional());
            Assertions.assertFalse(result.get(0).isPassed());
            assertStudentFields(student, result.get(0));
        }

        @Test
        public void testExceptionalYoungHighAchiever() {
            Student student = new Student();
            student.setName("Jane");
            student.setAge(20);
            student.setGrade(91);
            List<Student> students = Collections.singletonList(student);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(1, result.size());
            Assertions.assertTrue(result.get(0).isExceptional());
            Assertions.assertFalse(result.get(0).isHonorRoll());
            Assertions.assertFalse(result.get(0).isPassed());
            assertStudentFields(student, result.get(0));
        }

        @Test
        public void testPassedStudent() {
            Student student = new Student();
            student.setName("Emily");
            student.setAge(22);
            student.setGrade(75);
            List<Student> students = Collections.singletonList(student);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(1, result.size());
            Assertions.assertTrue(result.get(0).isPassed());
            Assertions.assertFalse(result.get(0).isHonorRoll());
            Assertions.assertFalse(result.get(0).isExceptional());
            assertStudentFields(student, result.get(0));
        }

        @Test
        public void testFailedStudent() {
            Student student = new Student();
            student.setName("Bob");
            student.setAge(22);
            student.setGrade(60);
            List<Student> students = Collections.singletonList(student);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(1, result.size());
            Assertions.assertFalse(result.get(0).isPassed());
            Assertions.assertFalse(result.get(0).isHonorRoll());
            Assertions.assertFalse(result.get(0).isExceptional());
            assertStudentFields(student, result.get(0));
        }
    }

    @Nested
    class NegativeTests {

        @Test
        public void testEmptyArray() {
            List<Student> students = Collections.emptyList();

            List<Student> result = converter.convertStudents(students);

            Assertions.assertTrue(result.isEmpty());
        }

        @Test
        public void testInputIsNull() {
            List<Student> students = null;

            Assertions.assertThrows(NullPointerException.class, () -> converter.convertStudents(students));
        }
    }

    @Nested
    class AdditionalTests {

        @Test
        public void testMultipleStudents() {
            Student student1 = new Student();
            student1.setName("A");
            student1.setAge(21);
            student1.setGrade(95);

            Student student2 = new Student();
            student2.setName("B");
            student2.setAge(20);
            student2.setGrade(50);

            List<Student> students = Arrays.asList(student1, student2);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(2, result.size());
            Student actualStudent1 = result.get(0);
            Assertions.assertTrue(actualStudent1.isHonorRoll());
            Assertions.assertFalse(actualStudent1.isExceptional());
            Assertions.assertFalse(actualStudent1.isPassed());
            assertStudentFields(student1, actualStudent1);
            Student actualStudent2 = result.get(1);
            Assertions.assertFalse(actualStudent2.isPassed());
            Assertions.assertFalse(actualStudent2.isHonorRoll());
            Assertions.assertFalse(actualStudent2.isExceptional());
            assertStudentFields(student2, actualStudent2);
        }

        @Test
        public void testStudentWithMinimumGrade() {
            Student student = new Student();
            student.setName("Min");
            student.setAge(22);
            student.setGrade(0);
            List<Student> students = Collections.singletonList(student);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(1, result.size());
            Assertions.assertFalse(result.get(0).isPassed());
            Assertions.assertFalse(result.get(0).isHonorRoll());
            Assertions.assertFalse(result.get(0).isExceptional());
            assertStudentFields(student, result.get(0));
        }

        @Test
        public void testStudentWithMaximumGrade() {
            Student student = new Student();
            student.setName("Max");
            student.setAge(22);
            student.setGrade(100);
            List<Student> students = Collections.singletonList(student);

            List<Student> result = converter.convertStudents(students);

            Assertions.assertEquals(1, result.size());
            Assertions.assertTrue(result.get(0).isHonorRoll());
            Assertions.assertFalse(result.get(0).isPassed());
            Assertions.assertFalse(result.get(0).isExceptional());
            assertStudentFields(student, result.get(0));
        }
    }
}
