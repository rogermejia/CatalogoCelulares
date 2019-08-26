package com.empresa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.empresa.config.HibernateConfig;
import com.empresa.entidades.Marca;
import com.empresa.entidades.MarcaPro;
import com.empresa.entidades.Producto;

public class ProductoDao {

	List<Producto> listProd;
	List<Producto> prod;
	List<Marca> listMarca;
	List<MarcaPro> listMarcaPro;
	
	public List<Producto> getAllProductos() {
		listProd = new ArrayList<Producto>();
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			listProd = session.createQuery("from Producto", Producto.class).list();
			return listProd;
		}
	}
	
	public List<Producto> getProductoById(Integer id) {
		prod = new ArrayList<Producto>();
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			prod = session.createQuery("from Producto where id_prod = :idProd", Producto.class).setParameter("idProd", id).list();
			return prod;
		}
	}
	
	public String deleteProductoById(Producto p) {
		try {
			Session session = HibernateConfig.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(p);
		      session.getTransaction().commit();
		      System.out.println("Producto Eliminado");
		      
		      return "Eliminación Exitosa";
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Guardado fallido");
				return "Eliminación Fallida";
			}
		}
	
	public void guardarProducto (Producto p) {
		try {
		Session session = HibernateConfig.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(p);
	      session.getTransaction().commit();
	      System.out.println("Producto Guardado");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Guardado fallido");
		}
	}
	
	public void updateProducto(Producto p) {
		try {
		Session session = HibernateConfig.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.saveOrUpdate(p);
	      session.getTransaction().commit();
	      System.out.println("Producto Actualizado");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Actualización Fallida");
		}
	}
	
	public List<Marca> getAllMarcas() {
		listMarca = new ArrayList<Marca>();
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			listMarca = session.createQuery("from Marca", Marca.class).list();
			return listMarca;
		}
	}
	
	public List<MarcaPro> getAllMarcaPro() {
		listMarcaPro = new ArrayList<MarcaPro>();
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			listMarcaPro = session.createQuery("from MarcaPro", MarcaPro.class).list();
			return listMarcaPro;
		}
	}
	
}
