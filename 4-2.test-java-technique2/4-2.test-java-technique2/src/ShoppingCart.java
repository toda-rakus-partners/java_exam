import java.util.LinkedList;
import java.util.List;

public class ShoppingCart extends LinkedList{

    List<Item> list = null;

    public ShoppingCart() {
        list = new LinkedList<>();
    }

    public void addItem(Item item) {
        list.add(item);
    }

    public int getTotalPrice() {
        int sum = 0;

        for (Item item : list) {
            sum += item.getPrice();
        }
        return sum;
    }

    public int getItemSize() {
        return list.size();
    }

    public int getAveragePrice(){
        int average = 0;

        average = getTotalPrice() / getItemSize();

        return average;
    }
}
