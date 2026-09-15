class MyCircularDeque {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.buffer = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        head = (head - 1 + capacity) % capacity;
        buffer[head] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return buffer[head];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return buffer[(tail - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}