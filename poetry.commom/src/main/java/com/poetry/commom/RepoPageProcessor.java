package com.poetry.commom;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class RepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
     // 部分二：定义如何抽取页面信息，并保存下来
        if (page.getUrl().regex("https://www\\.gushiwen\\.org/shiwen/default.aspx\\?page=\\d+").match()){
            //目标链接
            page.addTargetRequests(page.getHtml().xpath("").links().all());
            //下一页博文列表页链接
            page.addTargetRequests(page.getHtml().xpath("//a[@rel='next']").links().all());
        }


    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new RepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.gushiwen.org/shiwen/default.aspx?page=1&type=0&id=0")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

}
