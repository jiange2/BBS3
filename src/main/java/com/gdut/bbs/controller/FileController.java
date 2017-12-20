package com.gdut.bbs.controller;


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
    public Map<String,Object> uploadImage(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        String[] path = new String[files.length];
        for(int i=0; i<files.length; ++i){
            path[i] = FileUtil.saveImg(files[i],request.getSession().getServletContext().getRealPath("/"));
        }
        map.put("result","success");
        map.put("url",path);
        return map;
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
