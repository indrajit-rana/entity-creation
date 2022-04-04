// Generated with g9.

package com.ty.entitycreation.dbentity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity(name = "product")
public class Product {

	@Id
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, length = 255)
	@NotBlank(message = "Name Cannot be blank.")
	private String name;
	@Column(nullable = false, precision = 19, scale = 2)
	@Digits(fraction = 2, message = "Fraction should be two in digits.", integer = 10)
	private BigDecimal price;

	/** Default constructor. */
	public Product() {
		super();
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for name.
	 *
	 * @return the current value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 *
	 * @param aName the new value for name
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Access method for price.
	 *
	 * @return the current value of price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Setter method for price.
	 *
	 * @param aPrice the new value for price
	 */
	public void setPrice(BigDecimal aPrice) {
		price = aPrice;
	}

}
