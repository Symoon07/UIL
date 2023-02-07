package practice;

import java.util.*;
import java.io.*;

public class Chain {
    public ArrayList<String> getNext(ArrayList<String> words, String word) {
        ArrayList<String> out = new ArrayList<>();
        for (String s : words) {
            int num = 0;
            for (int i = 0; i < word.length(); i++) {
                if (s.charAt(i) == word.charAt(i)) {
                    num++;
                }
            }
            if (num == word.length()-1) {
                out.add(s);
            }
        }
        return out;
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice/Chain.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        int cases = f.nextInt();
        ArrayList<String> words = new ArrayList<>();
        while (n-- > 0) {
            words.add(f.next());
        }
        while (cases-- > 0) {
            HashMap<String, ArrayList<String>> adjList = new HashMap<>();
            for (String s : words) {
                adjList.put(s, getNext(words, s));
            }
            String start = f.next();
            String end = f.next();
            HashSet<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.add(start);
            q.add("");
            while (!q.isEmpty()) {
                String cur = q.poll();
                String path = q.poll();
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);
                if (cur.equals(end)) {
                    System.out.println(path + end);
                    break;
                }
                for (String s : adjList.get(cur)) {
                    q.add(s);
                    q.add(path + cur + "\n");
                }
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Chain().run();
    }

}