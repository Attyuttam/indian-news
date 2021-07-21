package com.attyuttam.newsapp.infra.controller;

import com.attyuttam.newsapp.domain.News;
import com.attyuttam.newsapp.infra.googlenews.GoogleNewsService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class NewsController {

    private final GoogleNewsService googleNewsService;

    @Value("${google-news.api-key}")
    private String googleNewsApiKey;

    @GetMapping("/get-india-news")
    public News getIndiaNews(){
        return googleNewsService.getIndiaNews("in", googleNewsApiKey);
    }
}
