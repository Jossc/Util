package com.cn.service;

import com.cn.dao.CommentDAO;
import com.cn.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论中心
 */
@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public List<Comment> getCommentsByEntity(int entityId, int entityType) {
        return commentDAO.selectByEntity(entityId, entityType);
    }
    /**
     * 添加评论
     * @param comment
     * @return
     */
    public int addComment(Comment comment) {
        return commentDAO.addComment(comment);
    }

    /**
     * 获取评论
     * @param entityId
     * @param entityType
     * @return
     */
    public int getCommentCount(int entityId, int entityType) {
        return commentDAO.getCommentCount(entityId, entityType);
    }

    /**
     * 删除
     * @param entityId
     * @param entityType
     */
    public void deleteComment(int entityId, int entityType) {
        commentDAO.updateStatus(entityId, entityType, 1);
    }
}
