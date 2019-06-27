package data;

import java.util.Objects;

public class CaseData {
    private String name;
    private String details;
    private String actions;
    private String expectedResults;


    public String getDetails() {
        return details;
    }

    public CaseData withDetails(String details) {
        this.details = details;
        return this;
    }

    public String getName() {
        return name;
    }


    public CaseData withName(String name) {
        this.name = name;
        return this;
    }

    public String getActions() {
        return actions;
    }

    public CaseData withActions(String actions) {
        this.actions = actions;
        return this;
    }

    public String getExpectedResults() {
        return expectedResults;
    }

    public CaseData withExpectedResults(String expectedResults) {
        this.expectedResults = expectedResults;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseData caseData = (CaseData) o;
        return name.equals(caseData.name) &&
                details.equals(caseData.details) &&
                actions.equals(caseData.actions) &&
                expectedResults.equals(caseData.expectedResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, details, actions, expectedResults);
    }
}
