package telran.list.model;

import telran.list.interfaces.IList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements IList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;


    @Override
    public boolean add(int index, E element) {
        //Добавляем в конец
        if(index == size) {
            //Создание новой ноды
            Node<E> newNode = new Node<>(element, last, null);
            //Заполнение других нод
            if(last != null) {
                last.next = newNode;
            } else {
                first = newNode;
            }
            last = newNode;
        } else {
            //Добавляем в начало или середину
            //Поиск ноды по индексу (на её место добавляем)
            Node<E> node = getNodeByIndex(index);
            //Создание новой ноды
            Node<E> newNode = new Node<>(element, node.prev,node);
            //Заполнение других нод
            //Указываем, что для следующей ноды ссылка на предыдущую будет наша новая нода
            node.prev =newNode;
            if(index != 0) {
                newNode.prev.next = newNode; //Если есть предыдущая нода, но ставим в ее ссылку нехт нашу новую ноду
            } else first = newNode;
        }
        size++;
        return true;
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node;
        if(index < size/2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index ; i--) {
                node=node.prev;
            }
        }
        return node;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public E get(int index) {
        return getNodeByIndex(index).data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if(element != null) {
            for(Node<E> node = first; node != null; node=node.next, index++) {
                if (element.equals(node.data))
                    return index;
            }
        } else {
            for(Node<E> node = first; node != null; node=node.next, index++) {
                if (element == node.data)
                    return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        int index = size - 1;
        if(element != null) {
            for(Node<E> node = last; node != null; node=node.prev, index--) {
                if (element.equals(node.data))
                    return index;
            }
        } else {
            for(Node<E> node = last; node != null; node=node.prev, index--) {
                if (element == node.data)
                    return index;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> node = getNodeByIndex(index);
        E oldValue = node.data;
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;

        if(prevNode != null)
            prevNode.next = nextNode;
         else
            first = nextNode;

         if(nextNode != null)
            nextNode.prev = prevNode;
         else
             last = prevNode;

         node.data = null;
         node.prev = null;
         node.next = null;
         size--;
         return oldValue;
    }

    @Override
    public void clear() {
        Node<E> current = first;
        while(current != null) {
            Node<E> next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> node = getNodeByIndex(index);
        E oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Node<E> current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
               if(!hasNext())
                   throw new NoSuchElementException();
               E data = current.data;
               current = current.next;
               return data;
            }
        };
    }
}
