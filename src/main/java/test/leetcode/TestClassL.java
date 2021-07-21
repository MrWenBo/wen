package test.leetcode;

public class TestClassL {
    public static void main(String[] args) {
        TestClassL app = new TestClassL();
        int result = app.operation(2 * 2, x -> x * x);
        System.out.println(result);
        /***********/
    }

    public int operation(int i, Functional f) {
        return f.makeSomeValue(i);
    }

}
