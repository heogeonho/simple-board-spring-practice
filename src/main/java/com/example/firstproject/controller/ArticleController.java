package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI) -> 의존성 주입 Dependency Injection
    private ArticleRepository articleRepository;
    // = new ArticleRepositoryImpl() 하지 않는 이유: 스프링 부트는 알아서 객체 만듦

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        // 2. 리파지터리로 엔티티 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
}
