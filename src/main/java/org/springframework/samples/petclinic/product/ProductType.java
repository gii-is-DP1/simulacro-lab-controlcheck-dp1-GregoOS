package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class ProductType extends BaseEntity{
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name= "name",unique=true)
    String name;
}
