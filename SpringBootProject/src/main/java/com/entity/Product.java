package com.entity;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@Column(name = "pname", nullable = false)
	private String productName;

	@Column(name = "ptype", nullable = false)
	private String productType;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "categoryID")
	@JsonBackReference
	private Category category;

	@CreationTimestamp
	@Column(name = "createdDate", updatable = false)
	private Instant createdTime;

	@CreationTimestamp
	@Column(name = "updatedTime", updatable = true)
	private Instant updatedTime;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", category=" + category + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

}
