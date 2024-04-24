package spring.bean;

import java.util.Arrays;

public class QianDaYe {
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    private String[] interests;

    // 多个女性朋友
    private Woman[] women;

    @Override
    public String toString() {
        return "QianDaYe{" +
                "interests=" + Arrays.toString(interests) +
                ", women=" + Arrays.toString(women) +
                '}';
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }
}
