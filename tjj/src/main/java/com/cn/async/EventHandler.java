package com.cn.async;

import java.util.List;

public interface EventHandler {
    void doHandle(EventModel model);

    /**
     * 获取事件类型
     * @return
     */
    List<EventType> getSupportEventTypes();
}
