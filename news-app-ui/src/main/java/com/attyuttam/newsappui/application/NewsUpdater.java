package com.attyuttam.newsappui.application;

import lombok.extern.slf4j.Slf4j;
import com.attyuttam.newsappui.domain.News;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import com.attyuttam.newsappui.application.NewsProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class NewsUpdater {
    private final SimpMessagingTemplate newsSender;

    @StreamListener(NewsProcessor.NEWS_OUTPUT)
    public void updateNews(News news){
        log.info("NEWS RECEIVED: {}",news);
        newsSender.convertAndSend("/topic/message", news);
    }
}
