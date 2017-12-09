package com.gdut.bbs.jsptag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends SimpleTagSupport {

    private Date date;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");




    @Override
    public void doTag() throws JspException, IOException {
        System.out.println(date);
        JspWriter writer = getJspContext().getOut();
        if(date == null){
            writer.println("时间消失了");
        }

        long time = (System.currentTimeMillis() - date.getTime())/1000;

        if(time > 86400){
            writer.println(dateFormat.format(date));
        }else if(time > 3600){
            writer.println((time/3600)+"小时前");
        }else if(time > 60){
            writer.println((time/60)+"分钟前");
        }else{
            writer.println((time+"秒前"));
        }
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
