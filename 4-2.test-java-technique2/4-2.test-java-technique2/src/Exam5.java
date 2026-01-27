public class Exam5 {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Book book1 = new Book();
        book1.setName("アナと雪の女王");
        book1.setPrice(3000);
        shoppingCart.addItem(book1);

        Book book2 = new Book();
        book1.setName("美女と野獣");
        book1.setPrice(2000);
        shoppingCart.addItem(book2);

        Book book3 = new Book();
        book1.setName("モアナと伝説の海");
        book1.setPrice(8000);
        shoppingCart.addItem(book3);

        System.out.println("合計値：" + shoppingCart.getTotalPrice());
        System.out.println("平均値：" + shoppingCart.getAveragePrice());
    }
}
