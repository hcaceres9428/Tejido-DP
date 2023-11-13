package com.edu.sena.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.edu.sena.models.entity.Pedido;
import com.edu.sena.models.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class PedidoController {

	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/{id}")
	public Optional<Pedido> buscarPorId(@PathVariable Integer id){
		
		return pedidoService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Pedido> listarTodos(){
		return pedidoService.findAll();
	}

	@PostMapping
	public Pedido guardar(@RequestBody Pedido p) {
		return pedidoService.save(p);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		pedidoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Pedido actualizar(@RequestBody Pedido p, @PathVariable Integer id){
		Pedido pEnBD= pedidoService.findById(id).get();
		
		pEnBD.setCodigo(p.getCodigo());
		pEnBD.setNombre(p.getNombre());
		pEnBD.setValor(p.getValor());
		pEnBD.setDetalles(p.getDetalles());
		pEnBD.setfPed(p.getfPed());
		pEnBD.setfEnv(p.getfEnv());
		

		
		return pedidoService.save(pEnBD);
	}
}
