public class CourseFactory {
    public static Course createCourse(String type, String name, int courseNumber, int maxEnrollment) {
        return switch (type.toLowerCase()) {
            case "seminar" -> new Seminar(name, courseNumber, maxEnrollment);
            case "elective" -> new Elective(name, courseNumber, maxEnrollment);
            case "mandatory" -> new Mandatory(name, courseNumber, maxEnrollment);
            default -> throw new IllegalArgumentException("Unknown course type: " + type);
        };
    }
}

