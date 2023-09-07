package com.example.blog2.Service;

import com.example.blog2.domain.Reply;
import com.example.blog2.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Override
    public Reply getReplyById(int replyId) {
        return replyRepository.findById(replyId).orElse(null);
    }

    @Override
    public void saveReply(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void updateReply(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void deleteReply(int replyId) {
        replyRepository.deleteById(replyId);
    }

    @Override
    public List<Reply> getRepliesByBoardId(int boardId) {
        return replyRepository.findByReplyBoardIdx(boardId);
    }
}