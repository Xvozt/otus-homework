package data;

import java.util.Objects;

public class SuiteData {
    private String name;

    public String getDetails() {
        return details;
    }

    public SuiteData withDetails(String details) {
        this.details = details;
        return this;
    }

    private String details;

    public String getName() {
        return name;
    }

    public SuiteData withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuiteData suiteData = (SuiteData) o;
        return name.equals(suiteData.name) &&
                details.equals(suiteData.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, details);
    }
}
