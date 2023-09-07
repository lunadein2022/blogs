package com.example.blog2.Controller;

import com.example.blog2.Service.ReplyService;
import com.example.blog2.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("/list/{boardId}")
    public String list(@PathVariable("boardId") int boardId, Model model) {
        List<Reply> replies = replyService.getRepliesByBoardId(boardId);
        model.addAttribute("replies", replies);
        return "reply/list";
    }

    @GetMapping("/create/{boardId}")
    public String createForm(@PathVariable("boardId") int boardId, Model model) {
        model.addAttribute("boardId", boardId);
        model.addAttribute("reply", new Reply());
        return "reply/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("reply") Reply reply) {
        replyService.saveReply(reply);
        return "redirect:/reply/list/" + reply.getReplyBoardIdx();
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Reply reply = replyService.getReplyById(id);
        model.addAttribute("reply", reply);
        return "reply/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("reply") Reply reply) {
        replyService.updateReply(reply);
        return "redirect:/reply/list/" + reply.getReplyBoardIdx();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        Reply reply = replyService.getReplyById(id);
        int boardId = reply.getReplyBoardIdx();
        replyService.deleteReply(id);
        return "redirect:/reply/list/" + boardId;
    }
}
