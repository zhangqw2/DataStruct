package com.base.Queue;

import com.base.exception.QueueEmptyException;

public class QueueArray implements Queue {

    /**
     * 队列默认大小
     */
    private static final int CAP = 7;
    /**
     * 数据元素数组
     */
    private Object[] elements;
    /**
     * 数组大小
     */
    private int capacity;
    /**
     * 队首指针,指向队首
     */
    private int front;
    /**
     * 队尾指针,指向队尾后一个位置
     */
    private int rear;
    public QueueArray(){
        this(CAP);
    }
    public QueueArray(int cap){
        capacity = cap + 1;
        elements = new Object[capacity];
        front = rear = 0;
    }

    /**
     * 返回队列的大小
     * @return
     */
    @Override
    public int getSize() {
        return (rear-front+capacity)%capacity;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    /**
     * 数据元素e入队
     * @param e
     */
    @Override
    public void enqueue(Object e) {
        if(getSize() == capacity - 1){
            expandSpace();
        }
        elements[rear] = e;
        rear = (rear+1)%capacity;

    }

    /**
     * 扩容
     */
    public void expandSpace(){
        Object[] a = new Object[elements.length*2];
        int i = front;
        int j = 0;
        //将从front开始到rear前一个存储单元的元素复制到新数组
        while(i!=rear){
            a[j++]=elements[i];
            i=(i+1)%capacity;
        }
        elements = a;
        capacity = elements.length;
        front = 0;
        //设置新的队首、队尾指针
        rear = j;
    }

    /**
     * 队首元素出队
     * @return
     * @throws QueueEmptyException
     */
    @Override
    public Object dequeue() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException("队列为空");
        }
        Object obj = elements[front];
        elements[front] = null;
        front = (front+1)%capacity;
        return obj;
    }

    /**
     * 取队首元素
     * @return
     * @throws QueueEmptyException
     */
    @Override
    public Object peek() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException("队列为空");
        }

        return elements[front];
    }
}
