package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showCars(@RequestParam("count") int count, Model model) {
        List<Car> cars = List.of(new Car("BMW", "red", 2023),
                new Car("Audi", "blue", 2020),
                new Car("Porshe", "black", 2020),
                new Car("Niva", "green", Integer.MIN_VALUE),
                new Car("Toyota(Camri 3.5)", "red", 2007));
        model.addAttribute("cars", carService.getCars(cars, count));
        return "cars";
    }

}
