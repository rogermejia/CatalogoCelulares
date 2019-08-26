package com.empresa.controller;

import java.util.ArrayList;
import java.util.List;

import com.empresa.dao.ProductoDao;
import com.empresa.entidades.Marca;
import com.empresa.entidades.Producto;

public class Test {

	public static void main(String[] args) {
		ProductoDao p = new ProductoDao();
		
//		List<Marca> lm = new ArrayList<Marca>();
//		List<Producto> lp = new ArrayList<Producto>();
//		
//		lp= p.getAllProductos();
//		System.out.println("TEST Lista productos " + lp.size());
//		lp = p.getProductoById(1);
//		System.out.println("TEST Lista un producto " + lp.get(0).getNombre());
//		lm = p.getAllMarcas();
//		System.out.println("TEST Lista Marcas " + lp.size());
		Producto pr = new Producto();
		pr.setIdProd(8);
		p.deleteProductoById(pr);

	}

}
