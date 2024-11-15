package com.fordTest1.DesignPatterns.behavioural.observer;

import com.fordTest1.DesignPatterns.behavioural.observer.Channel;

public class NewsChannel implements Channel {


    private String news;

    @Override
    public void update(Object news) {
          this.setNews((String)news);
    }

    public String getNews(){
        return news;
    }

    public void setNews(String news){
        this.news = news;
    }


}
