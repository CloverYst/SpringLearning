package com.example.demo.repository;

import com.example.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query(name = "findRestaurantByCity",nativeQuery = true,
            value = "select * from restaurant where City=:City")
    List<Restaurant> findRestaurantByCity(@Param("City") String City);

    @Query(name = "findRestaurantByCityAndID",nativeQuery = true,
            value = "select * from restaurant where City=:City and id=:id")
    List<Restaurant> findRestaurantByCityAndID(@Param("id")Integer id, @Param("City")String city);
}
