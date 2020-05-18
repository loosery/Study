package datastructuresandalgorithms.may.day0518;

public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode("宋江","及时雨",1);
        HeroNode heroNode2=new HeroNode("卢俊义","玉麒麟",2);
        HeroNode heroNode3=new HeroNode("林冲","豹子头",3);
        HeroNode heroNode4=new HeroNode("吴用","智多星",4);
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addNodeByNo(heroNode1);
        singleLinkedList.addNodeByNo(heroNode4);
        singleLinkedList.addNodeByNo(heroNode3);
        singleLinkedList.addNodeByNo(heroNode2);
        SingleLinkedList singleLinkedList1=singleLinkedList.revrseList();
        singleLinkedList1.printNode();

    }




    //设置头节点，头节点不存放任何数据
    private HeroNode head=new HeroNode("","",0);
    //增加链表节点
    public void addNode(HeroNode node){
        //头节点不能动，使用临时节点来辅助遍历
        HeroNode temp=head;
        while(true){
            //找到尾节点
            if ( temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }
    //遍历输出节点信息
    public void printNode(){
        //判断节点是否未空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        while (true){
            if (temp.next==null){
                System.out.println(temp);
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //向链表增加节点
    public void addNodeByNo(HeroNode heroNode){
        boolean flag=false;
        HeroNode temp=head;
        while (true){
            if (temp.next==null){
                break;
            }else if (temp.next.no>heroNode.no){
                break;
            }else if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }else{
                temp=temp.next;
            }
        }
        if (flag){
            System.out.println("节点插入失败，链表中已存在该节点");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }
    //根据序号修改链表节点
    public void modifyByNo(HeroNode node){
        //1.判断链表是否未空
        if (head.next==null){
            System.out.println("链表为空，无法修改");
            return;
        }
        //2.创建临时节点
        HeroNode temp=head;
        boolean flag=true;
        while (flag){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==node.no) {
                flag = false;
                break;
            }
            temp=temp.next;
        }
        if (!flag){
            temp.next.nickname=node.nickname;
            temp.next.name=node.name;
        }else {
            System.out.println("无法修改该节点，因为不存在");
        }
    }
    //根据节点序号删除节点
    public void deleteNode(int no){
        if (head.next==null){
            System.out.println("链表为空，删除失败");
            return;
        }
        boolean flag=true;
        HeroNode temp=head;
        while (flag){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==no){
                flag=false;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("删除失败，该节点不存在");
        }else{
            HeroNode node=temp.next.next;
            temp.next=node;
            System.out.println("删除成功");
        }



    }
    //面试题，输出链表有效节点个数
    public  int  getVaildNode(){

        if (head.next==null){
            return 0;
        }
        int size=1;
        boolean flag=true;
        HeroNode temp=head.next;
        while(flag){
            if (temp.next==null){
                flag=false;
            }else{
                temp=temp.next;
                size++;
            }
        }
        System.out.println(size);
        return size;
    }
    //输出单链表倒数第k个节点
    public HeroNode getLastKNode(int k){
        int size=getVaildNode();
        if (k>size){
            throw new RuntimeException("对不起，不存在第"+k+"个节点");
        }
        int index=size-k;
        HeroNode temp=head.next;
        while (true){
            if (index==0){
                return temp;
            }else{
                index--;
                temp=temp.next;
            }
        }
    }
    //反转链表
    public SingleLinkedList revrseList(){
        if (head.next==null || head.next.next==null){
            return null;
        }
        HeroNode curr;
        HeroNode reverseNode=new HeroNode("","",0);
        reverseNode.next=null;
        HeroNode temp=head.next;
        while(true) {
            if (temp== null) {
                break;
            }else {
                HeroNode test=temp.next;
                temp.next=reverseNode.next;
                reverseNode.next=temp;
                temp=test;
            }
        }

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addNode(reverseNode);
        return singleLinkedList1;

    }

}

