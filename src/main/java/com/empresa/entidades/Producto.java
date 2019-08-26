package com.empresa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prod")
	private Integer idProd;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name = "id_marca")
	private Integer idMarca;
	
	@Column(name= "precio")
	private Double precio;
	
	@Column(name= "descrip")
	private String descrip;
	
	@Column(name= "stock")
	private Integer stock;
	
	@JoinColumn(name = "id_marca", referencedColumnName = "id_marca", insertable=false, updatable = false)
    @ManyToOne
    private Marca id_marca;

	public Producto() {

	}

	public Producto(Integer idProd, String nombre, Integer idMarca, Double precio, String descrip, Integer stock) {
		super();
		this.idProd = idProd;
		this.nombre = nombre;
		this.idMarca = idMarca;
		this.precio = precio;
		this.descrip = descrip;
		this.stock = stock;
	}

	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Marca getId_marca() {
		return id_marca;
	}

	public void setId_marca(Marca id_marca) {
		this.id_marca = id_marca;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProd == null) ? 0 : idProd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProd == null) {
			if (other.idProd != null)
				return false;
		} else if (!idProd.equals(other.idProd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [idProd=" + idProd + "]";
	}

	
}
