// LeetCode 284 - Peeking Iterator
// Java focus: implements Iterator<Integer>, method overriding, abstraction
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

class LC284_PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer nextValue;
    private boolean hasNextValue;

    public LC284_PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        advance();
    }

    private void advance() {
        if (iterator.hasNext()) {
            nextValue = iterator.next();
            hasNextValue = true;
        } else {
            nextValue = null;
            hasNextValue = false;
        }
    }

    public Integer peek() {
        if (!hasNextValue) throw new NoSuchElementException();
        return nextValue;
    }

    @Override
    public Integer next() {
        if (!hasNextValue) throw new NoSuchElementException();
        Integer result = nextValue;
        advance();
        return result;
    }

    @Override
    public boolean hasNext() {
        return hasNextValue;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3);
        LC284_PeekingIterator iterator =
                new LC284_PeekingIterator(values.iterator());
        System.out.println(iterator.peek());   // 1
        System.out.println(iterator.next());   // 1
        System.out.println(iterator.hasNext()); // true
    }
}
