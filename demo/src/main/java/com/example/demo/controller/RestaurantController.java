package com.example.demo.controller;

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("")
    public List<Restaurant> get(@RequestParam(value="id",required = false) Integer id,
                                @RequestParam(value="City",required = false) String City) {
        if(id==null&&City==null){
            return restaurantService.listAllRestaurant();
        }
        else if(id==null){
            return restaurantService.findByCity(City);
        }
        else if(City==null){
            return restaurantService.getRestaurant(id);
        }

        return restaurantService.findByCityAndID(id,City);
    }

    //根据给定的id检索数据表中的数据
//    @GetMapping("/id")
//    public ResponseEntity<Restaurant> getRestaurantByID(@RequestParam Integer id) {
//        try {
//            Restaurant res = restaurantService.getRestaurant(id);
//            return new ResponseEntity<Restaurant>(res, HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("/{id}")
//    public Restaurant findRestaurantByID (@PathVariable Integer id){
//        return restaurantService.getRestaurant(id);
//    }


    //向数据表中插入一行新的数据
    // /add?id=c&Name=c&City=c&TEL=c
    @PostMapping("")
    public @ResponseBody String addRestaurant(@RequestParam Integer id,
                    @RequestParam String Name,
                    @RequestParam String City,
                    @RequestParam String TEL) {
        restaurantService.insertRestaurant(id, Name, City, TEL);
        return "Saved to Database";
    }

    //列出所有地区属性为”LA“的数据的详细信息
//    @GetMapping("/City")
//    public List<Restaurant> getRestaurantByCity(@RequestParam String City) {
//            List<Restaurant> res = restaurantService.findByCity(City);
//            return res;
//    }

}
