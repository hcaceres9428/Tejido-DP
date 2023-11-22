package com.edu.sena.models.entity;

import java.util.List;

public class Calculadora {
	private int hor;
	private int min;
	private int pesolanaC;
	private int costolanaC;
	private int pesolanaU;
	
	private List<Float> accesorios;
	
	private float promed;
	private float comision;
	private float total;
	public Calculadora(int hor, int min, int pesolanaC, int costolanaC, int pesolanaU, List<Float> accesorios,
			float promed, float comision, float total) {
		super();
		this.hor = hor;
		this.min = min;
		this.pesolanaC = pesolanaC;
		this.costolanaC = costolanaC;
		this.pesolanaU = pesolanaU;
		this.accesorios = accesorios;
		this.promed = promed;
		this.comision = comision;
		this.total = total;
	}
	public int getHor() {
		return hor;
	}
	public void setHor(int hor) {
		this.hor = hor;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getPesolanaC() {
		return pesolanaC;
	}
	public void setPesolanaC(int pesolanaC) {
		this.pesolanaC = pesolanaC;
	}
	public int getCostolanaC() {
		return costolanaC;
	}
	public void setCostolanaC(int costolanaC) {
		this.costolanaC = costolanaC;
	}
	public int getPesolanaU() {
		return pesolanaU;
	}
	public void setPesolanaU(int pesolanaU) {
		this.pesolanaU = pesolanaU;
	}
	public List<Float> getAccesorios() {
		return accesorios;
	}
	public void setAccesorios(List<Float> accesorios) {
		this.accesorios = accesorios;
	}
	public float getPromed() {
		return promed;
	}
	public void setPromed(float promed) {
		this.promed = promed;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
}