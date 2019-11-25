package com.base.stack;

import com.base.exception.StackEmptyException;

public interface Stack {
    /**
     * 返回堆栈的大小
     * @return
     */
    public int getSize();

    /**
     * 判断堆栈是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 数据元素e入栈
     * @param e
     */
    public void push(Object e);

    /**
     * 栈顶元素出栈
     * @return
     * @throws StackEmptyException
     */
    public Object pop() throws StackEmptyException;

    /**
     * 取栈顶元素
     * @return
     * @throws StackEmptyException
     */
    public Object peek() throws StackEmptyException;
}
