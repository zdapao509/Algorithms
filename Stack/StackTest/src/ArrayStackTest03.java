/*
模拟计算器的时候

    先将字符串公式以中缀表达式的形式先存成List

    然后将List转换成后缀表达式也就是逆波兰表达式形式的集合 List2     （中缀表达式--->后缀表达式(逆波兰计算器)  PolandNotation      ）

    转成后缀表达式List2 之后，再运算。
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayStackTest03 {
    public static void main(String[] args) {

        String test="(50.5+20)*10-15+40/4*100";
        List<String> temp=toInfixExpressionList(test);//中缀表达式形式的集合得到了
        System.out.println(temp);

        List<String> temp1=toSuffixExpressionList(temp);
        System.out.println(temp1);//返回后缀表达式形式的集合

        double temp2=calculate(temp1);
        System.out.println("计算结果："+test+"="+temp2);


    }

//    提供方法：将字符串以中缀表达式的形式返回一个List
    public static List<String> toInfixExpressionList(String s){
        if(s==null){
            throw new RuntimeException("字符串为空");
        }
        List<String> list=new ArrayList<String>();
        int index=0;
        String cor="";

        while(true){
            if(isOper(s.charAt(index))){//如果是操作符，直接加入到集合中
                list.add(s.charAt(index)+"");
            }else if(isKuo(s.charAt(index))){
                list.add(s.charAt(index)+"");
            }else{//如果是数字或者是 小数点；需要进行拼接工作
                cor+=s.charAt(index);
                if(index==s.length()-1){//最后一个数字，直接将拼接结果添加到数组中
                    list.add(cor);
                    break;
                }else{
                    if(isOper(s.charAt(index+1))||isKuo(s.charAt(index+1))){//如果下一个字符是符号(计算符号或者是小括号)的话，直接拼接；
                        // 否则，不做操作，继续循环进行拼接
                        list.add(cor);
                        cor="";
                    }
                }
            }
            index++;
            if(index==s.length()){
                break;
            }
        }
        return list;
    }

//    方法：判断一个字符是不是操作符
    public static boolean isOper(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }

//    方法：判断是不是小括号：
    public static boolean isKuo(char ch){
        return ch=='('||ch==')';
    }



//    提供方法，将中缀表达式的形式转换为后缀表达式：
    /*

    1.初始化两个栈：运算符栈s1和储存中间结果的栈s2；

    2.从左至右扫描中缀表达式；

    3.遇到操作数时，将其压s2；

    4.遇到运算符时，比较其与s1栈顶运算符的优先级：

        如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
        否则，若优先级比栈顶运算符的高，也将运算符压入s1；
        否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；

    5.遇到括号时：
        (1) 如果是左括号“(”，则直接压入s1
        (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃

    6.重复步骤2至5，直到表达式的最右边

    7.将s1中剩余的运算符依次弹出并压入s2

    8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
*/

    public static List<String> toSuffixExpressionList(List<String> list){
        if(list.size()==0){
            throw new RuntimeException("集合为空，不能转换");
        }
        Stack<String> s1=new Stack<String>();
        List<String> res=new ArrayList();
        for(String ele:list){
            if(ele.matches("[+-]?[0-9]+(\\.[0-9]+)?")){//判断数据是否是数字;包括了小数-----数字直接加入队列
                res.add(ele);
            }else if(ele.equals("(")){//左括号直接入栈
                s1.push(ele);
            }else if(ele.equals(")")){//有括号就弹栈顶直到遇到左括号
                while(true){
                    if(!s1.peek().equals("(")){
                        res.add(s1.pop());
                    }else{
                        s1.pop();
                        break;
                    }
                }
            }else{
                while(true) {
                    if (s1.size() == 0 || s1.peek().equals("(")) {//栈为空或者栈中的顶为（----------这种情况直接入栈
                        s1.push(ele);
                        break;
                    } else if (getValue(s1.peek()) < getValue(ele)) {//运算符的等级更高，直接入栈
                        s1.push(ele);
                        break;
                    } else {//运算符的等级小于或者等于栈顶的运算符等级，栈顶弹出来，加到集合中。
                        res.add(s1.pop());
                    }
                }
            }
        }
        while(s1.size()>0){//如果栈里面还有东西，弹出来到集合中
            res.add(s1.pop());
        }

        return res;
    }

//    方法：判断符号的优先级：
    public static int getValue(String ch){
        if(ch.equals("+")||ch.equals("-")){//这里一定注意：字符串的比较用equals，不要用==
            return 1;
        } else if(ch.equals("*")||ch.equals("/")) {
            return 2;
        }else{
            System.out.println("传入的数："+ch);//如果用了 == 就出现两个内存地址不相等的情况，直接报错
            throw new RuntimeException("不存在的运算符");
        }
    }

//    提供方法:计算后缀表达式
    public static double calculate(List<String> list){
        if(list.size()==0){
            throw new RuntimeException("集合是空的");
        }
        Stack<Double> stack=new Stack<Double>();
        for(String ele:list){
            if(ele.matches("[+-]?[0-9]+(\\.[0-9]+)?")){
                stack.push(Double.parseDouble(ele));
            }else{
                double num2=stack.pop();
                double num1=stack.pop();
                switch(ele){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num1/num2);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
