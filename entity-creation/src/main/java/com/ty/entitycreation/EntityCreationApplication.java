package com.ty.entitycreation;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entitycreation.dbentity.Product;
import com.ty.entitycreation.dbentity.ProductRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
@Validated
public class EntityCreationApplication {

	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntityCreationApplication.class, args);
	}

	@GetMapping("/greet")
	public String greetUserWithDefault(@RequestParam(required = false, defaultValue = "Guest") String name) {
		return "Welcome " + name;
	}

	@GetMapping("/welcome")
	public String greetUser(@Size(min = 4, max = 6) @RequestParam String name) {
		return "Welcome " + name;
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/store")
	public ResponseEntity<Product> storeProduct(@Valid @RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}

}
