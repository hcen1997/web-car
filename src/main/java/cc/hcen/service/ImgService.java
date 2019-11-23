package cc.hcen.service;


import cc.hcen.Main;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class ImgService {

    public String[] list() {
        File imgDir = new File(Main.imgDir);
        return imgDir.list();
    }

    public String last() {
        String[] list = list();
        return list[list.length - 1];
    }


    public File get(String img) {
        return new File(Main.imgDir + "/" + img);
    }


    @Scheduled(cron = "0/10 * *  * * ? ")   //每10秒执行一次
    private void takePhoto() {

        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        int i = 0;
        try {
            grabber.start();
            Frame frame = grabber.grab();

            img = converter.convert(frame);

            //the grabbed frame will be flipped, re-flip to make it right
            cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

            //save
            String name = String.valueOf(System.currentTimeMillis()).substring(0, 10);
            cvSaveImage(name + ".jpg", img);

            converter.convert(img);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
