package CustomUtil.StringBuilder;

public interface CustomStringBuilderInterface {
    void append(char character);
    void append(String string);
    void insert(int index, String string);
    void insert(int index, char character);
    void delete(int start, int end);
    void deleteCharAt(int index);
    void replace(int start, int end, String string);
    char charAt(int index);
    int length();
    void reverse();
    boolean isEmpty();
    void clear();
}
