package views;

import java.util.List;

public interface IViews<T> {

    public void displayList(List<T> items);

    public void displayItem(T item);

    public void displaySearchItems(List<T> items);

    public void displayMessage(String message);

    public String readString(String prompt);

    public Integer readInteger(String prompt);

    public Double readDouble(String prompt);

}
