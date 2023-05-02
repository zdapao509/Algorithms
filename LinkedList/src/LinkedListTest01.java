/*
单向链表：

    单向链表的创建，并将新加进来的值直接放在链表的尾部

    以添加水浒英雄排号为例：

    按照顺序添加的方式，导致我链表添加的时候，不安排名，出现bug
* */
public class LinkedListTest01 {
    public static void main(String[] args) {
        HerosList hero1=new HerosList(1,"宋江","及时雨");
        HerosList hero2=new HerosList(2,"卢俊义","玉麒麟");
        HerosList hero3=new HerosList(3,"吴用","智多星");
        HerosList hero4=new HerosList(4,"林冲","豹子头");
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
//    初始化链表头：
    private HerosList herohead=new HerosList();//这里注意：链表头必须私有化

//    HerosList temp=herohead;-----不采用外部定义属性的方式实现添加链表节点

//    提供链表添加方法：
    public void addLinkedList(HerosList hero){
//        temp.heroslist=hero;
//        temp=temp.heroslist;

        HerosList temp=herohead;
        while(true){
            if(temp.heroslist==null){//找到最后一个节点的位置，在最后一个链表的属性里面添加新的引用值
                break;
            }
            temp=temp.heroslist;//不断更新链表的下标值
        }
        temp.heroslist=hero;
    }

//    判断链表是不是空的：
    public boolean isEmpty(){
        return herohead.heroslist==null;
    }

//    显示列表中的所有的数：
    public void showLinkedList(){
        if(isEmpty()){//链表为空，直接返回空
            System.out.println("链表为空");
            return;
        }

        HerosList temp1=herohead.heroslist;         //因为头结点不能动，所以需要一个辅助节点来遍历
        // -------因为到达此处说明链表不为空，也就是链表的heroslist属性一定有值，不是null，所以直接从这个链表的第一个节点开始遍历（注意：头结点不是第一个节点）

        while(true){

            System.out.println(temp1);//这里有一个点，既然已经判断链表不是空的了，那第一个链表值一定是有的，所以先输出，
            // 然后判断第一个链表的heroslist属性是不是为空，

            if(temp1.heroslist==null){
                System.out.println("链表到达尾部");
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

//    重写toString（）方法，输出HerosList对象的引用的时候，直接调用对象的toString()方法：
    public String toString(){
        return "排号："+this.no+"，  名字："+this.name+",  绰号："+this.nickname;
    }
}
