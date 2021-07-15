package org.example.ba06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myschool")
public class School {
    @Value("USC")
    private String name;
    @Value("LA")
    private String address;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
