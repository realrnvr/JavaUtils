package CustomUtil;

public class CustomArrayList<T> {
    private Object[] data;
    private int size;
    public CustomArrayList() {
        data = new Object[10];
        size = 0;
    }

    private void assignNewDataIfFull() {
        if(size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for(int i = 0; i < data.length; ++i) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[ ");

        for(int i = 0; i < size - 1; ++i) {
            res.append(data[i]).append(", ");
        }
        res.append(data[size - 1]).append(" ]");

        return res.toString();
    }

    private void isIndexInBound(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }

    public void add(T element) {
        assignNewDataIfFull();
        data[size++] = element;
    }

    public void add(int index, T element) {
        isIndexInBound(index);
        assignNewDataIfFull();

        for(int i = size; i > index; --i) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }


    @SuppressWarnings("unchecked")
    public T get(int index) {
       isIndexInBound(index);
       return (T) data[index];
    }

    @SuppressWarnings("unchecked")
    public void remove(int index) {
        isIndexInBound(index);

        for(int i = index; i < size - 1; ++i) {

            T temp = (T)(data[i]);
            data[i] = data[i+1];
            data[i+1] = temp;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        for(int i = 0; i < size; ++i) {
            if(data[i] == element) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(T element) {
        for(int i = 0; i < size; ++i) {
            if(data[i] == element) {
                return i;
            }
        }

        return -1;
    }

    public void clear() {
        for(int i = 0; i < size; ++i) {
            data[i] = null;
        }

        size = 0;
    }
}
