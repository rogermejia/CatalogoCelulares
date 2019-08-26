package com.empresa.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.empresa.entidades.Producto;

@Entity
@Table(name = "marca")
public class Marca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca")
	private Integer idMarca;

	@Column(name = "n_marca")
	private String nMarca;

	@OneToMany(mappedBy = "id_marca", fetch = FetchType.EAGER)
	private Set<Producto> listProducto;
	
	@OneToMany(mappedBy = "id_marca", fetch = FetchType.EAGER)
	private Set<MarcaPro> listMarcaPro;

	public Marca() {
		
	}

	public Marca(Integer idMarca, String nMarca) {
		super();
		this.idMarca = idMarca;
		this.nMarca = nMarca;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getnMarca() {
		return nMarca;
	}

	public void setnMarca(String nMarca) {
		this.nMarca = nMarca;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMarca == null) ? 0 : idMarca.hashCode());
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
		Marca other = (Marca) obj;
		if (idMarca == null) {
			if (other.idMarca != null)
				return false;
		} else if (!idMarca.equals(other.idMarca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + "]";
	}

}
