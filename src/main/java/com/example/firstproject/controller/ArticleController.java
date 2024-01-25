package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {     //url에서 매개변수 id 가져옴 (어노테이션)
        log.info("id = " +id);
        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        ArrayList<Article> articleEntitiyList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntitiyList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }
}
