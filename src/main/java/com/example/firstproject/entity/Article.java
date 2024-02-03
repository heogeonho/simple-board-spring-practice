package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //Article() 생성자 대체 어노테이션
@NoArgsConstructor
@ToString           //toString()
@Entity     //엔티티 선언'
@Getter     //페이지 리다이렉트를 위해 getId 하려고 설정
public class Article {
    @Id     //엔티티 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // DB가 id 자동 생성
    private Long id;
    @Column //title 필드 선언, DB 테이블의 title 열과 연결
    private  String title;
    @Column //content 필드 선언
    private String content;
}