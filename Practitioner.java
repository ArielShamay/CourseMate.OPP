class Practitioner implements Participant {
    private String name;
    private String expertiseArea;
    private int yearsOfExperience;

    public Practitioner(String name, String expertiseArea, int yearsOfExperience) {
        this.name = name;
        this.expertiseArea = expertiseArea;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Method to schedule a practical session
    public void scheduleSession(Course course) {
        System.out.println("Scheduling a practical session for " + course.getName());
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}