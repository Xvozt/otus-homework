package data;

import java.util.Objects;

public class BuildData {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public BuildData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BuildData withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildData buildData = (BuildData) o;
        return title.equals(buildData.title) &&
                description.equals(buildData.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
