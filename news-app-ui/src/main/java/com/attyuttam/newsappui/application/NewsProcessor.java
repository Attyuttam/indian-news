package com.attyuttam.newsappui.application;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface NewsProcessor {
    String NEWS_OUTPUT = "news_output";

    @Input(NEWS_OUTPUT)
    SubscribableChannel sourceOfNews();
}
