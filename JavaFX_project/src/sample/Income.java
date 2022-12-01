package sample;

public class Income {
    private float sum_income;
    private String com_income;
    private String user_income;

    public Income(float sum_income, String com_income, String user_income) {
        this.sum_income = sum_income;
        this.com_income = com_income;
        this.user_income = user_income;
    }

    public float getSum_income() {
        return sum_income;
    }

    public String getCom_income() {
        return com_income;
    }

    public String getUser_income() {
        return user_income;
    }

    public void setSum_income(float sum_income) {
        this.sum_income = sum_income;
    }

    public void setCom_income(String com_income) {
        this.com_income = com_income;
    }

    public void setUser_income(String user_income) {
        this.user_income = user_income;
    }
}
