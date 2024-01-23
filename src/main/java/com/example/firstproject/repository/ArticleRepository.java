package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

// CrudRepository는 JPA에서 제공하는 인터페이스 -> 이를 상속해 엔티티를 관리할 수 있음
// 현재 상속 받아 사용하기 때문에 기본 동작은 활용 가능
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
