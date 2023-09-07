package com.example.blog2.Service;

import com.example.blog2.domain.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getAllReplies();

    Reply getReplyById(int replyId);

    void saveReply(Reply reply);

    void updateReply(Reply reply);

    void deleteReply(int replyId);

    List<Reply> getRepliesByBoardId(int boardId);
}