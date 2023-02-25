package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Ford", 11, 1999));
        list.add(new Car("Ferrari", 12, 2003));
        list.add(new Car("Aston Martin", 34, 1751));
        list.add(new Car("FIAT", 7, 1800));
        list.add(new Car("BMW", 11, 1007));
        list = carService.carsCount(list, allCars);
        model.addAttribute("list", list);
        return "cars";

    }
}
