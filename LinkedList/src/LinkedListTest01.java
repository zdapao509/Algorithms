/*
��������

    ��������Ĵ����������¼ӽ�����ֱֵ�ӷ��������β��

    �����ˮ�Ӣ���ź�Ϊ����

    ����˳����ӵķ�ʽ��������������ӵ�ʱ�򣬲�������������bug
* */
public class LinkedListTest01 {
    public static void main(String[] args) {
        HerosList hero1=new HerosList(1,"�ν�","��ʱ��");
        HerosList hero2=new HerosList(2,"¬����","������");
        HerosList hero3=new HerosList(3,"����","�Ƕ���");
        HerosList hero4=new HerosList(4,"�ֳ�","����ͷ");
        HerosList hero5=new HerosList(5,"xxx","xxx---");

        HerosLinkedList herosLinkedList=new HerosLinkedList();
        herosLinkedList.showLinkedList();

        herosLinkedList.addLinkedList(hero1);
        herosLinkedList.showLinkedList();

        herosLinkedList.addLinkedList(hero2);
        herosLinkedList.addLinkedList(hero3);
        herosLinkedList.showLinkedList();

        herosLinkedList.addLinkedList(hero5);
        herosLinkedList.addLinkedList(hero4);
        herosLinkedList.showLinkedList();
    }
}
class HerosLinkedList{
//    ��ʼ������ͷ��
    private HerosList herohead=new HerosList();//����ע�⣺����ͷ����˽�л�

//    HerosList temp=herohead;-----�������ⲿ�������Եķ�ʽʵ���������ڵ�

//    �ṩ������ӷ�����
    public void addLinkedList(HerosList hero){
//        temp.heroslist=hero;
//        temp=temp.heroslist;

        HerosList temp=herohead;
        while(true){
            if(temp.heroslist==null){//�ҵ����һ���ڵ��λ�ã������һ�������������������µ�����ֵ
                break;
            }
            temp=temp.heroslist;//���ϸ���������±�ֵ
        }
        temp.heroslist=hero;
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

        HerosList temp1=herohead.heroslist;         //��Ϊͷ��㲻�ܶ���������Ҫһ�������ڵ�������
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

}
class HerosList{
    public int no;
    public String name;
    public String nickname;
    public HerosList heroslist;

    public HerosList(){}

    public HerosList(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

//    ��дtoString�������������HerosList��������õ�ʱ��ֱ�ӵ��ö����toString()������
    public String toString(){
        return "�źţ�"+this.no+"��  ���֣�"+this.name+",  �ºţ�"+this.nickname;
    }
}
