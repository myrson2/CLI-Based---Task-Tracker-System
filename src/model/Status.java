package model;

public enum Status {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private String description;

  // Constructor (runs once for each constant above)
    private Status(String description) {
        this.description = description;
    }

    // Getter method to read the description
    public String getDescription() {
        return description;
    }
}
