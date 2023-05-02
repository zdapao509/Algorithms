/*
双向链表：
    在单向链表的基础上每个节点又多了一个pre参数，用来存该节点的上一个节点
* */

public class DoubleLinkedListTest01 {
    public static void main(String[] args) {
        HerosLinkedList01 herosLinkedList01=new HerosLinkedList01();
        HerosList01 hero1=new HerosList01(1,"宋江","及时雨");
        HerosList01 hero2=new HerosList01(2,"卢俊义","玉麒麟");
        HerosList01 hero3=new HerosList01(3,"吴用","智多星");
        HerosList01 hero4=new HerosList01(4,"林冲","豹子头");
        HerosList01 hero5=new HerosList01(5,"xxx","xxx---");

        herosLinkedList01.addLinkedListOrder(hero1);//添加节点
        herosLinkedList01.addLinkedListOrder(hero2);
        herosLinkedList01.showLinkedList();

        herosLinkedList01.addLinkedListOrder(hero2);//测试重复添加
        herosLinkedList01.showLinkedList();

        herosLinkedList01.addLinkedListOrder(hero5);//乱序添加
        herosLinkedList01.addLinkedListOrder(hero4);
        herosLinkedList01.addLinkedListOrder(hero3);
        herosLinkedList01.showLinkedList();

        herosLinkedList01.delate(4);//删除节点
        herosLinkedList01.showLinkedList();

        HerosList01 hero5_0=new HerosList01(5,"武松","行者");//修改链表节点信息，按照no 标签
        herosLinkedList01.update(hero5_0);
        herosLinkedList01.showLinkedList();
    }
}

class HerosLinkedList01{//创建双向链表的类，提供链表的增删改查方法
    //    初始化链表头：
    private HerosList01 herohead=new HerosList01();//这里注意：链表头必须私有化

    public HerosList01 getHerohead(){
        return herohead;
    }

    public void setHerohead(HerosList01 herohead){
        this.herohead=herohead;
    }

    //    提供链表添加方法：-----找到链表的最后一个节点然后添加进去，或者按照条件找到节点的位置完成添加
    public void addLinkedListOrder(HerosList01 hero){

        HerosList01 temp=herohead;//头结点位置不能变，需要辅助变量来帮助找到添加的位置，注意这里的辅助节点，
        // 一直指向的是，要添加位置的前面，比如要添加2，那temp=1

        boolean flag=false;//flsg标志添加的编号是否存在，存在就插入不了。

        while(true){
            if(temp.next==null){
                break;
            }else if(temp.next.no==hero.no){
                flag=true;
                break;
            }else if(temp.next.no>hero.no){//只有找到比要添加的数更大的位置，才知道，这个数该添加了，而temp值正好是要添加的这个数的前一个节点值
                break;
            }
            temp=temp.next;//如果经历一次循环之后，没有找到这个值的位置，那就更新辅助变量，直到找到最合适的位置
        }

        if(!flag){
            hero.next=temp.next;//先让新添加的节点的heroslist属性等于temp.heroslist属性。
            hero.pre=temp;
            temp.next=hero;//然后让temp.heroslist属性等于heros；
            if(hero.next!=null){
                hero.next.pre=hero;//要添加节点的下一个的pre指向要添加的节点
            }
        }else{
            System.out.println("已添加编号："+hero.no+"，无需再添加");
        }

    }

    //    判断链表是不是空的：
    public boolean isEmpty(){
        return herohead.next==null;
    }

    //    显示列表中的所有的数：
    public void showLinkedList(){
        if(isEmpty()){//链表为空，直接返回空
            System.out.println("链表为空");
            return;
        }

        HerosList01 temp1=herohead.next;         //因为头结点不能动，所以需要一个辅助节点来遍历
        // -------因为到达此处说明链表不为空，也就是链表的heroslist属性一定有值，不是null，所以直接从这个链表的第一个节点开始遍历（注意：头结点不是第一个节点）

        while(true){

            System.out.println(temp1);//这里有一个点，既然已经判断链表不是空的了，那第一个链表值一定是有的，所以先输出，
            // 然后判断第一个链表的heroslist属性是不是为空，

            if(temp1.next==null){
                System.out.println("链表到达尾部");
                return;
            }

            temp1=temp1.next;
        }


    }

    //        提供修改节点信息的方法：
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
            System.out.println("未找对应序号");
        }
    }

    //    提供删除节点的信息：
    public void delate(int num){// 这里的参数应该是： 一个整数代表的是删除链表中对应序号的数
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }

        HerosList01 temp=herohead.next;//注意：头节点是不能变的,并且双向链表的优点就是，能够直接删除，不需要找前一个节点

        boolean flag=false;//判断：是否找到对应的节点

        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==num){//temp指定的是：要删除节点的前一个值------
                // 和update是不一样的，update中的temp一直指向对应节点的位置---------这会影响到我的判断条件
                flag=true;
                break;
            }
            temp=temp.next;//更新辅助变量，此变量一直指向要删除节点序号的 前一个节点
        }

        if(flag){
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;//避免要删除的节点是最后一个节点，出现空指针异常
            }
        }else{
            System.out.println("没有此节点"+num+"，无法删除");
        }
    }
}

class HerosList01{//每一个链表节点应该包括的信息
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

    //    重写toString（）方法，输出HerosList对象的引用的时候，直接调用对象的toString()方法：
    public String toString(){
        return "排号："+this.no+"，  名字："+this.name+",  绰号："+this.nickname;
    }
}

