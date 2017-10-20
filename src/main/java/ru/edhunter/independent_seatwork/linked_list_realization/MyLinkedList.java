package ru.edhunter.independent_seatwork.linked_list_realization;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class MyLinkedList<T> implements List<T> {
    private Node<T> head = new Node<>(null);
    private Node<T> end = new Node<>(null);
    private int size;
    private int modCount;

    MyLinkedList() {
        head.next = end;
        end.previous = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int count = 0;
        Node<T> node = head.next;
        while (count < size) {
            array[count++] = node.value;
            node = node.next;
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    //пришлось помучиться с этим методом, примерно понял как сделать, но не понял как это реализовано в оригинальном ЛинкедЛисте
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        int i = 0;
        for (Node<T> x = head.next; x != end; x = x.next)
            a[i++] = (T1) x.value;

        if (a.length > size) {
            a[size] = null;
        }

        T1[] newA = (T1[]) Array.newInstance(a.getClass().getComponentType(), a.length);
        System.arraycopy(a, 0, newA, 0, a.length);

        return newA;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.previous = end.previous;
        newNode.next = end;
        end.previous.next = newNode;
        end.previous = newNode;
        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> node = head.next;
        modCount++;
        if (o == null) {
            if (node.value == null) {
                node.next.previous = node.previous;
                node.previous.next = node.next;
                size--;
                return true;
            }
        } else {
            if (node.value.equals(o)) {
                node.next.previous = node.previous;
                node.previous.next = node.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index <= size && index >= 0) {
            Node<T> from;
            Node<T> to;
            if (c.size() == 0) return false;
            if (index == size) {
                from = end.previous;
                to = end;
            } else {
                int count = 0;
                from = head;
                to = from.next;
                while (count != index) {
                    from = to;
                    to = to.next;
                    count++;
                }
            }
            for (T t : c) {
                Node<T> newNode = new Node(t);
                from.next = newNode;
                newNode.previous = from;
                size++;
                from = newNode;
            }
            from.next = to;
            to.previous = from;
            modCount++;
        } else throw new IndexOutOfBoundsException();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Node check = head.next;
        int count = 0;
        boolean result = false;
        while (count < size) {
            if (c.contains(check.value)) {
                check.previous.next = check.next;
                check.next.previous = check.previous;
                check.value = null;
                check = check.next;
                size--;
                result = true;
            } else {
                count++;
            }
            modCount++;
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node check = head.next;
        int count = 0;
        boolean result = false;
        while (count < size) {
            if (!c.contains(check.value)) {
                check.previous.next = check.next;
                check.next.previous = check.previous;
                check.value = null;
                size--;
                result = true;
            } else {
                count++;
            }
            check = check.next;
            modCount++;
        }
        return result;
    }

    @Override
    public void clear() {
//      Вариант с очисткой всех ссылок
//        Node<T> node = head.next;
//        while (!node.equals(end)){
//            node.previous.next = null;
//            node.previous = null;
//            node.value = null;
//            node = node.next;
//
//        }
        head.next = end;
        end.previous = head;
        size = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        if (index < size && index >= 0) {
            int count = 0;
            Node<T> node = head.next;
            while (count != index) {
                count++;
                node = node.next;
            }
            return node.value;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public T set(int index, T element) {
        if (index < size && index >= 0) {
            Node<T> node = head.next;
            int count = 0;
            while (count != index) {
                node = node.next;
                count++;
            }
            T t = node.value;
            node.value = element;
            modCount++;
            return t;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, T element) {
        if (index < size && index >= 0) {
            Node<T> node = new Node<>(element);
            Node<T> previous = head;
            int count = 0;
            while (count != index) {
                previous = previous.next;
                count++;
            }
            node.previous = previous;
            node.next = previous.next;
            previous.next = node;
            node.next.previous = node;
            size++;
            modCount++;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public T remove(int index) {
        if (index < size && index >= 0) {
            Node<T> node = head.next;
            int count = 0;
            while (count != index) {
                node = node.next;
                count++;
            }
            T t = node.value;
            node.next.previous = node.previous;
            node.previous.next = node.next;
            modCount++;
            return t;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<T> node = head.next;
        while (node != end) {
            if (o == null) {
                if (node.value == null) {
                    return index;
                }
                index++;
                node = node.next;
            } else {
                if (node.value.equals(o)) {
                    return index;
                }
                index++;
                node = node.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        Node<T> node = end.previous;
        while (node != head) {
            if (o == null) {
                if (node.value == null) {
                    return index;
                }
                index--;
                node = node.previous;
            } else {
                if (node.value.equals(o)) {
                    return index;
                }
                index--;
                node = node.previous;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index >= size() || index < 0) throw new IndexOutOfBoundsException("" + index);
        return new MyListIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new MyLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(this.get(i));
        }
        return subList;
    }

    public void reverse() {
        Node<T> tmpHead = head;
        head = end;
        Node<T> current = head;
        while (current != null) {
            Node<T> tmp = current.next;
            current.next = current.previous;
            current.previous = tmp;
            current = current.next;
        }
        end = tmpHead;
    }


    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T value;

        private Node(T value) {
            this.value = value;
        }
    }

    private class MyListIterator implements ListIterator<T> {
        private int index;
        private Node<T> lastNode;
        private Node<T> nextNode;
        private int iteratorModCount = modCount;

        MyListIterator() {
            if (size() > 0) {
                nextNode = head.next;
            } else {
                nextNode = null;
            }
        }

        MyListIterator(int index) {
            if (index < size && index >= 0) {
                int count = 0;
                nextNode = head.next;
                while (count != index) {
                    nextNode = nextNode.next;
                    count++;
                    this.index++;
                }
            } else {
                nextNode = null;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            checkForOtherModif();
            if (!hasNext()) throw new NoSuchElementException();
            lastNode = nextNode;
            nextNode = lastNode.next;
            index++;
            return lastNode.value;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            checkForOtherModif();
            if (!hasPrevious()) throw new NoSuchElementException();
            nextNode = lastNode;
            lastNode = nextNode.previous;
            index--;
            return nextNode.value;
        }

        @Override
        public int nextIndex() {
            if (hasNext()) return index;
            return size();
        }

        @Override
        public int previousIndex() {
            if (hasPrevious()) return index - 1;
            return -1;
        }

        @Override
        public void remove() {
            checkForOtherModif();
            if (lastNode == null) {
                throw new IllegalStateException();
            }
            lastNode.next.previous = lastNode.previous;
            lastNode.previous.next = lastNode.next;
            size--;
            index--;
            lastNode = null;
        }

        @Override
        public void set(T t) {
            checkForOtherModif();
            if (lastNode == null) {
                throw new IllegalStateException();
            }
            lastNode.value = t;
        }

        @Override
        public void add(T t) {
            checkForOtherModif();
            Node<T> newNode = new Node<>(t);
            newNode.previous = nextNode.previous;
            newNode.next = nextNode;
            nextNode.previous.next = newNode;
            nextNode.previous = newNode;
            lastNode = null;
            size++;
            index++;
        }

        private void checkForOtherModif() {
            if (iteratorModCount != modCount) throw new ConcurrentModificationException();
        }
    }

    private class MyIterator implements Iterator<T> {
        private int index;
        private Node<T> nextNode;
        private int iteratorModCount = modCount;

        MyIterator() {
            nextNode = head.next;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (modCount != iteratorModCount) throw new ConcurrentModificationException();
            index++;
            T value = nextNode.value;
            nextNode = nextNode.next;
            return value;
        }
    }
}