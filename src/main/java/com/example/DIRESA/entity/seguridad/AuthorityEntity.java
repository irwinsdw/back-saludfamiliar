package com.example.DIRESA.entity.seguridad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "AUTHORITY")
@ToString
@Data
public class AuthorityEntity{

	@Id
	@Column(name = "AUTHORITY_ID") 
	private Long id = 0L;

	@Column(name = "NOMBRE")
	private String nombre = "";

}
