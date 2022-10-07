import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// test
		// SIZE = 3
		CircleArray queue = new CircleArray(4);
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
					System.out.printf("the num is %d\n", res);
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

class CircleArray {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		} else {
			arr[rear] = n;
			rear = (rear + 1) % maxSize;
		}
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("is empty");
		} else {
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列空的，没有数据~~");
			return;
		} else {
			for (int i = front; i < front + size(); i++) {
				System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
			}
		}
	}

	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		} else {
			return arr[front];
		}
	}
}