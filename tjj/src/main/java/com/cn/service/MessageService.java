package com.cn.service;

import com.cn.dao.MessageDAO;
import com.cn.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息中心
 */
@Service
public class MessageService {
    @Autowired
    MessageDAO messageDAO;

    /**
     * 添加一个消息
     * @param message
     * @return
     */
    public int addMessage(Message message) {
        return messageDAO.addMessage(message);
    }

    /**
     * 获取描述
     * @param conversationId
     * @param offset
     * @param limit
     * @return
     */
    public List<Message> getConversationDetail(String conversationId, int offset, int limit) {
        return messageDAO.getConversationDetail(conversationId, offset, limit);
    }

    /**
     * 获取队列
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    public List<Message> getConversationList(int userId, int offset, int limit) {
        return messageDAO.getConversationList(userId, offset, limit);
    }

    /**
     * 评论数
     * @param userId
     * @param conversationId
     * @return
     */
    public int getConvesationUnreadCount(int userId, String conversationId) {
        return messageDAO.getConvesationUnreadCount(userId, conversationId);
    }
}
