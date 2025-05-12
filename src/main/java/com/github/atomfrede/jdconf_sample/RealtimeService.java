package com.github.atomfrede.jdconf_sample;

import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class RealtimeService {

    @Autowired
    private WebsocketHolder websocketHolder;
    @Autowired
    private TemplateEngine templateEngine;

    @Scheduled(fixedRate = 5000)
    public void updateNewsFeed(){
        try {
            TemplateOutput output = new StringOutput();
            templateEngine.render("feedItem.jte", Map.of("feedItem", randomFeedItem()), output);
            websocketHolder.broadcastHtmlSnipped(output.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FeedItem randomFeedItem(){

        return new FeedItem("Spring I/O", "This rocks", Instant.now());
    }
    public static class FeedItem {
        public String author;
        public String message;
        public Instant timestamp;

        public FeedItem(String author, String message, Instant timestamp) {
            this.author = author;
            this.message = message;
            this.timestamp = timestamp;
        }
    }

}
