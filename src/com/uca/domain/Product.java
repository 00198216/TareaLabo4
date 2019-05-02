package com.uca.domain;


import java.math.BigDecimal;
//import java.sql.Date;
//import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;

//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.format.annotation.DateTimeFormat.ISO;

//import com.fasterxml.jackson.annotation.JsonFormat;



public class Product {
	
	@Size(message="Ha pasado el maximo de 30 caracteres",max=30)
	@NotEmpty(message="El nombre del producto es requerido.")
	private String name;
	
	@Size(message="Ha pasado el maximo de 30 caracteres",max=30)
	@NotEmpty(message="El nombre de la Marca es requerido.")
    private String marca;
	
	@Size(message="Ha pasado el maximo de 30 caracteres",max=30)
	@NotEmpty(message="la descripcion del producto es requerido.")
    private String desc;
	
	@Size(message="Ha pasado el maximo de 30 caracteres",max=30)
	@NotEmpty(message="la categoria del producto es requerido.")
    private String category;
	
	@NotNull(message="El precio del producto es requerido.")
	@Digits(message="Ingrese una cantidad valida",integer=30,fraction=2)
	@PositiveOrZero(message="Ingrese un monto positivo")
    private BigDecimal money;
    
	@DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull(message="la fecha del producto es requerido.")
    private Date fecha;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
       
}
