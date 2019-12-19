package hu.zsoltii.springboot.aspectj.example.business;


import hu.zsoltii.springboot.aspectj.example.data.Dao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Business1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Business1.class);

    @Resource
    private Dao1 dao1;

    public String calculateSomething(){
        String value = dao1.retrieveSomething();
        LOGGER.info("In Business - {}", value);
        return value;
    }
}

