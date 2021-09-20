// Carlos Duarte 1ITF6 r0841640
package fact.it.projectthemepark.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Staff extends Person {
    private LocalDate startDate;
    private Boolean student;

    public Staff(String firstName, String surName) {
        super(firstName, surName);
        if (student == null)
            student = false;
        startDate = LocalDate.now();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(isStudent()){
            return "Staff member " + super.toString() + " (working student) is employed since " + startDate.format(dtf);
        }
        else
            return "Staff member " + super.toString() + " is employed since " + getStartDate().format(dtf);
    }
}
