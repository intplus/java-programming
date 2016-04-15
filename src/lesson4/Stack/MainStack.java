package lesson4.Stack;

public class MainStack {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push("1");
        st.push("2");
        st.push("3");
        st.push("4");
        st.push("last");
        st.print();
        System.out.println(st.peak());
        System.out.println(st.pop());
        st.print();
        System.out.println(st.pop());
        st.print();
        System.out.println(st.pop());
        st.print();

    }
}
