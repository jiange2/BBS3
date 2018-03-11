package com.gdut.bbs.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Test;


public class XssUtil {

    public static Whitelist whitelist = Whitelist.relaxed();
    public static Whitelist whitelistWithoutIFrame = Whitelist.relaxed();


    static {
        whitelist.addAttributes("ol","style")
                .addAttributes("u","style")
                .addAttributes("li","style")
                .addAttributes("p","style")
                .addAttributes("span","style")
                .addAttributes("span","class")
                .addAttributes("b","style")
                .addAttributes("div","style")
                .addAttributes("table","class")
                .addAttributes("font","face")
                .addAttributes("font","src")
                .addAttributes("a","href","target")
                .addAttributes("img","src")
                .removeProtocols("img","src","http", "https")
                .addAttributes("iframe","src","allowfullscreen","webkitallowfullscreen","mozallowfullscreen");
        whitelistWithoutIFrame.addAttributes("ol","style")
                .addAttributes("u","style")
                .addAttributes("li","style")
                .addAttributes("p","style")
                .addAttributes("span","style")
                .addAttributes("b","style")
                .addAttributes("div","style")
                .addAttributes("table","class")
                .addAttributes("font","face")
                .addAttributes("font","src")
                .addAttributes("a","href","target")
                .addAttributes("img","src")
                .removeProtocols("img","src","http", "https");
    }

    public static String[] videoRegs = {"(http://)?v.qq.com/iframe/player.html?vid=(.+)",
            "(http:)?//player.youku.com/embed/(.+)"};

    public static String cleanTag(String text){
        return cleanIFrame(Jsoup.clean(text,whitelist));
    }

    public static String cleanTagAndIfame(String text){
        return Jsoup.clean(text,whitelistWithoutIFrame);
    }

    public static String cleanIFrame(String text){
        Document document = Jsoup.parse(text);
        Elements elements = document.getElementsByTag("iframe");
        boolean firstVideo = true;
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            if(firstVideo){
                String src = element.attr("src");
                for (String videoReg : videoRegs) {
                    if (src.matches(videoReg)) {
                        firstVideo = false;
                    }
                }
                if(firstVideo){
                    element.remove();
                }
            }else{
                element.remove();
            }
        }

        return document.getElementsByTag("body").get(0).html();
    }

    public static String cleanAll(String text){
        return text;
    }

}
