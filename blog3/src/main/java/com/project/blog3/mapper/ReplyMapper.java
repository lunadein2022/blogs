package com.project.blog3.mapper;

import com.project.blog3.model.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("SELECT * FROM reply WHERE reply_board_idx = #{boardIdx}")
    List<Reply> getRepliesByBoardIdx(int boardIdx);

    @Insert("INSERT INTO reply (reply_name, reply_content, reply_board_idx) VALUES (#{reply.replyName}, #{reply.replyContent}, #{reply.replyBoardIdx})")
    @Options(useGeneratedKeys = true, keyProperty = "reply.replyIdx")
    void addReply(@Param("reply") Reply reply);

    @Delete("DELETE FROM reply WHERE reply_idx = #{replyIdx}")
    void deleteReply(int replyIdx);
}