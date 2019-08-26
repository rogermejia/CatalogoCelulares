package com.empresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.dao.ProductoDao;
import com.empresa.entidades.Marca;
import com.empresa.entidades.Producto;


@Controller
@RequestMapping("/")
public class Controlador {
	
	List<Producto> listProd = new ArrayList<>();
	List<Marca> listMarca = new ArrayList<>();
	ProductoDao daoProd = new ProductoDao();
	
	@RequestMapping(method = RequestMethod.GET)
	public String datos(Model model) {
		listProd = daoProd.getAllProductos();
		model.addAttribute("productos", listProd);
//		String color;
//		List<String> listcolor = new ArrayList<>();
//		for(Producto pro: listProd) {
//			if(pro.getStock() != 0) {
//				color = "background-color:#F04B4B";
//				
//			}else {
//				color = "background-color:#FFFFFF";
//				
//			}
//			listcolor.add(color);
//			model.addAttribute("color", listcolor);
//		}
		
		return "productos";
	}
	
	@RequestMapping(value="/updateDato/{idProd}", method = RequestMethod.GET)
	public String updateProd(@RequestParam("idProd") Integer id, Model model) {
		
		listProd = daoProd.getProductoById(id);
		Producto prod = new Producto();
		prod.setIdProd(listProd.get(0).getIdProd());
		prod.setNombre(listProd.get(0).getNombre());
		prod.setId_marca(listProd.get(0).getId_marca());
		prod.setPrecio(listProd.get(0).getPrecio());
		prod.setDescrip(listProd.get(0).getDescrip());
		prod.setStock(listProd.get(0).getStock());
		
		model.addAttribute("productos", prod);

		return "redirect:/updateprod";
	}
	
	@RequestMapping(value="/deleteDato/{idProd}", method = RequestMethod.GET)
	public String deleteProd(@RequestParam("idProd") Integer id, Model model) {
		Producto p = new Producto();
		p.setIdProd(id);
		daoProd.deleteProductoById(p);

		return "redirect:/";
	}
	
	@RequestMapping(value="/addProd",method = RequestMethod.POST)    
    public String save(@ModelAttribute("datos") Producto datos, Model model){    
		daoProd.guardarProducto(datos);
		System.out.println("Non sonno nemenno arrivato qui");
		listProd = daoProd.getAllProductos();
		model.addAttribute("productos", listProd);
        return "redirect:/";
	}
	
	
	@RequestMapping(value="/redir/Marcas", method = RequestMethod.GET)
	public String irAMarcas(Model model) {
		listMarca = daoProd.getAllMarcas();
		model.addAttribute("marcas", listMarca);

		return "redirect:/marcas";
	}
}
