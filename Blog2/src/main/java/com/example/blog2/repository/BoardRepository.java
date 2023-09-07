package com.example.blog2.repository;

import com.example.blog2.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 게시물 제목으로 게시물 찾기
    List<Board> findByBoardTitle(String boardTitle);

    // 게시물 내용에 특정 키워드가 포함된 게시물 찾기
    List<Board> findByBoardContentContaining(String keyword);

    // 게시물 작성자로 게시물 찾기
    List<Board> findByBoardName(String boardName);

    // 게시물 조회수 내림차순으로 정렬하여 가져오기 (페이징 처리를 위한 메서드)
    List<Board> findAllByOrderByBoardHitDesc();
    

}
