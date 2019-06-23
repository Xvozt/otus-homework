package data;

import java.util.Objects;

public class ProjectData {
    private String name;
    private String description;
    private String prefix;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProjectData withName (String name) {
        this.name = name;
        return this;
    }

    public ProjectData withDescription (String description) {
        this.description = description;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public ProjectData withPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectData that = (ProjectData) o;
        return name.equals(that.name) &&
                description.equals(that.description) &&
                prefix.equals(that.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, prefix);
    }
}
