import java.util.Scanner;

class MyCircularDeque {

    int front;
    int rear;
    int k;
    int cap;
    int[] queue;

    public MyCircularDeque(int k) {
        this.k = k;
        queue = new int[k];
        front = 0;
        rear = -1;
        cap = 0;
    }

    public boolean insertFront(int value) {

        if (cap == k) {
            return false;
        }

        if (cap == 0) {
            front = rear = 0;
        } else {
            front = (front - 1 + k) % k;
        }

        queue[front] = value;
        cap++;

        return true;
    }

    public boolean insertLast(int value) {

        if (cap == k) {
            return false;
        }

        if (cap == 0) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % k;
        }

        queue[rear] = value;
        cap++;

        return true;
    }

    public boolean deleteFront() {

        if (cap == 0) {
            return false;
        }

        if (cap == 1) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % k;
        }

        cap--;
        return true;
    }

    public boolean deleteLast() {

        if (cap == 0) {
            return false;
        }

        if (cap == 1) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + k) % k;
        }

        cap--;
        return true;
    }

    public int getFront() {

        if (cap == 0) {
            return -1;
        }

        return queue[front];
    }

    public int getRear() {

        if (cap == 0) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {
        return cap == 0;
    }

    public boolean isFull() {
        return cap == k;
    }

    public void display() {

        if (cap == 0) {
            System.out.println("Deque is Empty");
            return;
        }

        System.out.print("Deque: ");

        int i = front;

        for (int count = 0; count < cap; count++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % k;
        }

        System.out.println();
    }
}

public class CircularDeque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Deque Size: ");
        int size = sc.nextInt();

        MyCircularDeque dq = new MyCircularDeque(size);

        dq.insertLast(10);
        dq.insertLast(20);
        dq.insertFront(5);
        dq.insertFront(2);

        dq.display();

        dq.deleteFront();
        dq.display();

        dq.deleteLast();
        dq.display();

        System.out.println("Front = " + dq.getFront());
        System.out.println("Rear = " + dq.getRear());

        System.out.println("Is Empty: " + dq.isEmpty());
        System.out.println("Is Full: " + dq.isFull());

        sc.close();
    }
}