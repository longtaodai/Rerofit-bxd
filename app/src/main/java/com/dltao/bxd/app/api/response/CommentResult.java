package com.dltao.bxd.app.api.response;


import org.w3c.dom.Comment;

/**
 * Created by zhuoapp on 16/6/29.
 */
public class CommentResult {
    private Integer result;
    private Comment comment;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
