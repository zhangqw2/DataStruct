

import com.alibaba.fastjson.JSONObject;
import com.base.node.Node;
import com.base.tree.BinTreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.CompareEqual;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SortTest.class)
public class SortTest {
    private int[] a = {8,1,3,4,6,2,9,0,7};
    private int[] b = {5,5,6,7,9,10};
    private int[] d = {0,2,4,6,7};

    /**
     * 选择排序
     */
    @Test
    public void selectSort(){
        int n = a.length;

        for(int k = 0;k<n-1;k++){
            int min = k;
            for (int i = k+1; i < n; i++) {
                if(a[i]<a[min]){
                    min = i;
                }

            }
            if(k!=min){
                int temp = a[k];
                 a[k] = a[min];
                 a[min] = temp;
            }
            System.out.println("第"+(k+1)+"轮排序结果: "+JSONObject.toJSONString(a));
        }
        System.out.printf("最终结果"+JSONObject.toJSONString(a));

    }

    /**
     * 将两个整型非递减数组合并为一个新的非递减数组
     */
    @Test
    public void merge(){
        int pa = 0,pb = 0,pc = 0;
        int m = d.length;
        int n = b.length;
        int[] c= new int[m+n];

        while(pa<m&&pb<n){
            if(d[pa]<b[pb]){
                c[pc++]=d[pa++];
            }else{
                c[pc++]=b[pb++];
            }
        }
        if(pa<m){
            while(pa<m){
                c[pc++]=d[pa++];
            }
        }else{
            while(pb<n){
                c[pc++]=b[pb++];
            }
        }
        System.out.println(JSONObject.toJSONString(c));
    }

    /**
     *  二分查找
     * @param s
     * @param low
     * @param high
     * @param key
     * @return
     */
    public int binSearch(int[] s,int low, int high,int key){
        while(low<=high){
            int mid = (low+high)/2;
            if(s[mid]==key){
                return mid;
            }else if(s[mid]>key){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }







}
