package com.base.search;

import com.base.iterator.Iterator;
import com.base.node.Node;

public interface SearchTable {
    /**
     * 查询查找表当前的规模
     * @return
     */
    public int getSize();

    /**
     * 判断查找表是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 返回查找表中与元素ele关键字相同的元素位置；否则，返回null
     * @param ele
     * @return
     */
    public Node search(Object ele);

    /**
     * 返回所有关键字与元素ele相同的元素位置
     * @param ele
     * @return
     */
    public Iterator searchAll(Object ele);

    /**
     * 按关键字插入元素ele
     * @param ele
     */
    public void insert(Object ele);

    /**
     * 若查找表中存在与元素ele关键字相同的元素，则删除一个并返回；否则返回null
     * @param ele
     * @return
     */
    public Object remove(Object ele);
}
