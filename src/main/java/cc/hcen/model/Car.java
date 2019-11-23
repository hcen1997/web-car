package cc.hcen.model;

import cc.hcen.service.GPIODriver;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
public class Car {

    public static     GPIODriver gpioDriver = new GPIODriver();

    // 朝向前 左前 右前 左后 右后
    //        LF  RF  LB   RB
    // 前向正极 **FPin
    // 后向正极 **BPin
    private GpioPinDigitalOutput LFFPin = gpioDriver.getOutPut(RaspiPin.GPIO_23);
    private GpioPinDigitalOutput LFBPin = gpioDriver.getOutPut(RaspiPin.GPIO_22);
    private GpioPinDigitalOutput RFFPin = gpioDriver.getOutPut(RaspiPin.GPIO_21);
    private GpioPinDigitalOutput RFBPin = gpioDriver.getOutPut(RaspiPin.GPIO_26);
    private GpioPinDigitalOutput LBFPin = gpioDriver.getOutPut(RaspiPin.GPIO_25);
    private GpioPinDigitalOutput LBBPin = gpioDriver.getOutPut(RaspiPin.GPIO_27);
    private GpioPinDigitalOutput RBFPin = gpioDriver.getOutPut(RaspiPin.GPIO_29);
    private GpioPinDigitalOutput RBBPin = gpioDriver.getOutPut(RaspiPin.GPIO_28);

    public void go(){
        LFFPin.high();
        R.sleep();
        LFBPin.low();
        R.sleep();
        RFFPin.high();
        R.sleep();
        RFBPin.low();
        R.sleep();
        LBFPin.high();
        R.sleep();
        LBBPin.low();
        R.sleep();
        RBFPin.high();
        R.sleep();
        RBBPin.low();
        R.sleep();
    }
    public void stop(){
        LFFPin.low();
        R.sleep();
        LFBPin.low();
        R.sleep();
        RFFPin.low();
        R.sleep();
        RFBPin.low();
        R.sleep();
        LBFPin.low();
        R.sleep();
        LBBPin.low();
        R.sleep();
        RBFPin.low();
        R.sleep();
        RBBPin.low();
        R.sleep();
    }
    public void back(){
        LFFPin.low();
        R.sleep();
        LFBPin.high();
        R.sleep();
        RFFPin.low();
        R.sleep();
        RFBPin.high();
        R.sleep();
        LBFPin.low();
        R.sleep();
        LBBPin.high();
        R.sleep();
        RBFPin.low();
        R.sleep();
        RBBPin.high();
        R.sleep();

    }
    public  void turnLeft(){
        // 右侧轮正转
        LFFPin.low();
        R.sleep();
        LFBPin.low();
        R.sleep();
        RFFPin.high();
        R.sleep();
        RFBPin.low();
        R.sleep();
        LBFPin.low();
        R.sleep();
        LBBPin.low();
        R.sleep();
        RBFPin.high();
        R.sleep();
        RBBPin.low();
        R.sleep();
    }
    public  void turnRight(){
        LFFPin.high();
        R.sleep();
        LFBPin.low();
        R.sleep();
        RFFPin.low();
        R.sleep();
        RFBPin.low();
        R.sleep();
        LBFPin.high();
        R.sleep();
        LBBPin.low();
        R.sleep();
        RBFPin.low();
        R.sleep();
        RBBPin.low();
        R.sleep();
    }

}
