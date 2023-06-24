package BookShop.Realizations;

import BookShop.Interfaces.IPaperLit;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *      класс контейнера
 * */
public class Container<T extends IPaperLit>implements Serializable  {
    /**
     * поле массива
     */
    private T[] array;
    class Enumerator implements Enumeration<T>{
        private int position = array.length;

        @Override
        public boolean hasMoreElements()
        {
            return position > 0;
        }

        @Override
        public T nextElement() throws NoSuchElementException
        {
            if(position == 0)
                throw new NoSuchElementException("Container");
            return array[--position];
        }


    }
    public Enumeration<T> elements()
    {
        return new Enumerator();
    }
    public Enumeration<T> PriceFilter(final float minPrice, final float maxPrice)
    {

        return new Enumeration<T>(){
            int current = array.length;
            /**
             * тут мы ищем елементы которые входят в пределы
             * */
            @Override
            public boolean hasMoreElements()
            {
                for(int i = current - 1; i> 0;i--){
                    if(array[i].getPrice() >= minPrice && array[i].getPrice()<= maxPrice){
                        current = i;
                        return true;
                    }
                }
                current = -1;
                return false;
            }
            /**
             * тут мы возвращаем елементы
             * */
            @Override
            public T nextElement() throws NoSuchElementException
            {
                if(current == -1){
                    throw new NoSuchElementException("Container");
                }
                return array[current];
            }
        };
    }
    public int  getLength(){
        return  array.length;
    }
    public boolean Empty(){ return array== null;}
    public Container(int l){
        this.array = (T[]) new Object[l];
    }
    /**
     * конструктор по умолчанию
     */
    public Container() {
        T[] array = (T[])new IPaperLit[0];
    }
    public Container(Container<T> cont){
        array = cont.array;
    }

    /**
     * получить элемент по индексу
     */
    public T getByIndex(final int index) throws ContainerException {
        if (index < 0 || index >=  array.length) {
            throw new ContainerException(index);
        } else
            return array[index];

    }

    /**
     * вставка(в конец)
     */
    public void Add(final T element) throws ContainerException {
        if(array == null){
                AddByIndex(element, 0);
        }
        else AddByIndex(element, array.length);

    }

    /**
     * вставка по индексу
     */
    public void AddByIndex(final T elem, final int index) throws ContainerException {
        T[] buffer = null;
        // создаем новый массив
        if (array != null) {
            buffer = (T[]) new IPaperLit[array.length + 1];

            // предусматриваем варианты
            // когда индекс выходит за
            // рамки массива
            if (index < 0 || index > buffer.length)
                throw new ContainerException(index);
            // заполняем новый массив
            System.arraycopy(array, 0, buffer, 0, index);
            buffer[index] = elem;
            if (array.length - index >= 0) System.arraycopy(array, index, buffer, index + 1, array.length - index);
        } else {
            buffer = (T[]) new IPaperLit[1];
            buffer[0] = elem;
        }

        // сохраняем новый массив
        array = buffer;
    }

    /**
     * удаление из конца
     */
    public void Delete() throws ContainerException {
        if (array != null)
            Delete(array.length - 1);

    }

    /**
     * удаление по индексу
     */
    public void Delete(final int index) throws ContainerException {
        // создаем новый массив
        T[] buffer = (T[]) new IPaperLit[array.length - 1];

        // предусматриваем варианты
        // когда индекс выходит за
        // рамки массива
        if (index < 0 || index >= array.length)
            throw new ContainerException(index);
        // заполняем новый массив
        System.arraycopy(array, 0, buffer, 0, index);
        if (array.length - (index + 1) >= 0)
            System.arraycopy(array, index + 1, buffer, index + 1 - 1, array.length - (index + 1));
        // сохраняем новый массив
        array = buffer;
    }
    public void SetByIndex(int index, T element) throws ContainerException {
        // предусматриваем варианты
        // когда индекс выходит за
        // рамки массива
        if (index < 0 || index >= array.length)
            throw new ContainerException(index);
        if (array == null)
                AddByIndex(element, 0);
        else {
            array[index] = element;
        }

    }
    /**
     * печать массива
     */
    public void Print() {
        if(array == null)
            System.out.println("Array is Empty");
        else
            for (T variable : array )
                {
                    System.out.println(variable);
                }
    }
    @Override
    public String toString(){
        String res = "";
        if(array != null)
        {
            for(int i = 0; i< array.length; i++)
                res += "[" + i+ "] - { "+ array [i].toString()+ "} \n";

        }
        return res;

    }

    /**
     * обмен элементов по индексу
     */
    protected void Swap(final int index1, final int index2) {
        T buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }

    /**
     * зануление полей класса, триггеринг gc()
     */
    public void Clear() {
        if(array == null)
            System.out.println("Array is empty");
        else array = null;
    }

    /**
     * сортировка
     * AscDesc - true - возростающий порядок
     * AscDesc - false - нисходящий порядок
     */
    public void Sort(boolean AscDesc) {
        if (array!= null)
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    float p1 = array[j].getPrice(),
                          p2 = array[j + 1].getPrice();
                    if ((AscDesc && p1 > p2) || (!AscDesc && p1 < p2))
                        Swap(j, j + 1);
                }
            }
    }
    public void FillStaticVars(){
        if (array != null)
        for (T t : array) {
            PaperLiterature.Add((PaperLiterature) t);
        }
    }
    public void DeleteStaticVars(){
        if (array != null)
        for (T t : array) {
            PaperLiterature.Delete((PaperLiterature) t);
        }
    }
    public void Deserialization(String path)throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        array = (T[])ois.readObject();
        fis.close();
        ois.close();

    }
    public void Serialization(String path)throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(array);
        fos.flush();
        fos.close();
        oos.flush();
        oos.close();
    }
    public ArrayList<T> toArrayList(){
        if (this.array != null){
            return new ArrayList<>(List.of(this.array));
        }
       return null;
    }
}
