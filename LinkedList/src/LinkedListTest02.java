import java.util.Stack;

/*
为了让添加的值按顺序添加，即使乱序添加，添加后的值也是按正常顺序输出：

对链表中节点的信息进行修改：根据no 来修改，即 no 是不能变的

对链表信息进行删除

经过测试发现：

    凡是操作链表里面的数，都需要设定辅助变量，
    这个变量初始的位置可能是头结点的位置（当需要添加、删除某节点时，要找的是要操作节点的前一个节点。--链表长度变化，找前面一个节点，temp代表要操作点的前一个点）
    也可能是头结点的下一个节点（当要遍历节点或者修改某个节点时，要找的是要操作的节点---链表长度不变，找对应的节点，temp就代表要操作的点）

* */
public class LinkedListTest02 {
    public static void main(String[] args) {
        HerosList01 hero1=new HerosList01(1,"宋江","及时雨");
        HerosList01 hero2=new HerosList01(2,"卢俊义","玉麒麟");
        HerosList01 hero3=new HerosList01(3,"吴用","智多星");
        HerosList01 hero4=new HerosList01(4,"林冲","豹子头");
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
        herosLinkedList.showLinkedList();//重复添加

        herosLinkedList.addLinkedListOrder(hero5);
        herosLinkedList.addLinkedListOrder(hero4);
        herosLinkedList.showLinkedList();//乱序添加

        HerosList01 hero5_0=new HerosList01(5,"武松","行者");//修改链表节点信息，按照no 标签
        herosLinkedList.update(hero5_0);
        herosLinkedList.showLinkedList();

/*        herosLinkedList.delate(1);//删除节点
        herosLinkedList.showLinkedList();
        herosLinkedList.delate(5);//删除节点
        herosLinkedList.showLinkedList();

        System.out.println("该链表的有效节点数量为："+getLength(herosLinkedList.getHerohead()));

        herosLinkedList.delate(2);//删除节点
        herosLinkedList.showLinkedList();
        try{
            System.out.println("倒数第k个的节点为："+getKnode(herosLinkedList.getHerohead(),5));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("******************************************");
        herosLinkedList.setHerohead(turnAround(herosLinkedList.getHerohead()));//反转链表
        herosLinkedList.showLinkedList();*/

        System.out.println("******************************************");
        reversePrint(herosLinkedList.getHerohead());//从尾到头输出

    }

//    提供一返回有效节点数量的方法，如果有头结点，不计入数量
    public static int getLength(HerosList01 head){//从链表头结点开始遍历
        if(head.heroslist==null){//头结点下一个节点如果为null，代表有效节点数为0
            return 0;
        }
        HerosList01 temp=head.heroslist;//设置辅助变量，从头结点下一个节点开始遍历，也就是从第一个有效节点开始遍历
        int count =0;//计数
        while(temp!=null){//当前辅助变量中存的数不是空的，代表节点存在，有效节点数加一
            count++;
            temp=temp.heroslist;//平移辅助变量，将辅助变量中存的内存地址向后移一位。
        }
        return count;
    }

//    查找单链表中的倒数第K个节点----新浪面试题：
//    思路：
//    1.编写一个方法，接收head节点，同时接收一个k值
//    2.k表示倒数第k个值
//    3.先把链表遍历一遍，得到链表的总长度，getLength
//    4.得到量表长度之后，从链表的第一个数开始遍历，遍历 （链表长度-k） 个，就可以得到
//    5.如果得到了，则返回节点，否则返回null
//    ----------------------------------------------表明链表实际上是没有长度的，需要遍历才能知道链表的具体个数

    public static HerosList01 getKnode(HerosList01 head,int k){

        if(head.heroslist==null){//链表为空，那就没有找到
            return null;
        }

        int realLength=getLength(head);//先计算链表的长度

        if(k<=0||k>realLength){//校验输入值
            throw new RuntimeException("输入k值超出范围");
        }

        HerosList01 temp=head.heroslist;//遍历的时候，temp直接指到第一个节点

        for (int i = 0; i < realLength-k; i++) {
            temp=temp.heroslist;
        }
        return temp;
    }

//    反转链表，双指针法：一个指向原始头部，一个指向原始头部的下一个节点。还要有一个最新头部，一直指向最新的头部
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

        result.heroslist=res;//注意，头结点不存数据的时候，就一定要把头单独考虑，
        // 具体就是，我反转之后，新实例化一个空的头，不存数据，只存我反转之后的头部
        return result;
    }

//    从尾到头输出链表
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
class HerosLinkedList01{//创建链表的类
    //    初始化链表头：
    private HerosList01 herohead=new HerosList01();//这里注意：链表头必须私有化

    public HerosList01 getHerohead(){
        return herohead;
    }

    public void setHerohead(HerosList01 herohead){
        this.herohead=herohead;
    }

    //    提供链表添加方法：
    public void addLinkedListOrder(HerosList01 hero){

        HerosList01 temp=herohead;//头结点位置不能变，需要辅助变量来帮助找到添加的位置，注意这里的辅助节点，
                                    // 一直指向的是，要添加位置的前面，比如要添加2，那temp=1

        boolean flag=false;//flsg标志添加的编号是否存在，存在就插入不了。

        while(true){
            if(temp.heroslist==null){
                break;
            }else if(temp.heroslist.no==hero.no){
                flag=true;
                break;
            }else if(temp.heroslist.no>hero.no){//只有找到比要添加的数更大的位置，才知道，这个数该添加了，而temp值正好是要添加的这个数的前一个节点值
                break;
            }
            temp=temp.heroslist;//如果经历一次循环之后，没有找到这个值的位置，那就更新辅助变量，直到找到最合适的位置
        }

        if(!flag){
            hero.heroslist=temp.heroslist;//先让新添加的节点的heroslist属性等于temp.heroslist属性。
            temp.heroslist=hero;//然后让temp.heroslist属性等于heros；
        }else{
            System.out.println("已添加编号："+hero.no+"，无需再添加");
        }

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

        HerosList01 temp1=herohead.heroslist;         //因为头结点不能动，所以需要一个辅助节点来遍历
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

    //        提供修改节点信息的方法：
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
            System.out.println("未找对应序号");
        }
    }

//    提供删除节点的信息：
    public void delate(int num){// 这里的参数应该是： 一个整数代表的是删除链表中对应序号的数
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }

        HerosList01 temp=herohead;//注意：头节点是不能变的-------由于下面我的判断条件是指向下一个值，
        // 所以，这里的开始起点设置为头结点而不是头结点的下一个节点，避免漏掉第一个节点-------这和update是不一样的

        boolean flag=false;//判断：是否找到对应的节点

        while(true){
            if(temp.heroslist==null){
                break;
            }
            if(temp.heroslist.no==num){//temp指定的是：要删除节点的前一个值------
                                                // 和update是不一样的，update中的temp一直指向对应节点的位置---------这会影响到我的判断条件
                flag=true;
                break;
            }
            temp=temp.heroslist;//更新辅助变量，此变量一直指向要删除节点序号的 前一个节点
        }

        if(flag){
            temp.heroslist=temp.heroslist.heroslist;//这里的删除就是将要删除节点的 前面一个节点 中 存 后面一个节点的属性 的值进行修改：
            // 改成要删除节点的后面一个节点，也就是 temp.heroslist.heroslist------temp.heroslist 代表要删除节
            // temp.heroslist.heroslist代表要删除节点的下一个节点
        }else{
            System.out.println("没有此节点"+num+"，无法删除");
        }
    }
}
class HerosList01{//每一个链表节点应该包括的信息
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

    //    重写toString（）方法，输出HerosList对象的引用的时候，直接调用对象的toString()方法：
    public String toString(){
        return "排号："+this.no+"，  名字："+this.name+",  绰号："+this.nickname;
    }
}
