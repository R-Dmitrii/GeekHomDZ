package Lesson_9;

public class CourseImpl implements Course {

    private int courseId;

    private String courseName;

    public CourseImpl(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    @Override
    public int getCourseId() {
        return this.courseId;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }
}