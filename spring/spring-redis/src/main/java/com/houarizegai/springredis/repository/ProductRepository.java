package com.houarizegai.springredis.repository;

import com.houarizegai.springredis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HouariZegai, created on 31/05/2021
 */
@Repository
public class ProductRepository {

    private static final String HASH_KEY = "Product";
    private final RedisTemplate template;

    @Autowired
    public ProductRepository(RedisTemplate template) {
        this.template = template;
    }

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);

        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteById(int id) {
        template.opsForHash().delete(HASH_KEY, id);

        return "product removed!";
    }
}
