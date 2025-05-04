package org.example.feature_envy.easy;

public class BudgetAnalyzer {
    /**
     * Determines if a project is over budget by summing its expenses.
     */
    public boolean isOverBudget(Project project) {
        if (project == null) return false;
        double sum = 0;
        for (double e : project.getExpenses()) sum += e;
        return sum > project.getBudget();
    }
}

class Project {
    private final double budget;
    private final double[] expenses;
    public Project(double budget, double[] expenses) {
        this.budget = budget;
        this.expenses = expenses;
    }
    public double getBudget() { return budget; }
    public double[] getExpenses() { return expenses; }
}
