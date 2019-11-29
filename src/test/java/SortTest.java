

import com.alibaba.fastjson.JSONObject;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;

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

    /**
     * 直接插入排序
     * @param r
     * @param low
     * @param high
     */
    public void insertSort(Object[] r,int low,int high){
        for (int i = low+1; i <=high; i++) {
            if(r[i].toString().compareTo(r[i-1].toString())<0){
                Object temp = r[i];
                r[i]=r[i-1];
                int j=i-2;
                for(;j>=low&&temp.toString().compareTo(r[j].toString())<0;j--){
                    r[j+1]=r[j];
                }
                r[j+1]=temp;
            }
        }
    }

    /**
     * 折半插入排序
     * @param r
     * @param low
     * @param high
     */
    public void binInsertSort(Object[] r,int low,int high){
        for (int i = low+1; i <= high ; i++) {
            //保存待插入元素
            Object temp = r[i];
            //设置初始区间
            int hi = i - 1;
            int lo = low;

            while(lo<=hi){
                int mid = (lo+hi)/2;
                if(temp.toString().compareTo(r[mid].toString())<0){
                    hi = mid -1;
                }else {
                    lo = mid + 1;
                }
            }
            for(int j = i-1;j>hi;j--){
                //移动元素
                r[j+1]=r[j];
            }
            r[hi+1] = temp;
        }
    }

    /**
     * 希尔排序
     * @param r
     * @param low
     * @param high
     * @param delta
     */
    public void shellSort(Object[] r,int low,int high,int []delta){
        for (int i = 0; i < delta.length; i++) {
            shellInsert(r,low,high,delta[i]);
        }
    }
    public void shellInsert(Object[] r,int low,int high,int deltak){
        for (int i = low+deltak; i <= high; i++) {
            if(r[i].toString().compareTo(r[i-deltak].toString())<0){
                Object temp = r[i];
                int j = i-deltak;
                for (;j>=low&&temp.toString().compareTo(r[j].toString())<0;j=j-deltak){
                    r[j+deltak]=r[i];
                }
                r[j+deltak]=temp;
            }

        }
    }

    /**
     * 冒泡排序
     * @param r
     * @param low
     * @param high
     */
    public void bubbleSort(Object[] r,int low,int high){
        int n = high-low+1;
        for (int i = 1; i < n; i++) {
            for (int j = low; j <= high-i ; j++) {
                if(r[j].toString().compareTo(r[j+1].toString())>0){
                    Object temp = r[j];
                    r[j]=r[j+1];
                    r[j+1] = temp;
                }
            }

        }
    }

    public int partition(Object[] r,int low,int high){
        //使用r[low]作为枢轴元素
        Object pivot = r[low];
        //从两端交替向内扫描
        while(low<high){
            while(low<high&&r[high].toString().compareTo(pivot.toString())>=0){
                high--;
            }
            //将比pivot小的元素移向低端
            r[low]=r[high];
            while(low<high&&r[low].toString().compareTo(pivot.toString())<=0){
                low++;
            }
            //将比pivot大的元素移向高端
            r[high]=r[low];
        }
        //设置枢轴
        r[low]=pivot;
        //返回枢轴元素位置
        return low;
    }

    /**
     * 快速排序
     * @param r
     * @param low
     * @param high
     */
    public void quickSort(Object[] r,int low,int high){
        if(low<high){
            int pa = partition(r,low,high);
            quickSort(r,low,pa-1);
            quickSort(r,pa+1,high);
        }
    }

    /**
     * 筛选
     * @param r
     * @param low
     * @param high
     */
    public void heapAdjust(Object[] r, int low,int high){
        Object temp = r[low];
        //沿关键之较大的元素向下进行筛选
        for (int j = 2*low; j <= high ; j=j*2) {
            if(j<high&&r[j].toString().compareTo(r[j+1].toString())<0){
                j++;
            }
            if(temp.toString().compareTo(r[j].toString())>=0){
                break;
            }
            //向下筛选
            r[low]=r[j];
            low = j;
        }
        r[low]=temp;
    }

    /**
     * 堆排序
     * @param r
     */
    public void heapSort(Object[] r){
        int n = r.length - 1;
        //初始化建堆
        for(int i = n/2;i>=1;i--){
            heapAdjust(r,i,n);
        }
        //不断输出堆顶元素并调整r[1..i-1]
        for(int i = n;i>1;i--){
            //交换堆顶与堆底元素
            Object temp = r[1];
            r[1]=r[i];
            r[i]=temp;
            //调整
            heapAdjust(r,1,i-1);
        }
    }

    public void merge(Object[] a,int p ,int q,int r){
        Object[] b = new Object[r-p+1];
        int s = p;
        int t = q+1;
        int k =0;
        while(s<=q&&t<=r){
            if(a[s].toString().compareTo(a[t].toString())<0){
                b[k++]=a[s++];
            }else{
                b[k++] =a[t++];
            }
        }
        while(s<=q){
            b[k++]=a[s++];
        }
        while(t<=r){
            b[k++]=a[t++];
        }
        for(int i=0;i<b.length;i++){
            a[p+i]=b[i];
        }
    }

    /**
     * 归并排序
     * @param r
     * @param low
     * @param high
     */
    public void mergeSort(Object[] r,int low, int high){
        if(low<high){
            mergeSort(r,low,(high+low)/2);
            mergeSort(r,(high+low)/2,high);
            merge(r,low,(high+low)/2,high);
        }
    }




}
