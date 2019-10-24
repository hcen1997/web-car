package cc.hcen;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class Car {

    @Autowired
    GPIODriver gpioDriver;

    // 朝向前 左前 右前 左后 右后
    //        LF  RF  LB   RB
    // 前向正极 **FPin
    // 后向正极 **BPin
    private GpioPinDigitalOutput LFFPin;
    private GpioPinDigitalOutput RFFPin;
    private GpioPinDigitalOutput LBFPin;
    private GpioPinDigitalOutput RBFPin;
    private GpioPinDigitalOutput LFBPin;
    private GpioPinDigitalOutput RFBPin;
    private GpioPinDigitalOutput LBBPin;
    private GpioPinDigitalOutput RBBPin;

    private void moveLFF(){
        LFFPin.high();
        LFBPin.low();
    }
    private void stopLFF(){
        LFFPin.low();
        LFBPin.low();
    }

    private void moveLFB(){
        LFFPin.low();
        LFBPin.high();
    }
    private void stopLFB(){
        LFFPin.low();
        LFBPin.low();
    }
    private void moveRFF(){
        RFFPin.high();
        RFBPin.low();
    }
    private void stopRFF(){
        RFFPin.low();
        RFBPin.low();
    }
    private void moveRFB(){
        RFFPin.low();
        RFBPin.high();
    }
    private void stopRFB(){
        RFFPin.low();
        RFBPin.low();
    }
    private void moveLBF(){
        LBFPin.high();
        LBBPin.low();
    }
    private void stopLBF(){
        LBFPin.low();
        LBBPin.low();
    }
    private void moveLBB(){
        LBFPin.low();
        LBBPin.high();
    }
    private void stopLBB(){
        LBFPin.low();
        LBBPin.low();
    }
    private void moveRBF(){
        RBFPin.high();
        RBBPin.low();
    }
    private void stopRBF(){
        RBFPin.low();
        RBBPin.low();
    }
    private void moveRBB(){
        RBFPin.low();
        RBBPin.high();
    }
    private void stopRBB(){
        RBFPin.low();
        RBBPin.low();
    }
    public Car() {
        this.LFFPin = gpioDriver.getOutPut(RaspiPin.GPIO_25);
        this.LFBPin = gpioDriver.getOutPut(RaspiPin.GPIO_29);
        this.RFFPin = gpioDriver.getOutPut(RaspiPin.GPIO_24);
        this.RFBPin = gpioDriver.getOutPut(RaspiPin.GPIO_28);
        this.LBFPin = gpioDriver.getOutPut(RaspiPin.GPIO_23);
        this.LBBPin = gpioDriver.getOutPut(RaspiPin.GPIO_27);
        this.RBFPin = gpioDriver.getOutPut(RaspiPin.GPIO_22);
        this.RBBPin = gpioDriver.getOutPut(RaspiPin.GPIO_26);
    }

    public void go(){
        moveLFF();
        moveRFF();
        moveLBF();
        moveRBF();
    }
    public void stop(){
        stopLFF();
        stopRFF();
        stopLBF();
        stopRBF();
    }
    public void back(){
        moveLFB();
        moveRFB();
        moveLBB();
        moveRBB();
    }
    public  void turnLeft(){
        try {
            throw new Exception("stub!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void turnRight(){
        try {
            throw new Exception("stub!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
