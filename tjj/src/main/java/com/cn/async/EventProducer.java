package com.cn.async;

import com.alibaba.fastjson.JSONObject;
import com.cn.util.JedisAdapter;
import com.cn.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class EventProducer {
    @Autowired
    JedisAdapter jedisAdapter;

    /**
     *  是否产生了事件
     *  点赞,登陆,邮件,评论
     * @param model
     * @return
     */
    public boolean fireEvent(EventModel model) {
        try {
            String json = JSONObject.toJSONString(model);
            String key = RedisKeyUtil.getEventQueueKey();
            jedisAdapter.lpush(key, json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
