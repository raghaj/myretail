package com.myretail.product.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="product_price")
public class ProductPrice {

	@Id
	@JsonIgnore
	private long id;

	private Double value;

	@JsonProperty("currency_code")
	@Field("currency_code")
	private String currCode;


	public ProductPrice(String id) {
		this.id = new Long(id);
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}
}
