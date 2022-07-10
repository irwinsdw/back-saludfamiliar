package com.example.DIRESA.entity.empleado;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
@EqualsAndHashCode
public class FamiliaItemUpk implements Serializable{
	
@NotNull
private Long familiaId;
@NotNull
private Long itemId;
}
