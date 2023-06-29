package BookShop.Realizations;

import BookShop.Interfaces.IPaperLit;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *      Container of PaperLiterature
 * */
public class Container<T extends IPaperLit>implements Serializable  {


    /**
     *    field - Array
     */
    private T[] array;


    /**
     *      Built-in Iterator class
     * */
    class Enumerator implements Enumeration<T>{
        /**
         *    field - Current position
         * */
        private int position = array.length;
        /**
         * Method that returns true if there are more elements
         * */
        @Override
        public boolean hasMoreElements()
        {
            return position > 0;
        }
        /**
         * Returns the next element
         * */
        @Override
        public T nextElement() throws NoSuchElementException
        {
            if(position == 0)
                throw new NoSuchElementException("Container");
            return array[--position];
        }
    }


    /**
     * Method that returns Iterator for Container
     * */
    public Enumeration<T> elements()
    {
        return new Enumerator();
    }


    /**
     *    Method that returns length
     */
    public int  getLength(){
        return  array.length;
    }


    /**
     * Method that returns true if array is empty
     * */
    public boolean Empty(){ return array== null;}


    /**
     *          Constructor that allocates memory for array of given size
     * */
    public Container(int l){
        this.array = (T[]) new Object[l];
    }


    /**
     *      Default constructor
     */
    public Container() {
        T[] array = (T[])new IPaperLit[0];
    }


    /**
     *      Copy constructor
     * */
    public Container(Container<T> cont){
        array = cont.array;
    }


    /**
     *      Returns element at given index
     */
    public T getByIndex(final int index) throws ContainerException {
        if (index < 0 || index >=  array.length) {
            throw new ContainerException(index);
        } else
            return array[index];

    }


    /**
     *      Adds element to the end of an array
     */
    public void Add(final T element) throws ContainerException {
        if(array == null){
                AddByIndex(element, 0);
        }
        else AddByIndex(element, array.length);

    }


    /**
     *      Adds element to the argument "index" position,
     *      moving the elements on the right on one position to the right.
     */
    public void AddByIndex(final T elem, final int index) throws ContainerException {
        T[] buffer = null;
        /*
        *       Case when the array is not empty
        * */
        if (array != null) {
            buffer = (T[]) new IPaperLit[array.length + 1];

            /*
            *       Here we check if the index is out of bounds
            * */
            if (index < 0 || index > buffer.length)
                throw new ContainerException(index);
            /*
            *       Here we copy the elements
            * */
            System.arraycopy(array, 0, buffer, 0, index);
            buffer[index] = elem;
            /*
            *       Here we fill the part of the array that was to the right of current position
            * */
            if (array.length - index >= 0) System.arraycopy(array, index, buffer, index + 1, array.length - index);
        }
        /*
        *       Case when the array is empty
        * */
        else {
            buffer = (T[]) new IPaperLit[1];
            buffer[0] = elem;
        }

        /*
        *       Here we save the new array to the array field
        * */
        array = buffer;
    }


    /**
     *      Method that deletes element from the end
     */
    public void Delete() throws ContainerException {
        if (array != null)
            Delete(array.length - 1);

    }


    /**
     * Method that deletes element in position which is set as argument "index"
     */
    public void Delete(final int index) throws ContainerException {
        /*
        *       Here we create a new array
        * */
        T[] buffer = (T[]) new IPaperLit[array.length - 1];

        /*
        *       Here we check if the index is out of bounds
        * */
        if (index < 0 || index >= array.length)
            throw new ContainerException(index);

        /*
        *       Here we fill new array
        * */
        System.arraycopy(array, 0, buffer, 0, index);
        /*
        *       Here we fill the array with the rest of the elements which were after the deleted element
        * */
        if (array.length - (index + 1) >= 0)
            System.arraycopy(array, index + 1, buffer, index + 1 - 1, array.length - (index + 1));

        /*
        *       Here we save the new array
        * */
        array = buffer;
    }


    /**
     *      Sets passed element to the "index" position
     * */
    public void SetByIndex(int index, T element) throws ContainerException {
        /*
        *       Here we check if the index is out of bounds
        * */
        if (index < 0 || index >= array.length)
            throw new ContainerException(index);
        /*
        *       Here we create array if its empty
        * */
        if (array == null)
                AddByIndex(element, 0);
        else {
            array[index] = element;
        }

    }


    /**
     * Converts Container object to String
     * */
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
     *    Swap method
     */
    protected void Swap(final int index1, final int index2) {
        T buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }


    /**
     *      Clearing array
     */
    public void Clear() {
        array = null;
    }


    /***
     * Sort method :
     *     1: AscDesc - true - ascending order .
     *     2: AscDesc - false - descending order .
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


    /**
     *      Deserialization of Container
     * */
    public void Deserialization(String path)throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        array = (T[])ois.readObject();
        fis.close();
        ois.close();

    }


    /**
     *      Serialization of Container
     * */
    public void Serialization(String path)throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(array);
        fos.flush();
        fos.close();
        oos.flush();
        oos.close();
    }


    /**
     *      Conversion to ArrayList
     * */
    public ArrayList<T> toArrayList(){
        if (this.array != null){
            return new ArrayList<>(List.of(this.array));
        }
       return null;
    }


}
