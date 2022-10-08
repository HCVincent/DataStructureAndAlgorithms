
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// ���в���
		// �ȴ����ڵ�
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

		// ����Ҫ������
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		// ����
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		// ����һ�µ�����ķ�ת����
		System.out.println("ԭ����������~~");
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