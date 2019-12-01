package cc.hcen.service;


import cc.hcen.model.C;
import cc.hcen.model.U;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


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
        return file.exists() ? file : new File(U.getImg(C.emptyImg));
    }

    // 由web调用
    public String capture() {
        String name = "";
        name = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        name = name + ".jpg";
        try {
            Process exec = Runtime.getRuntime().exec(fswebcamCmd(name));
            exec.waitFor();
        } catch (IOException | InterruptedException e) {
            log.error("Run fswebcam error.");
        }

        return name;
    }

    private String fswebcamCmd(String img) {
        return String.format("fswebcam %d/%d", C.imgDir, img);
    }

}
