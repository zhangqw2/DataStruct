
import com.base.Queue.Queue;
import com.base.Queue.QueueArray;
import com.base.node.LinkedList;
import com.base.node.LinkedListDLNode;
import com.base.stack.Stack;
import com.base.stack.StackSLinked;
import com.base.tree.BinTreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TreeOrder.class)
public class TreeOrder {
    @Test
    public Iterator preOrder(){
        LinkedList list = new LinkedListDLNode();
        //preOrderTraverse(this.root,list);
        return list.elements();
    }
    public void preOrderTraverse(BinTreeNode rt,LinkedList list){
        if(rt == null){
            return;
        }
        BinTreeNode p = rt;
        Stack s = new StackSLinked();
        while(p!=null){
            //向左走到尽头
            while(p!=null){
                //访问根
                list.insertLast(p);
                if(p.hasRChild()){
                    //右子树根结点入栈
                    s.push(p.getRChild());
                    p = p.getlChild();
                }
                if(!s.isEmpty()){
                    //右子树根退栈遍历右子树
                    p = (BinTreeNode)s.pop();
                }
            }
        }
    }
    @Test
    public Iterator inOrder(){
        LinkedList list = new LinkedListDLNode();
        //inOrderTraverse(this.root,list);
        return list.elements();
    }
    public void inOrderTraverse(BinTreeNode rt,LinkedList list){
        if(rt==null){
            return;
        }
        BinTreeNode p = rt;
        Stack s = new StackSLinked();
        while(p!=null||!s.isEmpty()){
            //一直向左走
            while(p!=null){
                //将根结点入栈
                s.push(p);
                p = p.getlChild();
            }
            if(!s.isEmpty()){
                //取出栈顶根结点访问之
                p = (BinTreeNode)s.pop();
                list.insertLast(p);
                //转向根的右子树进行遍历
                p = p.getRChild();
            }
        }
    }

    @Test
    public Iterator postOrder(){
        LinkedList list = new LinkedListDLNode();
        //postOrderTraverse(this.root,list);
        return list.elements();
    }
    public void postOrderTraverse(BinTreeNode rt,LinkedList list){
        if(rt==null){
            return;
        }
        BinTreeNode p = rt;
        Stack s = new StackSLinked();
        while(p!=null ||!s.isEmpty() ){
            //先左后右不断深入
            while(p!=null){
                //将根结点入栈
                s.push(p);
                if(p.hasLChild()){
                    p = p.getlChild();
                }else {
                    p = p.getRChild();
                }
            }
            if(!s.isEmpty()){
                //取出栈顶根结点访问之
                p = (BinTreeNode)s.pop();
                list.insertLast(p);
            }
            //满足条件时，说明栈顶根节点右子树已访问，应出栈访问之
            while(!s.isEmpty()&&((BinTreeNode)s.peek()).getRChild()==p){
                p = (BinTreeNode)s.pop();
                list.insertLast(p);
            }
            //转向栈顶根结点的右子树继续后续遍历
            if(!s.isEmpty()){
                p = ((BinTreeNode)s.peek()).getRChild();
            }else {
                p = null;
            }
        }
    }

    public Iterator levelOrder(){
        LinkedList list = new LinkedListDLNode();
        return list.elements();
    }
    public void levelOrderTraverse(BinTreeNode rt,LinkedList list){
        if(rt == null){
            return;
        }
        Queue q = new QueueArray();
        //根结点入队
        q.enqueue(rt);
        while(!q.isEmpty()){
            //取出队首结点p并访问
            BinTreeNode p = (BinTreeNode)q.dequeue();
            list.insertLast(p);
            if(p.hasLChild()){
                //将p的非空左右孩子依次入队
                q.enqueue(p.getlChild());
            }
            if(p.hasRChild()){
                q.enqueue(p.getRChild());
            }
        }
    }
    @Test
    public BinTreeNode find(Object e){
        BinTreeNode b = new BinTreeNode();
        //b = searchE(root,e);
        return b;
    }
    public BinTreeNode searchE(BinTreeNode rt,Object e){
        if(rt == null){
            return null;
        }
        if(rt.getData().equals(e)){
            return rt;
        }
        BinTreeNode v = searchE(rt.getlChild(),e);
        if(v == null){
            v = searchE(rt.getRChild(),e);
        }
        return v;
    }


}
