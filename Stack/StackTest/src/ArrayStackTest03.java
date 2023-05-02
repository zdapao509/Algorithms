/*
ģ���������ʱ��

    �Ƚ��ַ�����ʽ����׺���ʽ����ʽ�ȴ��List

    Ȼ��Listת���ɺ�׺���ʽҲ�����沨�����ʽ��ʽ�ļ��� List2     ����׺���ʽ--->��׺���ʽ(�沨��������)  PolandNotation      ��

    ת�ɺ�׺���ʽList2 ֮�������㡣
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayStackTest03 {
    public static void main(String[] args) {

        String test="(50.5+20)*10-15+40/4*100";
        List<String> temp=toInfixExpressionList(test);//��׺���ʽ��ʽ�ļ��ϵõ���
        System.out.println(temp);

        List<String> temp1=toSuffixExpressionList(temp);
        System.out.println(temp1);//���غ�׺���ʽ��ʽ�ļ���

        double temp2=calculate(temp1);
        System.out.println("��������"+test+"="+temp2);


    }

//    �ṩ���������ַ�������׺���ʽ����ʽ����һ��List
    public static List<String> toInfixExpressionList(String s){
        if(s==null){
            throw new RuntimeException("�ַ���Ϊ��");
        }
        List<String> list=new ArrayList<String>();
        int index=0;
        String cor="";

        while(true){
            if(isOper(s.charAt(index))){//����ǲ�������ֱ�Ӽ��뵽������
                list.add(s.charAt(index)+"");
            }else if(isKuo(s.charAt(index))){
                list.add(s.charAt(index)+"");
            }else{//��������ֻ����� С���㣻��Ҫ����ƴ�ӹ���
                cor+=s.charAt(index);
                if(index==s.length()-1){//���һ�����֣�ֱ�ӽ�ƴ�ӽ����ӵ�������
                    list.add(cor);
                    break;
                }else{
                    if(isOper(s.charAt(index+1))||isKuo(s.charAt(index+1))){//�����һ���ַ��Ƿ���(������Ż�����С����)�Ļ���ֱ��ƴ�ӣ�
                        // ���򣬲�������������ѭ������ƴ��
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

//    �������ж�һ���ַ��ǲ��ǲ�����
    public static boolean isOper(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }

//    �������ж��ǲ���С���ţ�
    public static boolean isKuo(char ch){
        return ch=='('||ch==')';
    }



//    �ṩ����������׺���ʽ����ʽת��Ϊ��׺���ʽ��
    /*

    1.��ʼ������ջ�������ջs1�ʹ����м�����ջs2��

    2.��������ɨ����׺���ʽ��

    3.����������ʱ������ѹs2��

    4.���������ʱ���Ƚ�����s1ջ������������ȼ���

        ���s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
        ���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1��
        ���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4-1)��s1���µ�ջ���������Ƚϣ�

    5.��������ʱ��
        (1) ����������š�(������ֱ��ѹ��s1
        (2) ����������š�)���������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���

    6.�ظ�����2��5��ֱ�����ʽ�����ұ�

    7.��s1��ʣ�����������ε�����ѹ��s2

    8.���ε���s2�е�Ԫ�ز���������������Ϊ��׺���ʽ��Ӧ�ĺ�׺���ʽ
*/

    public static List<String> toSuffixExpressionList(List<String> list){
        if(list.size()==0){
            throw new RuntimeException("����Ϊ�գ�����ת��");
        }
        Stack<String> s1=new Stack<String>();
        List<String> res=new ArrayList();
        for(String ele:list){
            if(ele.matches("[+-]?[0-9]+(\\.[0-9]+)?")){//�ж������Ƿ�������;������С��-----����ֱ�Ӽ������
                res.add(ele);
            }else if(ele.equals("(")){//������ֱ����ջ
                s1.push(ele);
            }else if(ele.equals(")")){//�����ž͵�ջ��ֱ������������
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
                    if (s1.size() == 0 || s1.peek().equals("(")) {//ջΪ�ջ���ջ�еĶ�Ϊ��----------�������ֱ����ջ
                        s1.push(ele);
                        break;
                    } else if (getValue(s1.peek()) < getValue(ele)) {//������ĵȼ����ߣ�ֱ����ջ
                        s1.push(ele);
                        break;
                    } else {//������ĵȼ�С�ڻ��ߵ���ջ����������ȼ���ջ�����������ӵ������С�
                        res.add(s1.pop());
                    }
                }
            }
        }
        while(s1.size()>0){//���ջ���滹�ж�������������������
            res.add(s1.pop());
        }

        return res;
    }

//    �������жϷ��ŵ����ȼ���
    public static int getValue(String ch){
        if(ch.equals("+")||ch.equals("-")){//����һ��ע�⣺�ַ����ıȽ���equals����Ҫ��==
            return 1;
        } else if(ch.equals("*")||ch.equals("/")) {
            return 2;
        }else{
            System.out.println("���������"+ch);//������� == �ͳ��������ڴ��ַ����ȵ������ֱ�ӱ���
            throw new RuntimeException("�����ڵ������");
        }
    }

//    �ṩ����:�����׺���ʽ
    public static double calculate(List<String> list){
        if(list.size()==0){
            throw new RuntimeException("�����ǿյ�");
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
