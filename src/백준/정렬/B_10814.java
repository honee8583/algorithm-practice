package 백준.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int idx;
    int age;
    String name;

    public Person(int idx, int age, String name) {
        this.idx = idx;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age == o.age) {
            return this.idx - o.idx;
        } else {
            return -1;
        }
    }
}

public class B_10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(i, age, name);
        }

        Arrays.sort(people);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].age + " " + people[i].name);
        }
    }
}
