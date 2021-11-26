package ua.com.alevel;

public class MathSet<any extends Number> {
    private Number[] setArray;
    private int capacity;
    private final int COMMON_CAPACITY = 10;


    public MathSet() {
        setArray = new Number[COMMON_CAPACITY];
    }


    public MathSet(int capacity) {
        this.capacity = capacity;
        setArray = new Number[capacity];
    }


    public MathSet(Number[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }


    void add(Number n) {
        int index = 0;
        for (int i = index; i < setArray.length; i++) {
            if (setArray[i] == null) {
                index = i;
                break;
            }
        }
        if(index == setArray.length - 1){
            System.arraycopy(setArray,0,setArray,0,setArray.length*3/2+1);
        }
        setArray[index] = n;
    }


}
