package sample;

public class Expenses {
    private float expenses_sum;
    private String expenses_com;
    private String expenses_user;

    public Expenses(float expenses_sum, String expenses_com, String expenses_user) {
        this.expenses_sum = expenses_sum;
        this.expenses_com = expenses_com;
        this.expenses_user = expenses_user;
    }

    public float getExpenses_sum() {
        return expenses_sum;
    }

    public void setExpenses_sum(float expenses_sum) {
        this.expenses_sum = expenses_sum;
    }

    public String getExpenses_com() {
        return expenses_com;
    }

    public void setExpenses_com(String expenses_com) {
        this.expenses_com = expenses_com;
    }

    public String getExpenses_user() {
        return expenses_user;
    }

    public void setExpenses_user(String expenses_user) {
        this.expenses_user = expenses_user;
    }
}
