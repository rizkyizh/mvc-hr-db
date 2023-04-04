package views.component;

import java.util.List;

public interface IComponentView<T> {

    public void displayList(List<T> items);

    public void displayItem(T item);

    public void displayMessage(String message);

    public String readString(String prompt);

    public Integer readInteger(String prompt);

    public Double readDouble(String prompt);

}
