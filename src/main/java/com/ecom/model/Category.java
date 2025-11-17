package com.ecom.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String description;

	@Column(nullable = false)  
	private Boolean isActive;

	@Column(nullable = false)
	private Boolean isDeleted; 

	@Column(nullable = false) 
	private Boolean isFeatures;

	@Column(nullable = true)
	private String images;

//	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<Product> products; 
}
