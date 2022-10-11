package queue;
import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TEST
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show):");
			System.out.println("e(exit):");
			System.out.println("a(add):");
			System.out.println("g(get):");
			System.out.println("h(head)");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("type a number");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("the head num is %d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			case 'e':
				scanner.close();
				loop = false;
				break;
			}
		}
	}

}

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		} else {
			rear++;
			arr[rear] = n;
		}
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		} else {
			front++;
			return arr[front];
		}
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列空的，没有数据~~");
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("arr[%d]=%d\n", i, arr[i]);
			}
		}
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		} else {
			return arr[front + 1];
		}
	}
}
