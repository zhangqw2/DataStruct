package com.base.node;

import com.base.exception.InvalidNodeException;

import java.util.Iterator;

/**
 * 链接表
 */
public interface LinkedList {
    /**
     * 链接表大小
     * @return
     */
    public int getSize();

    /**
     * 判断列表是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 返回第一个结点
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Node first() throws IndexOutOfBoundsException;

    /**
     * 返回最后一个结点
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Node last() throws IndexOutOfBoundsException;

    /**
     * 返回p之后的结点
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws IndexOutOfBoundsException
     */
    public Node getNext(Node p) throws InvalidNodeException,IndexOutOfBoundsException;

    /**
     * 返回p之前的结点
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws IndexOutOfBoundsException
     */
    public Node getPre(Node p) throws InvalidNodeException,IndexOutOfBoundsException;

    /**
     * 将e作为第一个元素插入列表，并返回e所在结点
     * @param e
     * @return
     */
    public Node insertFirst(Object e);

    /**
     * 将e作为最后一个元素插入列表
     * @param e
     * @return
     */
    public Node insertLast(Object e);

    /**
     * 将e插入至p之后的位置，并返回e所在结点
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    public Node insertAfter(Node p,Object e)throws InvalidNodeException;

    /**
     * 将e插入至p之前的位置，并返回e所在结点
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    public Node insertBefore(Node p,Object e)throws InvalidNodeException;

    /**
     * 删除给定位置处的元素，并返回之
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    public Object remove(Node p)throws InvalidNodeException;

    /**
     * 删除首元素，并返回之
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object removeFirst()throws IndexOutOfBoundsException;

    /**
     * 删除末元素，并返回之
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object removeLast()throws IndexOutOfBoundsException;

    /**
     * 将处于给定位置的元素替换为新元素，并返回被替换的元素
     * @return
     * @throws InvalidNodeException
     */
    public Object replace(Node p,Object e)throws InvalidNodeException;

    /**
     * 元素迭代器
     * @return
     */
    public Iterator elements();
}
