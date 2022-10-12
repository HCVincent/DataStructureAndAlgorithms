package linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		System.out.println("˫������Ĳ���");
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		doubleLinkedList.list();

		HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
		doubleLinkedList.update(newHeroNode);
		System.out.println("�޸ĺ���������");
		doubleLinkedList.list();

		doubleLinkedList.del(3);
		System.out.println("ɾ������������~~");
		doubleLinkedList.list();
	}

}

class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	public void list() {
		if (head.next == null) {
			System.out.println("list is empty");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	public void add(HeroNode2 heroNode) {

		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {//
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("list is empty");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("No.%d not found\n", newHeroNode.no);
		}
	}

	public void del(int no) {

		if (head.next == null) {
			System.out.println("list is empty");
			return;
		}

		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("No.%d doesn't exists\n", no);
		}
	}
}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(int hNo, String hName, String hNickName) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}