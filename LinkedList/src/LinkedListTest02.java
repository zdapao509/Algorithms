import java.util.Stack;

/*
Ϊ������ӵ�ֵ��˳����ӣ���ʹ������ӣ���Ӻ��ֵҲ�ǰ�����˳�������

�������нڵ����Ϣ�����޸ģ�����no ���޸ģ��� no �ǲ��ܱ��

��������Ϣ����ɾ��

�������Է��֣�

    ���ǲ��������������������Ҫ�趨����������
    ���������ʼ��λ�ÿ�����ͷ����λ�ã�����Ҫ��ӡ�ɾ��ĳ�ڵ�ʱ��Ҫ�ҵ���Ҫ�����ڵ��ǰһ���ڵ㡣--�����ȱ仯����ǰ��һ���ڵ㣬temp����Ҫ�������ǰһ���㣩
    Ҳ������ͷ������һ���ڵ㣨��Ҫ�����ڵ�����޸�ĳ���ڵ�ʱ��Ҫ�ҵ���Ҫ�����Ľڵ�---�����Ȳ��䣬�Ҷ�Ӧ�Ľڵ㣬temp�ʹ���Ҫ�����ĵ㣩

* */
public class LinkedListTest02 {
    public static void main(String[] args) {
        HerosList01 hero1=new HerosList01(1,"�ν�","��ʱ��");
        HerosList01 hero2=new HerosList01(2,"¬����","������");
        HerosList01 hero3=new HerosList01(3,"����","�Ƕ���");
        HerosList01 hero4=new HerosList01(4,"�ֳ�","����ͷ");
        HerosList01 hero5=new HerosList01(5,"xxx","xxx---");

        HerosLinkedList01 herosLinkedList=new HerosLinkedList01();
        herosLinkedList.showLinkedList();

        herosLinkedList.addLinkedListOrder(hero1);
        herosLinkedList.showLinkedList();

        herosLinkedList.addLinkedListOrder(hero2);
        herosLinkedList.addLinkedListOrder(hero3);
        herosLinkedList.showLinkedList();

        herosLinkedList.addLinkedListOrder(hero2);
        herosLinkedList.addLinkedListOrder(hero3);
        herosLinkedList.showLinkedList();//�ظ����

        herosLinkedList.addLinkedListOrder(hero5);
        herosLinkedList.addLinkedListOrder(hero4);
        herosLinkedList.showLinkedList();//�������

        HerosList01 hero5_0=new HerosList01(5,"����","����");//�޸�����ڵ���Ϣ������no ��ǩ
        herosLinkedList.update(hero5_0);
        herosLinkedList.showLinkedList();

/*        herosLinkedList.delate(1);//ɾ���ڵ�
        herosLinkedList.showLinkedList();
        herosLinkedList.delate(5);//ɾ���ڵ�
        herosLinkedList.showLinkedList();

        System.out.println("���������Ч�ڵ�����Ϊ��"+getLength(herosLinkedList.getHerohead()));

        herosLinkedList.delate(2);//ɾ���ڵ�
        herosLinkedList.showLinkedList();
        try{
            System.out.println("������k���Ľڵ�Ϊ��"+getKnode(herosLinkedList.getHerohead(),5));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("******************************************");
        herosLinkedList.setHerohead(turnAround(herosLinkedList.getHerohead()));//��ת����
        herosLinkedList.showLinkedList();*/

        System.out.println("******************************************");
        reversePrint(herosLinkedList.getHerohead());//��β��ͷ���

    }

//    �ṩһ������Ч�ڵ������ķ����������ͷ��㣬����������
    public static int getLength(HerosList01 head){//������ͷ��㿪ʼ����
        if(head.heroslist==null){//ͷ�����һ���ڵ����Ϊnull��������Ч�ڵ���Ϊ0
            return 0;
        }
        HerosList01 temp=head.heroslist;//���ø�����������ͷ�����һ���ڵ㿪ʼ������Ҳ���Ǵӵ�һ����Ч�ڵ㿪ʼ����
        int count =0;//����
        while(temp!=null){//��ǰ���������д�������ǿյģ�����ڵ���ڣ���Ч�ڵ�����һ
            count++;
            temp=temp.heroslist;//ƽ�Ƹ��������������������д���ڴ��ַ�����һλ��
        }
        return count;
    }

//    ���ҵ������еĵ�����K���ڵ�----���������⣺
//    ˼·��
//    1.��дһ������������head�ڵ㣬ͬʱ����һ��kֵ
//    2.k��ʾ������k��ֵ
//    3.�Ȱ��������һ�飬�õ�������ܳ��ȣ�getLength
//    4.�õ�������֮�󣬴�����ĵ�һ������ʼ���������� ��������-k�� �����Ϳ��Եõ�
//    5.����õ��ˣ��򷵻ؽڵ㣬���򷵻�null
//    ----------------------------------------------��������ʵ������û�г��ȵģ���Ҫ��������֪������ľ������

    public static HerosList01 getKnode(HerosList01 head,int k){

        if(head.heroslist==null){//����Ϊ�գ��Ǿ�û���ҵ�
            return null;
        }

        int realLength=getLength(head);//�ȼ�������ĳ���

        if(k<=0||k>realLength){//У������ֵ
            throw new RuntimeException("����kֵ������Χ");
        }

        HerosList01 temp=head.heroslist;//������ʱ��tempֱ��ָ����һ���ڵ�

        for (int i = 0; i < realLength-k; i++) {
            temp=temp.heroslist;
        }
        return temp;
    }

//    ��ת����˫ָ�뷨��һ��ָ��ԭʼͷ����һ��ָ��ԭʼͷ������һ���ڵ㡣��Ҫ��һ������ͷ����һֱָ�����µ�ͷ��
    public static HerosList01 turnAround(HerosList01 head){
        if(head.heroslist==null||head.heroslist.heroslist==null){
            return head.heroslist;
        }
        HerosList01 temp=head.heroslist;
        HerosList01 temp1=head.heroslist.heroslist;
        HerosList01 res=head.heroslist;
        HerosList01 result=new HerosList01();

        while(temp1!=null){
            temp.heroslist=temp1.heroslist;
            temp1.heroslist=res;
            res=temp1;
            temp1=temp.heroslist;
        }

        result.heroslist=res;//ע�⣬ͷ��㲻�����ݵ�ʱ�򣬾�һ��Ҫ��ͷ�������ǣ�
        // ������ǣ��ҷ�ת֮����ʵ����һ���յ�ͷ���������ݣ�ֻ���ҷ�ת֮���ͷ��
        return result;
    }

//    ��β��ͷ�������
    public static void reversePrint(HerosList01 head){
        if(head==null){
            return;
        }
        Stack<HerosList01> stack=new Stack<HerosList01>();
        HerosList01 temp=head.heroslist;
        while(temp!=null){
            stack.add(temp);
            temp=temp.heroslist;
        }
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
class HerosLinkedList01{//�����������
    //    ��ʼ������ͷ��
    private HerosList01 herohead=new HerosList01();//����ע�⣺����ͷ����˽�л�

    public HerosList01 getHerohead(){
        return herohead;
    }

    public void setHerohead(HerosList01 herohead){
        this.herohead=herohead;
    }

    //    �ṩ������ӷ�����
    public void addLinkedListOrder(HerosList01 hero){

        HerosList01 temp=herohead;//ͷ���λ�ò��ܱ䣬��Ҫ���������������ҵ���ӵ�λ�ã�ע������ĸ����ڵ㣬
                                    // һֱָ����ǣ�Ҫ���λ�õ�ǰ�棬����Ҫ���2����temp=1

        boolean flag=false;//flsg��־��ӵı���Ƿ���ڣ����ھͲ��벻�ˡ�

        while(true){
            if(temp.heroslist==null){
                break;
            }else if(temp.heroslist.no==hero.no){
                flag=true;
                break;
            }else if(temp.heroslist.no>hero.no){//ֻ���ҵ���Ҫ��ӵ��������λ�ã���֪���������������ˣ���tempֵ������Ҫ��ӵ��������ǰһ���ڵ�ֵ
                break;
            }
            temp=temp.heroslist;//�������һ��ѭ��֮��û���ҵ����ֵ��λ�ã��Ǿ͸��¸���������ֱ���ҵ�����ʵ�λ��
        }

        if(!flag){
            hero.heroslist=temp.heroslist;//��������ӵĽڵ��heroslist���Ե���temp.heroslist���ԡ�
            temp.heroslist=hero;//Ȼ����temp.heroslist���Ե���heros��
        }else{
            System.out.println("����ӱ�ţ�"+hero.no+"�����������");
        }

    }

    //    �ж������ǲ��ǿյģ�
    public boolean isEmpty(){
        return herohead.heroslist==null;
    }

    //    ��ʾ�б��е����е�����
    public void showLinkedList(){
        if(isEmpty()){//����Ϊ�գ�ֱ�ӷ��ؿ�
            System.out.println("����Ϊ��");
            return;
        }

        HerosList01 temp1=herohead.heroslist;         //��Ϊͷ��㲻�ܶ���������Ҫһ�������ڵ�������
        // -------��Ϊ����˴�˵������Ϊ�գ�Ҳ���������heroslist����һ����ֵ������null������ֱ�Ӵ��������ĵ�һ���ڵ㿪ʼ������ע�⣺ͷ��㲻�ǵ�һ���ڵ㣩

        while(true){

            System.out.println(temp1);//������һ���㣬��Ȼ�Ѿ��ж������ǿյ��ˣ��ǵ�һ������ֵһ�����еģ������������
            // Ȼ���жϵ�һ�������heroslist�����ǲ���Ϊ�գ�

            if(temp1.heroslist==null){
                System.out.println("������β��");
                return;
            }

            temp1=temp1.heroslist;
        }


    }

    //        �ṩ�޸Ľڵ���Ϣ�ķ�����
    public void update(HerosList01 heroslist01){
        if(isEmpty()){
            return;
        }

        HerosList01 temp=herohead.heroslist;
        boolean flag=false;

        while(true){
            if(temp==null){//
                break;
            }
            if(temp.no==heroslist01.no){
                flag=true;
                break;
            }
            temp=temp.heroslist;
        }

        if(flag){
            temp.name=heroslist01.name;
            temp.nickname= heroslist01.nickname;
        }else{
            System.out.println("δ�Ҷ�Ӧ���");
        }
    }

//    �ṩɾ���ڵ����Ϣ��
    public void delate(int num){// ����Ĳ���Ӧ���ǣ� һ�������������ɾ�������ж�Ӧ��ŵ���
        if(isEmpty()){
            System.out.println("����Ϊ��");
            return;
        }

        HerosList01 temp=herohead;//ע�⣺ͷ�ڵ��ǲ��ܱ��-------���������ҵ��ж�������ָ����һ��ֵ��
        // ���ԣ�����Ŀ�ʼ�������Ϊͷ��������ͷ������һ���ڵ㣬����©����һ���ڵ�-------���update�ǲ�һ����

        boolean flag=false;//�жϣ��Ƿ��ҵ���Ӧ�Ľڵ�

        while(true){
            if(temp.heroslist==null){
                break;
            }
            if(temp.heroslist.no==num){//tempָ�����ǣ�Ҫɾ���ڵ��ǰһ��ֵ------
                                                // ��update�ǲ�һ���ģ�update�е�tempһֱָ���Ӧ�ڵ��λ��---------���Ӱ�쵽�ҵ��ж�����
                flag=true;
                break;
            }
            temp=temp.heroslist;//���¸����������˱���һֱָ��Ҫɾ���ڵ���ŵ� ǰһ���ڵ�
        }

        if(flag){
            temp.heroslist=temp.heroslist.heroslist;//�����ɾ�����ǽ�Ҫɾ���ڵ�� ǰ��һ���ڵ� �� �� ����һ���ڵ������ ��ֵ�����޸ģ�
            // �ĳ�Ҫɾ���ڵ�ĺ���һ���ڵ㣬Ҳ���� temp.heroslist.heroslist------temp.heroslist ����Ҫɾ����
            // temp.heroslist.heroslist����Ҫɾ���ڵ����һ���ڵ�
        }else{
            System.out.println("û�д˽ڵ�"+num+"���޷�ɾ��");
        }
    }
}
class HerosList01{//ÿһ������ڵ�Ӧ�ð�������Ϣ
    public int no;
    public String name;
    public String nickname;
    public HerosList01 heroslist;

    public HerosList01(){}

    public HerosList01(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    //    ��дtoString�������������HerosList��������õ�ʱ��ֱ�ӵ��ö����toString()������
    public String toString(){
        return "�źţ�"+this.no+"��  ���֣�"+this.name+",  �ºţ�"+this.nickname;
    }
}
