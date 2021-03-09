import java.util.*;

public class Lesson012 {

    class A {
        private int a;
        private int b;

        public int getA(List<? extends A> produces, List<? super A> consumes) {
            Object value = produces.get(0);
            consumes.add(new B());
            List<A> list = new ArrayList<>();
            list.add(new B());
            List<?> l =  new ArrayList<>();
            l.add(new Object());
            return 0;
        }


    }

    class B extends A {

    }

    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == 100);

        Integer i12 = 200;
        Integer i22 = 200;
        System.out.println(i12 == 200)
        Stack<Integer> stack;

        Comparator<A> comparator = Comparator.comparing((A x) -> x.getA());

    }

    public Lesson012() {
        new SortedMap()
        System.out.println("Hello, world");
    }
}