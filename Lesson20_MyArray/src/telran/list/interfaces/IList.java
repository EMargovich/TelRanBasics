package telran.list.interfaces;

public interface IList<E> extends Iterable<E> {

    //При добавлении массив увеличивается
    default boolean add(E element) {
        return add(size(), element );
    }

    boolean add(int index, E element);

    E get(int index);

    int size();

    //Если не нашел, возвращает -1
    int indexOf(E element);

    int lastIndexOf(E element);

    E remove(int index);

    //Удаляем один объект по объекту
    default boolean remove(E element) {
        int index = indexOf(element);
        if(index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    //Вспомогательный метод, показывает есть ли объект в массиве
    default boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    //Очищает массив
    void clear();

    //Проверяет пустой ли массив
    default boolean isEmpty() {
        return size() == 0;
    }

    //Замещает элемент по индексу. Возвращает замещаемый элемент
    E set(int index, E element);
}
