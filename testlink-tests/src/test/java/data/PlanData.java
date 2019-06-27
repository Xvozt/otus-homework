package data;

public class PlanData {
    private String name;
    private String description;

    public PlanData withName(String name) {
        this.name = name;
        return this;
    }

    public PlanData withDescription(String description) {
        this.description = description;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

}
