package org.hibernate.bugs;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "ENTITY_A")
public class EntityA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;

	@Version
	@Column(name = "VERSION")
	long version;

	@Column(name = "PROPERTY_A")
	int propertyA;

	@ManyToMany
	@JoinTable(name = "ENTITY_A_TO_ENTITY_A", //
			inverseJoinColumns = @JoinColumn(name = "SIDE_B"), //
			joinColumns = @JoinColumn(name = "SIDE_A"))
	final List<EntityA> owners = new ArrayList<>();
}