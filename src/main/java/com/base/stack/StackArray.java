package com.base.stack;

import com.base.exception.StackEmptyException;

public class StackArray implements Stack {
    /**
     * 数组的默认大小
     */
    private final int LEN = 8;
    /**
     * 数据元素数组
     */
    private Object[] elements;
    /**
     *  栈顶指针
     */
    private int top;

    public StackArray(){
        top = -1;
        elements = new Object[LEN];
    }

    /**
     *  返回堆栈的大小
     * @return
     */
    @Override
    public int getSize() {
        return top+1;
    }

    /**
     * 判断堆栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top<0;
    }

    /**
     * 数据元素e入栈
     * @param e
     */
    @Override
    public void push(Object e) {
        if(getSize()>=elements.length){

        }
        elements[++top] = e;

    }

    /**
     * 增倍扩容
     */
    public void expandSpace(){
        Object[] a = new Object[elements.length*2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    /**
     * 栈顶元素出栈
     * @return
     * @throws StackEmptyException
     */
    @Override
    public Object pop() throws StackEmptyException {
        if(getSize()<1){
            throw new StackEmptyException("堆栈为空");
        }
        Object obj = elements[top];
        elements[top--] = null;
        return obj;
    }

    @Override
    public Object peek() throws StackEmptyException {
        if(getSize()<1){
            throw new StackEmptyException("堆栈");
        }
        return elements[top];
    }
}
