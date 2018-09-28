package com.chartRobot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by admin on 2018/9/28.
 */
public class TuLingMessage {
    //编码 100000:文本类    200000:链接    302000:新闻类   308000:菜谱类
    // 异常码  40001:参数key错误    40002:请求内容info为空   40004:当天请求次数已使用完   40007:数据格式异常
    private String code;

    //文本内容
    private String text;

    //链接
    private String url;

    //信息列表
    @JsonProperty("list")
    private List<Information> informations;

    /**
     * 新闻列表
     */
    public static class Information {

        //名称 (选菜谱的时候会用到)
        private String name;

        //菜谱信息
        private String info;

        //新闻标题
        private String article;

        //新闻来源
        private String source;

        //新闻图片
        private String icon;

        //详情链接
        @JsonProperty("detailurl")
        private String detailUrl;

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Information> getInformations() {
        return informations;
    }

    public void setInformations(List<Information> informations) {
        this.informations = informations;
    }
}
