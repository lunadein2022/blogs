package com.example.blog2.Controller;

import com.example.blog2.Service.BoardService;
import com.example.blog2.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController (BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "/board/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "/board/view";
    }


    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("board", new Board());
        return "/board/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("board") Board board) {
        boardService.saveBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("board") Board board) {
        boardService.updateBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }
}