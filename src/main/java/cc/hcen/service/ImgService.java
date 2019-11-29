package cc.hcen.service;


import cc.hcen.Main;
import cc.hcen.model.C;
import cc.hcen.model.U;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;
import org.bytedeco.opencv.opencv_core.IplImage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.bytedeco.opencv.global.opencv_core.cvFlip;
import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvSaveImage;

@Service
@Slf4j
public class ImgService {

    public String[] list() {
        File imgDir = new File(C.imgDir);
        return imgDir.list();
    }

    public String last() {
        String[] list = list();
        return list[list.length - 1];
    }


    public File get(String img) {
        File file = new File(U.getImg(img));
        return file.exists()?file:new File(U.getImg(C.emptyImg));
    }

    // 由web调用
    public String capture() {

        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        int i = 0;
        String name = "";
        try {
            grabber.start();
            Frame frame = grabber.grab();

            img = converter.convert(frame);

            //the grabbed frame will be flipped, re-flip to make it right
            cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

            //save
            name = String.valueOf(System.currentTimeMillis()).substring(0, 10);
            name = name + ".jpg";
            cvSaveImage(C.imgDir + "/" + name, img);
        } catch (Exception e) {
            log.error("Grab img error.");
        }
        return name;
    }


}
