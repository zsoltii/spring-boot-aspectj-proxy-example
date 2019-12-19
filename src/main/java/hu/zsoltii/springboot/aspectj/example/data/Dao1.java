package hu.zsoltii.springboot.aspectj.example.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    public String retrieveSomething(){
        apple();
        return "Dao1";
    }

    private String apple() {
        appleStatic();
        return "apple";
    }

    private static String appleStatic() {
        return "apple static";
    }
}

