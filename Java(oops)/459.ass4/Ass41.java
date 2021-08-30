
public class Ass41 {
    public static void main(String[] args) {
        System.out.println("This is for stack implementation: ");
        Stk st = new Stk(3);
        st.insert(4);
        st.insert(5);
        st.insert(6);
        st.insert(6);
        st.display();
        System.out.println("The deleted value from stack is: " + st.delete());

        System.out.println("***************************************************\nThis is for queue implementation: ");
        Que q = new Que(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(6);
        q.display();
        System.out.println("The deleted value from stack is: " + q.delete());
    }
}

abstract class StoreData {
    protected int top, capacity, srt, ed;

    abstract void insert(int val);

    abstract int delete();

    void display() {
        System.out.println("this should be overriden in child class's method");
    }
}

class Stk extends StoreData {
    private int arr[];

    Stk(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    boolean Empty() {
        return top == -1;
    }

    boolean Full() {
        return top == capacity - 1;
    }

    void insert(int val) {
        if (Full()) {
            System.out.println("*Stack is full.");
            return;
        }
        arr[++top] = val;
        System.out.println("Inserted");
    }

    int delete() {
        if (Empty()) {
            System.out.println("*Empty stack.");
            return 0;
        }
        return arr[top--];
    }

    void display() {
        if (Empty()) {
            System.out.println("*Empty stack.");
            return;
        }
        System.out.println("The array of values present: ");
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i] + ", ");
        }
    }
}

class Que extends StoreData {
    private int arr[];

    Que(int size) {
        srt = ed = 0;
        arr = new int[size];
        capacity = size;
    }

    boolean Empty() {
        return srt == ed;
    }

    boolean Full() {
        return ed == capacity;
    }

    void insert(int val) {
        if (Full()) {
            System.out.println("*Queue is full.");
            return;
        }
        arr[ed++] = val;
        System.out.println("Inserted");
    }

    int delete() {
        if (Empty()) {
            System.out.println("*Empty Queue.");
            return -1;
        }
        int del = arr[0];
        for (int i = 0; i < ed - 1; i++) {
            arr[i] = arr[i + 1];
        }
        if (ed < capacity) {
            arr[ed] = -1;
        }
        ed--;
        return del;
    }

    void display() {
        if (Empty()) {
            System.out.println("*Empty Queue.");
            return;
        }
        System.out.println("The array of values present: ");
        for (int i = srt; i < ed; i++) {
            System.out.println(arr[i] + ", ");
        }
    }
}