package datastructuresandalgorithms.may.day0518;

/**
 * @author Administrator
 */
public class HeroNode {
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
