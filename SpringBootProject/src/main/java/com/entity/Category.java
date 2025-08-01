package com.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", nullable = false)
	private long categoryId;

	@Column(name = "categoryName", nullable = false)
	private String categoryName;

	@OneToMany(mappedBy = "category")
	@JsonManagedReference
	private List<Product> products;

	@CreationTimestamp
	@Column(name = "createdDate", updatable = false)
	private Instant createdTime;

	@CreationTimestamp
	@Column(name = "updatedTime", updatable = true)
	private Instant updatedTime;

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + "]";
	}

}
