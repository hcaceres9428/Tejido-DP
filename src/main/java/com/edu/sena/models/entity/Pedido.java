package com.edu.sena.models.entity;


import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name= "Pedido")
public class Pedido {

	@Id
	@Column(name= "id_pedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String nombre;
	
	private double valor;
	
	private String detalles;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "fecha_pedido")
	private Date fPed;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "fecha_entrega")
	private Date fEnv;
	
	
	@ManyToMany(mappedBy = "pedidos")
    private Set<Cliente> clientes;
	
	public Pedido() {
		
	}

	public Pedido(int codigo, String nombre, double valor, String detalles, Date fPed, Date fEnv,
			Set<Cliente> clientes) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.detalles = detalles;
		this.fPed = fPed;
		this.fEnv = fEnv;
		this.clientes = clientes;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Date getfPed() {
		return fPed;
	}

	public void setfPed(Date fPed) {
		this.fPed = fPed;
	}

	public Date getfEnv() {
		return fEnv;
	}

	public void setfEnv(Date fEnv) {
		this.fEnv = fEnv;
	}


	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
	
}
