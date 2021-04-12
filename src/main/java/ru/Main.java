package ru;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cart", Cart.class);
        ProductRepository list = context.getBean("productRepository", ProductRepository.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list.showAllProducts();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Добавить товар в корзину - add. \nУдалить товар из корзины - delete. \nКупить - buy. Список товаров - show.");
        System.out.println("----------------------------------------------------------------");
        while (true) {
            String str = br.readLine();
            if (str.equals("add")) {
                System.out.println("Введите ID товара");
                Long id = Long.parseLong(br.readLine());
                cart.addProductInCart(id);
                System.out.println("Добавить товар в корзину - add. \nУдалить товар из корзины - delete. \nКупить - buy. Список товаров - show.");
            }
            if (str.equals("delete")) {
                System.out.println("Введите ID товара");
                Long id = Long.parseLong(br.readLine());
                cart.deleteProductInCart(id);
                cart.showProductInCart();
                System.out.println("Добавить товар в корзину - add. \nУдалить товар из корзины - delete. \nКупить - buy. Список товаров - show.");
            }
            if (str.equals("show")) {
                cart.showProductInCart();
            }
            if (str.equals("buy")) {
                System.out.println("Поздравляем с покупкой!");
                return;
            }
        }
    }
}