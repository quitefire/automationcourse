package com.courses.week4.mockito.examples.service;

import com.courses.week4.mockito.examples.model.Product;

public interface ProductService {

	Product getProductById(long productId);

	boolean isProductInStock(long productId, int howMuch);
}
