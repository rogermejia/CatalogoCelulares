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

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prov")
	private Integer idProv;
	
	@Column(name = "n_prov")
	private String nProv;
	
	@OneToMany(mappedBy = "id_prov", fetch = FetchType.EAGER)
	private Set<MarcaPro> listMarPro;

	public Proveedor() {
	
	}

	public Proveedor(Integer idProv, String nProv, Set<MarcaPro> listMarPro) {
		super();
		this.idProv = idProv;
		this.nProv = nProv;
		this.listMarPro = listMarPro;
	}

	public Integer getIdProv() {
		return idProv;
	}

	public void setIdProv(Integer idProv) {
		this.idProv = idProv;
	}

	public String getnProv() {
		return nProv;
	}

	public void setnProv(String nProv) {
		this.nProv = nProv;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProv == null) ? 0 : idProv.hashCode());
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
		Proveedor other = (Proveedor) obj;
		if (idProv == null) {
			if (other.idProv != null)
				return false;
		} else if (!idProv.equals(other.idProv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proveedor [idProv=" + idProv + "]";
	}
	
	
}
