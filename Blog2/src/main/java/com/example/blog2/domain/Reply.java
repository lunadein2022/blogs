package com.example.blog2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Entity
@Table(name = "reply")
@Getter
@Setter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_idx")
    private int replyIdx;

    @Column(name = "reply_name")
    private String replyName;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reply_date")
    private Date replyDate;


    @Setter
    @Column(name = "reply_board_idx")
    private int replyBoardIdx;

    public int getReplyBoardIdx() {
        return replyBoardIdx;
    }

}
