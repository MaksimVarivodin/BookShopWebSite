package BookShop.Realizations;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class BookShop {
    Container<PaperLiterature> booklist, basket;

    public BookShop(){
        booklist = new Container<PaperLiterature>();
        basket = new Container<PaperLiterature>();
    }

    public int generateRandom(int min, int max){
        return (int)( Math.random() * (max - min + 1) + min);
    }
    public void Generate() throws ContainerException, ProductException{
        // объявление массивов книг и комиксов заданного ранее размера
        Book[] bs = new Book[5];
        Comics[] cmcs = new Comics[6];
        // генерация данных и заполнение статических полей Печатной литературы(предок)
        for(int i = 0; i< bs.length; i++){
            int j = i+ 1;
            bs[i] = new Book("BookName "+ j, generateRandom(0, j* 100), generateRandom(0, j* 100), generateRandom(0, j* 1000), "AuthorName "+ generateRandom(1, j));

            Book.Add(bs[i]);
            booklist.Add(bs[i]);
            booklist.getByIndex(i).setId(i);
        }
        // генерация данных и заполнение статических полей Печатной литературы(предок)
        for(int i = 0; i< cmcs.length; i++){
            int j = i+ 1;
            cmcs[i] = new Comics("ComicsName "+j, generateRandom(0, j* 115), "IllustratorName "+ generateRandom(1, j), generateRandom(10,  50) );
            Comics.Add(cmcs[i]);
            booklist.Add( cmcs[i]);
            booklist.getByIndex(i+ bs.length).setId(i+bs.length);
        }

    }

    /**
     * печать списка продукции
     * */
    public void PrintBookList(){
        Scanner inp = new Scanner(System.in);
        System.out.print("""
                Enter type of sort:
                * AscDesc - true - возростающий порядок
                * AscDesc - false - нисходящий порядок
                -> """);
        booklist.Sort(inp.nextBoolean());
        booklist.Print();
    }

    /**
     * получение информации в виде строк
     * */
    private String []FillOneBook(String [] fields){
        String [] data = new String[fields.length];
        Scanner inp = new Scanner(System.in);
        for(int i = 0; i< fields.length;i++)
        {
            System.out.println("Enter "+ fields[i]+ ": ");
            data[i] = inp.nextLine();
        }
        return data;
    }

    /**
     * свитч для книг и комиксов
     * */
    public PaperLiterature createBook(int type) throws ProductException{
        return switch(type){
            case 1 -> new Book(FillOneBook(Book.GetFieldNames()));
            case 2 -> new Comics(FillOneBook(Comics.GetFieldNames()));
            default -> null;
        };


    }



    /**
     * добавление бумажной литературы в корзину
     * */
    public void addBooksToBasket(PaperLiterature book, int quantity) throws ContainerException{
        for(int i = 0; i< quantity; i++)
            basket.Add(book);

    }

    private float getBasketCost(){
        float cost = 0;
        Enumeration<PaperLiterature> en = basket.elements();
        while(en.hasMoreElements()){
            cost += en.nextElement().getPrice();
        }
        return cost;
    }

    /**
     * покупка книгв корзине
     * */
    private void Buy(){
        System.out.println("You bought "+ basket.getLength()+ " books.");
        System.out.println("COST: "+ getBasketCost());
        clearBasket();
    }

    /**
     * очистка корзины
     * */
    public void clearBasket(){
        basket.Clear();
        System.out.println("Basket Cleared");
    }
    public void deleteByIndex(int index) throws ContainerException {
        basket.Delete(index);
    }
    public ArrayList<PaperLiterature> getBookItems(){
        return this.booklist.toArrayList();
    }
    public ArrayList<PaperLiterature> getCartItems(){
        return this.basket.toArrayList();
    }



}
