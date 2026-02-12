public class Stack {
    int dizi[];
    int size;
    int indis;

    public Stack(int size) {
        this.size = size;
        dizi=new int[size];
        indis=-1;
    }

    public void push(int data){
        if (isfull()){
            System.out.println("Stack is full");
        }
        else {
            dizi[++indis] = data;
            System.out.println("push(): " + dizi[indis]);
        }
    }

    public int pop() {
        if (isEmpty()){
            System.out.println("Array is Empty!");
            return -1;
        }
        else {
            return dizi[indis--];
        }

    }
    boolean isfull(){
        return (indis==size-1);
    }

    boolean isEmpty(){
        return (indis==-1);
    }
}
