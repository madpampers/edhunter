package ru.edhunter.dz3;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> implements Map<K, V> {//сигнатура класса MyHashMap, который реализует интерфейс Map данный по заданию
    private final List<Entry<K, V>>[] mapCells;//внутренний массив, содержащий списки(бакеты) мапы
    private int size = 0;//изначальный размер нашей мапы

    @SuppressWarnings("all")
    public MyHashMap(final int length) {//конструктор класса, принимает на вход длину внутреннего массива
        //какая то проблема с созданием типизированного массива, лучше использовать коллекцию в таких случаях наверное
        mapCells = new LinkedList[length];//инициализируем наш массив(создаем его)
        for (int i = 0; i < length; i++) {//инициализируем бакеты в цикле, каждой ячейке массива бакетов, присваиваем
            mapCells[i] = new LinkedList<Entry<K, V>>();//инстанс бакета
        }
    }

    @Override
    public void put(final K key, final V value) {//метод, который добавляет запись ключ-значение в нашу коллекцию(мапу)
        if (findKey(key) != -1) {//вызывается метод для определения, есть ли запись (Entry) с данным ключем в нашей мапе findKey(key)
            getList(key).get(findKey(key)).setValue(value);//если есть, то по данному ключу в записи меняет значение setValue(Value), нужный бакет
        } else {//выбирается методом getList(key)
            getList(key).add(new Entry<>(key, value));//если нет то добавляет новую запись ключ-значение new Entry<>(key, value)
            size++; //в данном случае еще к тому же увеличиваем размер на 1
        }
    }

    @Override
    public V get(final K key) {//этот метод возвращает значение по заданному ключу
        int keyLoc = findKey(key);//ищем ключ findKey(key)
        if (keyLoc != -1) {//если ключ есть (keyLoc != -1)
            return getList(key).get(keyLoc).getValue(); //возвращаем ключ по его keyLoc
        } else {
            return null; //если keyLoc == -1 (ключ в нашей коллекции нет) возвращаем null
        }
    }

    @Override
    public void remove(final K key) {//этот метод удаляет запись по заданному ключу
        if (findKey(key) != -1) {//ищем наш ключ в коллекции
            getList(key).remove(findKey(key));//если есть, удаляем его из бакета (листа в массиве листов), нужный бакет возвращает метод getList(key)
            size--;//после удаления уменьшаем размер мапы на 1
        }
    }

    @Override
    public int size() {
        return this.size;
    }//метод возвращает размер мапы

    private int getCell(final K key) { //вспомогательный приватный метод определяет нужный бакет с записями (Entry) по хешкоду
        return key.hashCode() % mapCells.length; //бакет определяется по остатку от деления хешкода на размер внутреннего массива
    }

    private List<Entry<K, V>> getList(K key) {//вспомогательный приватный метод, возвращает список (лист) Entry из нужного бакета
        return mapCells[getCell(key)];//из какой ячейки его брать определяет с помощью метода getCell(key)
    }

    private int findKey(final K key) { //вспомогательный внутренний метод, который в нужном бакете определяет где находится ключ, который мы ему передаем (final K key)
        int cell = getCell(key); //определяем ячейку где наг бакет
        for (int i = 0; i < getList(key).size(); i++) {//в цикле пробегаемся по всем элементам бакета
            if (mapCells[cell].get(i).getKey().equals(key)) {//проверяем каждый элемент, не содержит ли запись (Entry) нужный ключ (сравниваем ключ в записи и ключ, переданный методу)
                return i;//если они совпадают, возвращает значение i, i это как раз номер элемента в бакете, в котором нужная нам запись
            }
        }
        return -1;//если пробежавшись по всему циклу мы так и не нашли нужный ключ возвращаем Null
    }

    @SuppressWarnings("all")
    private static class Entry<K, V> { //вспомогательный приватный класс хрянящий ключ+значение
        private final K key;
        private V value;

        Entry(final K key, final V value) {//запись создается конструктором, принимающим ключ и значение
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }//метод возвращает ключ из записи

        public V getValue() {
            return value;
        }//метод возвращает значение из записи

        public void setValue(V value) {
            this.value = value;
        }//метод меняет значение записи
    }
}