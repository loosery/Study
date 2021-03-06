package datastructuresandalgorithms.may.day0507;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
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
        singleLinkedList.printNode();
        HeroNode heroNode5=new  HeroNode("武松","行者",4);
        singleLinkedList.deleteNode(3);
        singleLinkedList.printNode();

    }

static class SingleLinkedList{
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

}





static class HeroNode{
        public String name;
        public String nickname;
        public int no;
        public HeroNode next;
        HeroNode(String name,String nickname,int no){
            this.name=name;
            this.nickname=nickname;
            this.no=no;
        }
        @Override
    public String toString(){
            return "姓名："+name+",外号："+nickname+",排名："+no;
        }
}
}
