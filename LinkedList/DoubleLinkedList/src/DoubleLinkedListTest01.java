/*
˫������
    �ڵ�������Ļ�����ÿ���ڵ��ֶ���һ��pre������������ýڵ����һ���ڵ�
* */

public class DoubleLinkedListTest01 {
    public static void main(String[] args) {
        HerosLinkedList01 herosLinkedList01=new HerosLinkedList01();
        HerosList01 hero1=new HerosList01(1,"�ν�","��ʱ��");
        HerosList01 hero2=new HerosList01(2,"¬����","������");
        HerosList01 hero3=new HerosList01(3,"����","�Ƕ���");
        HerosList01 hero4=new HerosList01(4,"�ֳ�","����ͷ");
        HerosList01 hero5=new HerosList01(5,"xxx","xxx---");

        herosLinkedList01.addLinkedListOrder(hero1);//��ӽڵ�
        herosLinkedList01.addLinkedListOrder(hero2);
        herosLinkedList01.showLinkedList();

        herosLinkedList01.addLinkedListOrder(hero2);//�����ظ����
        herosLinkedList01.showLinkedList();

        herosLinkedList01.addLinkedListOrder(hero5);//�������
        herosLinkedList01.addLinkedListOrder(hero4);
        herosLinkedList01.addLinkedListOrder(hero3);
        herosLinkedList01.showLinkedList();

        herosLinkedList01.delate(4);//ɾ���ڵ�
        herosLinkedList01.showLinkedList();

        HerosList01 hero5_0=new HerosList01(5,"����","����");//�޸�����ڵ���Ϣ������no ��ǩ
        herosLinkedList01.update(hero5_0);
        herosLinkedList01.showLinkedList();
    }
}

class HerosLinkedList01{//����˫��������࣬�ṩ�������ɾ�Ĳ鷽��
    //    ��ʼ������ͷ��
    private HerosList01 herohead=new HerosList01();//����ע�⣺����ͷ����˽�л�

    public HerosList01 getHerohead(){
        return herohead;
    }

    public void setHerohead(HerosList01 herohead){
        this.herohead=herohead;
    }

    //    �ṩ������ӷ�����-----�ҵ���������һ���ڵ�Ȼ����ӽ�ȥ�����߰��������ҵ��ڵ��λ��������
    public void addLinkedListOrder(HerosList01 hero){

        HerosList01 temp=herohead;//ͷ���λ�ò��ܱ䣬��Ҫ���������������ҵ���ӵ�λ�ã�ע������ĸ����ڵ㣬
        // һֱָ����ǣ�Ҫ���λ�õ�ǰ�棬����Ҫ���2����temp=1

        boolean flag=false;//flsg��־��ӵı���Ƿ���ڣ����ھͲ��벻�ˡ�

        while(true){
            if(temp.next==null){
                break;
            }else if(temp.next.no==hero.no){
                flag=true;
                break;
            }else if(temp.next.no>hero.no){//ֻ���ҵ���Ҫ��ӵ��������λ�ã���֪���������������ˣ���tempֵ������Ҫ��ӵ��������ǰһ���ڵ�ֵ
                break;
            }
            temp=temp.next;//�������һ��ѭ��֮��û���ҵ����ֵ��λ�ã��Ǿ͸��¸���������ֱ���ҵ�����ʵ�λ��
        }

        if(!flag){
            hero.next=temp.next;//��������ӵĽڵ��heroslist���Ե���temp.heroslist���ԡ�
            hero.pre=temp;
            temp.next=hero;//Ȼ����temp.heroslist���Ե���heros��
            if(hero.next!=null){
                hero.next.pre=hero;//Ҫ��ӽڵ����һ����preָ��Ҫ��ӵĽڵ�
            }
        }else{
            System.out.println("����ӱ�ţ�"+hero.no+"�����������");
        }

    }

    //    �ж������ǲ��ǿյģ�
    public boolean isEmpty(){
        return herohead.next==null;
    }

    //    ��ʾ�б��е����е�����
    public void showLinkedList(){
        if(isEmpty()){//����Ϊ�գ�ֱ�ӷ��ؿ�
            System.out.println("����Ϊ��");
            return;
        }

        HerosList01 temp1=herohead.next;         //��Ϊͷ��㲻�ܶ���������Ҫһ�������ڵ�������
        // -------��Ϊ����˴�˵������Ϊ�գ�Ҳ���������heroslist����һ����ֵ������null������ֱ�Ӵ��������ĵ�һ���ڵ㿪ʼ������ע�⣺ͷ��㲻�ǵ�һ���ڵ㣩

        while(true){

            System.out.println(temp1);//������һ���㣬��Ȼ�Ѿ��ж������ǿյ��ˣ��ǵ�һ������ֵһ�����еģ������������
            // Ȼ���жϵ�һ�������heroslist�����ǲ���Ϊ�գ�

            if(temp1.next==null){
                System.out.println("������β��");
                return;
            }

            temp1=temp1.next;
        }


    }

    //        �ṩ�޸Ľڵ���Ϣ�ķ�����
    public void update(HerosList01 heroslist01){
        if(isEmpty()){
            return;
        }

        HerosList01 temp=herohead.next;
        boolean flag=false;

        while(true){
            if(temp==null){//
                break;
            }
            if(temp.no==heroslist01.no){
                flag=true;
                break;
            }
            temp=temp.next;
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

        HerosList01 temp=herohead.next;//ע�⣺ͷ�ڵ��ǲ��ܱ��,����˫��������ŵ���ǣ��ܹ�ֱ��ɾ��������Ҫ��ǰһ���ڵ�

        boolean flag=false;//�жϣ��Ƿ��ҵ���Ӧ�Ľڵ�

        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==num){//tempָ�����ǣ�Ҫɾ���ڵ��ǰһ��ֵ------
                // ��update�ǲ�һ���ģ�update�е�tempһֱָ���Ӧ�ڵ��λ��---------���Ӱ�쵽�ҵ��ж�����
                flag=true;
                break;
            }
            temp=temp.next;//���¸����������˱���һֱָ��Ҫɾ���ڵ���ŵ� ǰһ���ڵ�
        }

        if(flag){
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;//����Ҫɾ���Ľڵ������һ���ڵ㣬���ֿ�ָ���쳣
            }
        }else{
            System.out.println("û�д˽ڵ�"+num+"���޷�ɾ��");
        }
    }
}

class HerosList01{//ÿһ������ڵ�Ӧ�ð�������Ϣ
    public int no;
    public String name;
    public String nickname;
    public HerosList01 next;
    public HerosList01 pre;

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

