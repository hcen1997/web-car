package cc.hcen.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.hcen.service.ImgService;

@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    ImgService imgService;

    @RequestMapping("/list")
    public String list(){
        return  imgService.list();
    }

    @RequestMapping("/last")
    public String last(){
        return imgService.last();
    }

    @RequestMapping("/{img:.*\\.jpg}")
    public File getImg(String img){
        return imgService.get(img);
    }
}