package com.gdut.bbs.controller;


import com.gdut.bbs.domain.JsonResult;
import com.gdut.bbs.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/upload")
@Controller
public class FileController {

    @RequestMapping("/img")
    @ResponseBody
    public JsonResult uploadImage(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws InterruptedException {
        JsonResult result = new JsonResult();
        String[] path = new String[files.length];
        for(int i=0; i<files.length; ++i){
            path[i] = FileUtil.saveImg(files[i],
                    request.getSession().getServletContext().getRealPath("/"));
        }
        Thread.sleep(600);
        result.addInfo("url",path[0]);
        return result;
    }


    @RequestMapping("/maxUpSize")
    @ResponseBody
    public Map<String,Object> maxUpSize(){
        Map<String,Object> map = new HashMap<>();
        map.put("result","failure");
        map.put("message","图片文件过大,文件最大可为1M");
        return map;
    }
}
