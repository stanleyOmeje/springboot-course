package com.stan.springbootcourse.service.impl;

import com.stan.springbootcourse.dto.request.CreateProductRequest;
import com.stan.springbootcourse.dto.response.DefaultResponse;
import com.stan.springbootcourse.dto.response.ProductDto;
import com.stan.springbootcourse.entity.Category;
import com.stan.springbootcourse.entity.Products;
import com.stan.springbootcourse.exceptions.AlreadyExistException;
import com.stan.springbootcourse.exceptions.NotFoundException;
import com.stan.springbootcourse.mapper.ProductMapper;
import com.stan.springbootcourse.repository.CategoryRepository;
import com.stan.springbootcourse.repository.ProductRepository;
import com.stan.springbootcourse.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public DefaultResponse<ProductDto> createProduct(CreateProductRequest request) {
        log.info("Inside create product with Create product request: {}", request);
        DefaultResponse<ProductDto> response = new DefaultResponse<>();
        try {
            String productCode = request.getCode().replaceAll("\\s+", "_");
            String categoryCode = request.getCategoryCode().replaceAll("\\s+", "_");
            Optional<Products> products = productRepository.findProductByCode(productCode);
            if (products.isPresent()) {
                throw new AlreadyExistException("Product already exists", "01");
            }
            Optional<Category> category = categoryRepository.findCategoryByCategoryCode(categoryCode);
            if (category.isEmpty()) {
                throw new NotFoundException("Category does not exists", "01");
            }
            Products product = new Products();
            product.setCode(productCode);
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setCategory(category.get());
            // Products product = productMapper.productDtoToProduct(request, category.get());
            product = productRepository.save(product);
            ProductDto productDto = productMapper.productToProductDto(product, category.get());
            response.setStatus("01");
            response.setMessage("Product created");
            response.setData(productDto);
            log.info("Product created: {}", productDto);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public DefaultResponse<ProductDto> updateProduct(String code, CreateProductRequest request) {
        log.info("Inside update product with Create product request: {}", request);
        DefaultResponse<ProductDto> response = new DefaultResponse<>();
        try {
            String productCode = request.getCode().replaceAll("\\s+", "_");
            String categoryCode = request.getCategoryCode().replaceAll("\\s+", "_");
            Optional<Products> products = productRepository.findProductByCode(productCode);
            if (products.isEmpty()) {
                throw new NotFoundException("01", "Product already exists");
            }
            Optional<Category> category = categoryRepository.findCategoryByCategoryCode(categoryCode);
            if (!products.isPresent()) {
                throw new NotFoundException("Category does not exists", "01");
            }
            Products product = products.get();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setCategory(category.get());

            product = productRepository.save(product);
            ProductDto productDto = productMapper.productToProductDto(product, category.get());
            response.setStatus("01");
            response.setMessage("Product created");
            response.setData(productDto);
            log.info("Product created: {}", productDto);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
