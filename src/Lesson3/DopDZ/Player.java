package Lesson3.DopDZ;

import java.io.Serializable;

public class Player implements Serializable {

    private String nickname;
    private int age;
    private String sex;

    public Player(String nickname, int age, String sex) {
        this.nickname = nickname;
        this.age = age;
        this.sex = sex;
    }

    public void info(){
        System.out.println(nickname + " " + age + " " + sex);
    }

    public String getNickname() {
        return nickname;
    }
}
