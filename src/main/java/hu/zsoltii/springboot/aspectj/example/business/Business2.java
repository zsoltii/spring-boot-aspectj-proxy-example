package hu.zsoltii.springboot.aspectj.example.business;

import hu.zsoltii.springboot.aspectj.example.data.Dao2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Business2 {

    @Resource
    private Dao2 dao2;

    public String calculateSomething(){
        //Business Logic
        return dao2.retrieveSomething();
    }
}

