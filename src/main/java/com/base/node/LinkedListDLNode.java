package com.base.node;

import com.base.exception.InvalidNodeException;

import com.base.iterator.LinkedListIterator;

import java.util.Iterator;


public class LinkedListDLNode implements LinkedList {
    /**
     * g规模
     */
    private int size;
    /**
     * 头结点，哑元结点
     */
    private DLNode head;
    /**
     * 尾结点，哑元结点
     */
    private DLNode tail;

    public LinkedListDLNode(){
        size = 0;
        head = new DLNode();
        tail = new DLNode();
        head.setNext(tail);
        tail.setPre(head);
    }

    protected DLNode checkPosition(Node p)throws InvalidNodeException{
        if(p==null){
            throw new InvalidNodeException("结点为空");
        }
        if(p==head){
            throw new InvalidNodeException("指向头结点，非法");
        }
        if(p==tail){
            throw new InvalidNodeException("指向尾结点，非法");
        }
        DLNode node = (DLNode)p;
        return node;
    }

    /**
     * 查询链接表当前的规模
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断链接表是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     *  返回第一个结点
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Node first() throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("链接表为空");
        }
        return head.getNext();
    }

    /**
     * 返回最后一结点
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Node last() throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("链接表为空");
        }
        return tail.getPre();
    }

    /**
     * 返回p之后的结点
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Node getNext(Node p) throws InvalidNodeException, IndexOutOfBoundsException {
        DLNode node = checkPosition(p);
        node = node.getNext();
        if(node==tail){
            throw new IndexOutOfBoundsException("已经是链接表尾端");
        }
        return node;
    }

    /**
     * 返回p之前的结点
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Node getPre(Node p) throws InvalidNodeException, IndexOutOfBoundsException {
        DLNode node = checkPosition(p);
        node = node.getPre();
        if(node==head){
            throw new IndexOutOfBoundsException("已经是链接表前段");
        }
        return node;
    }

    /**
     * 将e作为第一个元素插入链接表
     * @param e
     * @return
     */
    @Override
    public Node insertFirst(Object e) {
        DLNode node = new DLNode(e,head,head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
        size++;
        return node;
    }

    /**
     * 将e插入最后的位置，并返回e所在结点
     * @param e
     * @return
     */
    @Override
    public Node insertLast(Object e) {
        DLNode node = new DLNode(e,tail.getPre(),tail);
        tail.getPre().setNext(node);
        tail.setPre(node);
        size++;
        return node;
    }

    /**
     * 将e插入至p之后的位置，并返回e所在结点
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    @Override
    public Node insertAfter(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e,node,node.getNext());
        node.getNext().setPre(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }

    /**
     * 将e插入至p之前的位置，并返回e所在结点
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    @Override
    public Node insertBefore(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e,node.getPre(),node);
        node.getPre().setNext(newNode);
        node.setPre(newNode);
        size++;
        return newNode;
    }

    /**
     * 删除给定位置处的元素并返回之
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    @Override
    public Object remove(Node p) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        size--;
        return obj;
    }

    /**
     * 删除首元素，并返回之
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Object removeFirst() throws IndexOutOfBoundsException {

        return remove(head.getNext());
    }

    /**
     * 删除末元素，并返回之
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Object removeLast() throws IndexOutOfBoundsException {
        return remove(tail.getPre());
    }

    /**
     * 将处于给定位置的元素替换为新元素，并返回被替换的元素
     * @return
     * @throws InvalidNodeException
     */
    @Override
    public Object replace(Node p,Object e) throws InvalidNodeException {
        DLNode node =checkPosition(p);
        Object obj = node.getData();
        node.setData(e);
        return obj;
    }

    @Override
    public Iterator elements() {
        return (Iterator) new LinkedListIterator(this);
    }
}
