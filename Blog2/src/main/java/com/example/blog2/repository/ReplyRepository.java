package com.example.blog2.repository;

import com.example.blog2.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findByReplyBoardIdx(int boardIdx);
}