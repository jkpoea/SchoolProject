package ec.utb.jv;

import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private String email;
    private String adress;

    public Student(int id ,String name, String email, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

}


