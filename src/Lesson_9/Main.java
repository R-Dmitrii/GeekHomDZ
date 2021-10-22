package Lesson_9;

        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Course java = new CourseImpl(1, "Java");
        Course javaScript = new CourseImpl(2, "JavaScript");
        Course kotlin = new CourseImpl(3, "Kotlin");
        Course docker = new CourseImpl(4, "Docker");
        Course python = new CourseImpl(5, "Python");
        Course paskal = new CourseImpl(6, "Pascal");

        Student studentA = new StudentImpl("Vasya", List.of(
                java, javaScript, kotlin, kotlin, javaScript)
        );

        Student studentB = new StudentImpl("Petya", List.of(
                javaScript, docker, python, python
        ));

        Student studentC = new StudentImpl("Boba", List.of(
                paskal
        ));

        Student studentD = new StudentImpl("Aboba", List.of(
                docker, paskal
        ));

        List<Student> studentList = List.of(studentA, studentB, studentC, studentD);

        System.out.println("Уникальные курсы");
        List<Course> unique = getUniqueCourses(studentList);
        for (Course course : unique) {
            System.out.println(course.getCourseName());
        }

        System.out.println("\n\nПолучение студентов по курсу");
        List<Student> studentsByCourse = getStudentsByCourse(studentList, paskal);
        for (Student student : studentsByCourse) {
            System.out.println(student.getName());
        }

        System.out.println("\n\nПолучение топ 3 любознательных");
        List<Student> top3Students = getTop3(studentList);
        for (Student student : top3Students) {
            System.out.println(student.getName());
        }

    }

    public static List<Course> getUniqueCourses(List<Student> list) {
        return list.stream().map(Student::getAllCourses).flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }

    public static List<Student> getStudentsByCourse(List<Student> list, Course course) {
        return list.stream().filter(e -> e.getAllCourses().contains(course)).collect(Collectors.toList());
    }

    public static List<Student> getTop3(List<Student> list) {
        List<Student> sorted = list.stream().sorted(Comparator.comparingInt(s -> s.getAllCourses().size())).collect(Collectors.toList());
        Collections.reverse(sorted);
        return sorted.subList(0, 3);
    }
}