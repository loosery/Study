package datastructuresandalgorithms.may.day0507;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode("宋江","及时雨",1);
        HeroNode heroNode2=new HeroNode("卢俊义","玉麒麟",2);
        HeroNode heroNode3=new HeroNode("林冲","豹子头",3);
        HeroNode heroNode4=new HeroNode("吴用","智多星",4);
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addNode(heroNode1);
        singleLinkedList.addNode(heroNode2);
        singleLinkedList.addNode(heroNode3);
        singleLinkedList.addNode(heroNode4);
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
                System.out.println("链表未空");
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
