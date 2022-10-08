
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// 进行测试
		// 先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

		// 创建要给链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		// 加入
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		// 测试一下单链表的反转功能
		System.out.println("原来链表的情况~~");
		singleLinkedList.list();

	}

}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, "", "");

	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	public void list() {
		if (head.next == null) {
			System.out.println("list is empty");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}

	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	public HeroNode(int hNo, String hName, String hNickName) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname  + "]";
	}

}