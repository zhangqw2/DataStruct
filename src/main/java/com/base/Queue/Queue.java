package com.base.Queue;

import com.base.exception.QueueEmptyException;

public interface Queue {
    /**
     * 返回队列的大小
     * @return
     */
    public int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 数据元素e入队
     * @param e
     */
    public void enqueue(Object e);

    /**
     * 队首元素出队
     * @return
     * @throws QueueEmptyException
     */
    public Object dequeue()throws QueueEmptyException;

    /**
     * 取队首元素
     * @return
     * @throws QueueEmptyException
     */
    public Object peek() throws QueueEmptyException;
}
