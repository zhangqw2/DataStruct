package com.base.array;

public interface List {
    /**
     * 返回线性表的大小，即数据元素的个数
     * @return
     */
    public int getSize();

    /**
     * 如果线性表为空返回true，否则返回false
     * @return
     */
    public boolean isEmpty();

    /**
     * 判断线性表是否包含数据元素e
     * @param e
     * @return
     */
    public boolean contains(Object e);

    /**
     * 返回数据元素e在线性表中的序号
     * @param e
     * @return
     */
    public int indexOf(Object e);

    /**
     * 将数据元素e插入到线性表中i号位置
     * @param i
     * @param e
     * @throws IndexOutOfBoundsException
     */
    public void insert(int i,Object e) throws IndexOutOfBoundsException;

    /**
     * 将数据元素e插入到元素obj之后
     * @param obj
     * @param e
     * @return
     */
    public boolean insertBefore(Object obj,Object e);

    /**
     * 将数据元素e插入到元素obj之后
     * @param obj
     * @param e
     * @return
     */
    public boolean insertAfter(Object obj,Object e);

    /**
     * 删除线性表中序号为i的元素，并返回之
     * @param e
     * @return
     */
    public Object remove(Object e) ;

    /**
     * 替换线性表中序号为i的数据元素为e，返回原数据元素
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object replace(int i, Object e)throws IndexOutOfBoundsException;

    /**
     * 返回线性表中序号为i的数据元素
     * @param i
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object get(int i) throws IndexOutOfBoundsException;
}
