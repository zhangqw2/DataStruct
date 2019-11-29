import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IteratorTest.class)
public class IteratorTest {
    private List<String>  list = new ArrayList<>();

    private List<String> arrayList = Arrays.asList("1","2","3","4","5");


    @Before
    public void contextLoad(){
        for(int i=0;i<5;i++){
            list.add(String.valueOf(i));
        }
    }

    @Test
    public void listForDelete(){
        //UnsupportedOperationException
//        for(String str: arrayList){
//            arrayList.remove("2");
//        }
//        System.out.println(arrayList);
        //ConcurrentModificationException
//        for(String str: list){
//            list.remove("2");
//        }

        for(int i = list.size()- 1;i>=0;i--){
            if("2".equals(list.get(i))){
                list.remove(list.get(i));
            }
        }

        System.out.println(list);

    }
    @Test
    public void arrayListTest(){
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("2".equals(obj)){
                //集合的remove
                list.remove(obj);
                //迭代器自己的remove,UnsupportedOperationException
                //iterator.remove();
            }
        }
        System.out.println(arrayList);
    }
    @Test
    public void listTest(){
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            Object obj = iterator.next();
//            if("2".equals(obj)){
//                //集合的remove，ConcurrentModificationException
//                //list.remove(obj);
//                //迭代器自己的remove
//                iterator.remove();
//            }
//        }
//        System.out.println(list);


        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            if(Integer.valueOf(listIterator.next().toString())%2==0){
                listIterator.set("new value");
            }
        }
        System.out.println(list);
    }
}
