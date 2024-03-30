package a2019;

import java.util.*;
import java.io.*;

public class Vlad {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2019/Vlad.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        ArrayList<Student> l = new ArrayList<>();
        while (f.hasNext()) {
            f.next();
            String last = f.next();
            String first = f.next();
            String mid = f.next();
            l.add(new Student(first, last.substring(0, last.length() - 1), mid.substring(0, 1)));
            System.out.println(l);
        }
        Collections.sort(l);
        for (Student s : l) {
            System.out.println(s);
        }

        f.close();
    }

    public class Student implements Comparable<Student> {
        String first, last, mid;

        public Student(String f, String l, String m) {
            first = f;
            last = l;
            mid = m;
        }

        @Override
        public int compareTo(Student o) {
            if (last.equals(o.last)) {
                if (first.equals(o.first)) {
                    return mid.compareTo(o.mid);
                }
                return first.compareTo(o.first);
            }
            return last.compareTo(o.last);
        }

        public String toString() {
            return first + " " + mid + " " + last;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Vlad().run();
    }

}