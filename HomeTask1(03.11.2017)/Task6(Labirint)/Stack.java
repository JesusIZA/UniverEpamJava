package epam.hw1.task6labirint;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jesus Raichuk
 */
public class Stack {
    private List<Coordinates2D> stack;

    public Stack(){
        stack = new LinkedList<Coordinates2D>();
    }

    public void add(Coordinates2D coordinates2D) {
        stack.add(coordinates2D);
    }

    public void del() {
        stack.remove(stack.size() - 1);
    }

    public Coordinates2D get(){
        return (Coordinates2D)stack.get(stack.size() - 1);
    }

    public  void print() {
        stack.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

}
