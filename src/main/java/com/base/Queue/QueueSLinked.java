package com.base.Queue;

import com.base.exception.QueueEmptyException;
import com.base.node.SLNode;

public class QueueSLinked implements Queue {
    private SLNode front;
    private SLNode rear;
    private int size;
    public QueueSLinked(){
        front = new SLNode();
        rear = front;
        size = 0;
    }

    /**
     * 返回队列的大小
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数据元素e入队
     * @param e
     */
    @Override
    public void enqueue(Object e) {
        SLNode p = new SLNode(e,null);
        rear.setNext(p);
        rear = p;
        size++;

    }

    /**
     *  队首元素出队
     * @return
     * @throws QueueEmptyException
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        if(size<1){
            throw new QueueEmptyException("队列为空");
        }
        SLNode p = front.getNext();
        front.setNext(p.getNext());
        size--;
        //如果队列为空,rear指向头结点
        if(size<1){
            rear=front;
        }
        return p.getData();
    }

    /**
     * 取队首元素
     * @return
     * @throws QueueEmptyException
     */
    @Override
    public Object peek() throws QueueEmptyException {
        if(size<1){
            throw new QueueEmptyException("队列为空");
        }
        return front.getNext().getData();
    }
}
