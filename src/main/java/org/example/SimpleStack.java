package org.example;

import java.util.ArrayList;

/**
 * Stack of {@link Item}s.
 *
 * @author Antoine Mcx
 */
public class SimpleStack implements Stack {

    /** Items of the stack */
    private ArrayList<Item> items;

    /**
     * Create a new empty stack.
     */
    public SimpleStack() {
        this.items = new ArrayList<>();
    }
    /**
     * Tests if this stack is empty
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /** @return the number of items in this stack */
    @Override
    public int getSize() {
        return items.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        items.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return items.getLast();
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return items.removeLast();
    }
}
