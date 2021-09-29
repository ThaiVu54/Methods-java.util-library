import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2; //todo tang gap doi kich thuoc mang chua phan tu
        elements = Arrays.copyOf(elements, newSize); //todo sao chep phan tu sang mang moi voi kich thuoc newSize
    }

    public void ensureCapacity (int minCapacity) {
        int newSize = minCapacity; //todo kich thuoc toi thieu cua mang
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) { //todo them phan tu tai vi tri chi dinh
        if (this.size == this.elements.length) {
            this.ensureCapa();
        } else {
            for (int i = index; i < this.size; i++) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
        }
        this.size++;
    }

    public E remove(int index) { //todo Loại bỏ phần tử ở vị trí được chỉ định trong danh sách này.
        E eRemove = (E) elements[index];
        for (int i = index; i < this.size; i++) {
            elements[i] = elements[i + 1];
        }
        this.size--;
        return eRemove;
    }

    public int size() { //todo Trả về số phần tử trong danh sách này.
        return this.size;
    }

    public E clone(){
        return (E) elements;
    }
    public E clone(int index) { //todo Trả về một bản sao cạn của cá thể ArrayList này.
        return (E) elements[index];
    }


    public boolean contains(E o) { //todo Trả về true nếu danh sách này chứa phần tử được chỉ định.
        for (int i = 0; i < this.size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        //todo Trả về chỉ số của lần xuất hiện đầu tiên của phần tử
        // được chỉ định trong danh sách này hoặc -1 nếu danh sách này không chứa phần tử.
        for (int i = 0; i < this.size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index){ //todo Trả về phần tử ở vị trí đã chỉ định trong danh sách này.
        if (index>=size || index<0){
            throw new IndexOutOfBoundsException("Index: "+index+", size "+this.size);
        }
        return (E) elements[index];
    }

    public boolean add(E o){ //todo Thêm phần tử được chỉ định vào cuối danh sách này.
        this.ensureCapa();
        this.size++;
        elements[size -1]=o;
        return true;
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
}
