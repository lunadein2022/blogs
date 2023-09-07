package com.project.blog3.mapper;

import com.project.blog3.model.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM board")
    List<Board> getAllBoards();

    @Select("SELECT * FROM board WHERE board_idx = #{boardIdx}")
    Board getBoardById(int boardIdx);

    @Insert("INSERT INTO board (board_name, board_title, board_content) VALUES (#{board.boardName}, #{board.boardTitle}, #{board.boardContent})")
    @Options(useGeneratedKeys = true, keyProperty = "board.boardIdx")
    void addBoard(@Param("board") Board board);

    @Update("UPDATE board SET board_name = #{board.boardName}, board_title = #{board.boardTitle}, board_content = #{board.boardContent} WHERE board_idx = #{board.boardIdx}")
    void updateBoard(@Param("board") Board board);

    @Delete("DELETE FROM board WHERE board_idx = #{boardIdx}")
    void deleteBoard(int boardIdx);
}
