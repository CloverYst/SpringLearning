package com.example.demo.service;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> listAllRestaurant() {

        return restaurantRepository.findAll();
    }



    public List<Restaurant> getRestaurant(Integer id) {
        List<Restaurant> res =new ArrayList<>();
        Restaurant restaurant=restaurantRepository.findById(id).get();
        res.add(restaurant);
        return res;
    }


    public void insertRestaurant(Integer id, String Name, String City, String TEL){
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setName(Name);
        restaurant.setCity(City);
        restaurant.setTEL(TEL);
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findByCity(String city) {
        return restaurantRepository.findRestaurantByCity(city);
    }

    public List<Restaurant> findByCityAndID(Integer id, String city) {
        return restaurantRepository.findRestaurantByCityAndID(id, city);
    }

}
