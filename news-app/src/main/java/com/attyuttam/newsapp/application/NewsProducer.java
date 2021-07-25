package com.attyuttam.newsapp.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.attyuttam.newsapp.domain.News;
import com.attyuttam.newsapp.domain.NewsArticle;
import com.attyuttam.newsapp.infra.googlenews.GoogleNewsService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewsProducer {
    private final GoogleNewsService googleNewsService;

    @Value("${google-news.api-key}")
    private String googleNewsApiKey;

    @Bean
    public Supplier<News> supplyNews() {

        Supplier<News> newsSupplier = () -> {
            return process(googleNewsService.getIndiaNews("in", googleNewsApiKey));
        };

        return newsSupplier;
    }

    private News process(News indiaNews) {
        List<NewsArticle> newsArticles = new ArrayList<>();
        if (indiaNews != null && indiaNews.getArticles() != null) {
            newsArticles = indiaNews.getArticles().stream()
                    .filter(article -> article.getDescription() != null && article.getDescription().length() > 0)
                    .collect(Collectors.toList());
            indiaNews.setArticles(newsArticles);
        }
        return indiaNews;
    }
}
