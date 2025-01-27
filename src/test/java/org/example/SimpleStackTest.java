package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals(0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must contain 1 item");
        assertSame(item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must contain 2 items");
        assertSame(item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test nominal for the peek of items")
    public void testPeekOk() throws EmptyStackException {
        // Given an empty stack and items
        Stack stack = new SimpleStack();
        Item item1 = new SimpleItem();
        Item item2 = new SimpleItem();

        // When an item is pushed
        stack.push(item1);

        // Then...
        assertEquals(item1, stack.peek(), "The top of the stack contains the first item");

        // When another item is pushed
        stack.push(item2);

        // Then...
        assertEquals(item2, stack.peek(), "The top of the stack contains the second item");
    }

    @Test
    @DisplayName("Test limit when trying to peek from an empty stack")
    public void testPeekNokOnEmptyStack() {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // Then an exception is thrown When we try to peek
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test nominal when we 'pop' a valid stack")
    public void testPopOk() throws EmptyStackException {
        // Given a stack
        Stack stack = new SimpleStack();
        // with elements
        Item item1 = new SimpleItem();
        Item item2 = new SimpleItem();
        stack.push(item1);
        stack.push(item2);

        // Then no exception is thrown When we "pop" the stack
        // assertDoesNotThrow(stack::pop);
        // OU plutôt :

        // When we "pop" the stack
        Item pop1 = stack.pop();

        // Then...
        assertEquals(item2, pop1, "The right element is returned when 'pop'");
        assertEquals(1, stack.getSize(), "The element must have been removed");

        // When we "pop" a second time
        Item pop2 = stack.pop();

        // Then...
        assertEquals(item1, pop2, "The second pop element is well returned");
        assertEquals(0, stack.getSize(), "The second element must have been removed");
    }
}
