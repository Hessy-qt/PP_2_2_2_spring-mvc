package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCars(List<Car> cars, int count) {
       List<Car> carList = cars.stream().limit(count).toList();
       return carList;
    }
}
