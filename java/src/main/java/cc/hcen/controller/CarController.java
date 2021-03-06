package cc.hcen.controller;

import cc.hcen.Main;
import cc.hcen.model.Car;
import cc.hcen.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/car")
public class CarController {

    private static Car car = Main.car;

    @RequestMapping("/go")
    public R go() {
        car.go();
        return R.ok();
    }

    @RequestMapping("/stop")
    public R stop() {
        car.stop();
        return R.ok();
    }

    @RequestMapping("/back")
    public R back() {
        car.back();
        return R.ok();
    }
    @RequestMapping("/left")
    public R left() {
        car.turnLeft();
        return R.ok();
    }
    @RequestMapping("/right")
    public R right() {
        car.turnRight();
        return R.ok();
    }


}
