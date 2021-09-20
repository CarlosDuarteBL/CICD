// Carlos Duarte 1ITF6 r0841640
package fact.it.projectthemepark.model;

public class Attraction {
    private String name, photo;
    private int duration;
    private Staff responsible;

    public Attraction() {
    }

    public Attraction(String name) {
        this.name = name;
    }

    public Attraction(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Staff getResponsible() {
        return responsible;
    }

    public void setResponsible(Staff responsible) {
        this.responsible = responsible;
    }
}
