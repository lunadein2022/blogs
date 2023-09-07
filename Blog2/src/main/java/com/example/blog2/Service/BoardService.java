package com.example.blog2.Service;

import com.example.blog2.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> getAllBoards();

    Board getBoardById(int boardId);

    void saveBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(int boardId);

    List<Board> searchBoardsByTitle(String title);
}