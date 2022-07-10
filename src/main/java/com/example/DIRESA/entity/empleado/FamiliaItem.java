package com.example.DIRESA.entity.empleado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.DIRESA.entity.general.Familia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="familia_item")
@EqualsAndHashCode

public class FamiliaItem implements Serializable{
	@EmbeddedId
	  private FamiliaItemUpk familiaItemUpk;

    
   
    @Column(name = "valor", nullable = false, length = 100)
    private String valor;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

}
