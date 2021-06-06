package com.example.springmvcdemo.component;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private static final ProductRepository INSTANCE = new ProductRepository();
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    {
//        for (long i = 1; i < 6; i++) {
//            BigDecimal rndPrice = BigDecimal.valueOf(new Random().nextInt(100000)).divide(BigDecimal.valueOf(100));
//            productMap.put(i, new Product(i, "Product " + i, rndPrice));
//        }

        // ручное заполнение
        productMap.put(1L, new Product(1L, "Молоко 3,5%, 1 л", BigDecimal.valueOf(89.99)));
        productMap.put(2L, new Product(2L, "Сметана 15%, 300 г", BigDecimal.valueOf(75.99)));
        productMap.put(3L, new Product(3L, "Хлеб Бородинский, 300 г", BigDecimal.valueOf(21.99)));
        productMap.put(4L, new Product(4L, "Сыр Четук 45%, 370 г", BigDecimal.valueOf(231.99)));
        productMap.put(5L, new Product(5L, "Хлопья овсяные, 500 г", BigDecimal.valueOf(63.99)));
    }



    // получить список всех продуктов
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    // сохранить продукт
    // если в метод передан новый продукт без заданного id, то будет добавлен очередной
    // если продукт с заданным id уже есть в мапе, то он будет заменен на новый
    public void saveOrUpdate(Product product) {
        if (product.getId() == null) {
            Long id = Collections.max(productMap.keySet()) + 1;
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    // найти продукт по id
    public Product findById(Long id) { return productMap.get(id); }

    // удалить продукт по id
    public void deleteById(Long id) {
        productMap.remove(id);
    }}
