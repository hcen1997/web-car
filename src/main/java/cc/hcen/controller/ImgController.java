package cc.hcen.controller;

import cc.hcen.service.ImgService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/img")
public class ImgController {

    private static Long lastCaptureTime;

    ImgController() {
        lastCaptureTime = System.currentTimeMillis();
    }

    @Autowired
    ImgService imgService;


    @RequestMapping("/list")
    public String list() {
        return JSON.toJSONString(imgService.list());
    }

    @RequestMapping("/last")
    public String last() {
        return JSON.toJSONString(imgService.last());
    }

    @RequestMapping("/get/**")
    public @ResponseBody
    byte[] getImg(HttpServletRequest request) throws IOException {
        String locationAndFilename = String.valueOf(request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
        locationAndFilename = locationAndFilename.substring(
                locationAndFilename.indexOf("/get/") + "/get/".length());
        File file = imgService.get(locationAndFilename);
        return IOUtils.toByteArray(new FileInputStream(file));
    }

    /**
     * @return capture jpg name
     */
    @RequestMapping("/cap")
    public String capture() {
        long now = System.currentTimeMillis();
        if (now - lastCaptureTime > 1000) {
            lastCaptureTime = now;
            return imgService.capture();
        } else {
            return "Please wait, not enough second.";
        }

    }
}