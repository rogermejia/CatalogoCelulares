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
@Table(name = "marca_pro")
public class MarcaPro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rel")
	private Integer idRel;
	
	@Column(name= "id_marca")
	private Integer idMarca;
	
	@Column(name= "id_prov")
	private Integer idProv;

    @ManyToOne
	@JoinColumn(name = "id_marca", referencedColumnName = "id_marca", insertable=false, updatable = false)
    private Marca id_marca;
	
    @ManyToOne
	@JoinColumn(name = "id_prov", referencedColumnName = "id_prov", insertable=false, updatable = false)
    private Proveedor id_prov;
	
	public MarcaPro() {

	}

	public MarcaPro(Integer idRel, Integer idMarca, Integer idProv) {
		super();
		this.idRel = idRel;
		this.idMarca = idMarca;
		this.idProv = idProv;
	}

	public Integer getIdRel() {
		return idRel;
	}

	public void setIdRel(Integer idRel) {
		this.idRel = idRel;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public Integer getIdProv() {
		return idProv;
	}

	public void setIdProv(Integer idProv) {
		this.idProv = idProv;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRel == null) ? 0 : idRel.hashCode());
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
		MarcaPro other = (MarcaPro) obj;
		if (idRel == null) {
			if (other.idRel != null)
				return false;
		} else if (!idRel.equals(other.idRel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarcaPro [idRel=" + idRel + "]";
	}
	
}
