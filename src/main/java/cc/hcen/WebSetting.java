package cc.hcen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/set")
public class WebSetting {

    @Autowired
    Car car;

    @Autowired
    GPIODriver gpioDriver;

    @GetMapping("/pin/{wheelOrientation}/{address}")
    public R setWheelOrientationPin(@PathVariable String wheelOrientation,@PathVariable Integer address) {
        try {
            Method setMethod = car.getClass().getMethod("set"+wheelOrientation+"Pin");
            setMethod.invoke(gpioDriver.getpin(address));
            return R.ok();
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }
}
