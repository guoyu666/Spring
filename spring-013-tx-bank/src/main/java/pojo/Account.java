package pojo;

// 银行账户类
public class Account {
    private String actno;
    private Double balance;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", actno='" + actno + '\'' +
                '}';
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Account(Double balance, String actno) {
        this.balance = balance;
        this.actno = actno;
    }

    public Account() {
    }
}
