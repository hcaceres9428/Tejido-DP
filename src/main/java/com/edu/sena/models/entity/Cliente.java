package com.edu.sena.models.entity;




import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Cliente")
public class Cliente {
	
	@Id
	@Column(name= "id_cliente")
	private int codigo;
	
	private String nombre;
	
	private Long telefono;
	
	private String direccion;
	
	private String ciudad;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "cliente_pedido",
            joinColumns = {@JoinColumn(name = "cliente")},
            inverseJoinColumns = {@JoinColumn(name = "pedido")}
    )
    private Set<Pedido> pedidos;
	

	public Cliente() {
		
	}


	public Cliente(int codigo, String nombre, Long telefono, String direccion, String ciudad, Set<Pedido> pedidos) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pedidos = pedidos;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public Set<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
}
