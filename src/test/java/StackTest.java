import com.base.stack.Stack;
import com.base.stack.StackSLinked;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StackTest.class)
public class StackTest {

    /**
     * 十进制转八进制
     */
    @Test
    public void baseConversionTest(){
        baseConversion(2007);
    }

    public void baseConversion(int i){
        Stack s = new StackSLinked();
        while (i>0){
            s.push(i%8+"");
            i=i/8;
        }
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }

    /**
     * 括号匹配检测
     * @param str
     * @return
     */
    public boolean bracketMatch(String str){
        Stack s = new StackSLinked();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c){
                case '{':
                case '[':
                case '(': s.push(Integer.valueOf(c));break;
                case '}':
                    if(!s.isEmpty()&&((Integer)s.pop()).intValue() == '[')break;
                    else return false;
                case ')':
                    if(!s.isEmpty()&& ((Integer)s.pop()).intValue()=='(')break;
                    else return false;
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
