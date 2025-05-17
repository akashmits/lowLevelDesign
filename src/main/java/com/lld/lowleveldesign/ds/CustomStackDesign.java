package com.lld.lowleveldesign.ds;

public class CustomStackDesign<T> {

    T[] data;
    int current;
    int totalCapacity;

    public CustomStackDesign(){
        data = (T[]) new Object[99999999];
        this.current=-1;
        this.totalCapacity=Integer.MAX_VALUE;
    }

    public T peek() throws Exception {
        if(current==-1){
            System.out.println("Stack UnderFlow");
            throw new Exception("Stack underflow, please try again after sometime");
        }
        return data[current];
    }
    public void push(T t) throws Exception {
        if(current==totalCapacity){
            System.out.println("Stack Overflow");
            throw new Exception("Stack OverFlow, please try again after sometime");
        }

        data[++current]=t;
    }

    public T pop() throws Exception {
        if(current==-1){
            System.out.println("Stack UnderFlow");
            throw new Exception("Stack underflow, please try again after sometime");
        }
        return data[current--];
    }

    public int size(){
        return current+1;
    }

    public boolean isEmpty(){
        return current==-1;
    }

    public static void main(String [] arg) throws Exception {
        CustomStackDesign<Integer> stack= new CustomStackDesign<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());



    }

}
