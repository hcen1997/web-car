package cc.hcen;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Service;

@Service
public class GPIODriver {

    private final GpioController gpio = GpioFactory.getInstance();

    public GpioPinDigitalOutput getOutPut(Pin pin) {
        return gpio.provisionDigitalOutputPin(pin,PinState.LOW);
    }

    public  GpioPinDigitalOutput getpin(Integer address){
        return gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(address));
    }
}
