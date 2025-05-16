package com.github.atomfrede.jdconf_sample;

import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;

@Service
public class RealtimeService {

    private final Faker faker = new Faker();
    private final WebsocketHolder websocketHolder;
    private final TemplateEngine templateEngine;

    public RealtimeService(WebsocketHolder websocketHolder, TemplateEngine templateEngine) {
        this.websocketHolder = websocketHolder;
        this.templateEngine = templateEngine;
    }

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

        return new FeedItem(faker.fallout().character(), faker.fallout().quote(), Instant.now());
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
