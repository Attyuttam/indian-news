package com.attyuttam.newsapp.infra.googlenews;

import com.attyuttam.newsapp.domain.News;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GOOGLE-NEWS-SERVICE", url = "${google-news.url}")
public interface GoogleNewsService {
    @RequestMapping(method = RequestMethod.GET, value = "/top-headlines")
    News getIndiaNews(@RequestParam String country, @RequestParam String apiKey);
}
