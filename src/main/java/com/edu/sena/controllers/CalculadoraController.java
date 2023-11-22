package com.edu.sena.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.sena.models.entity.Calculadora;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@PostMapping("/calcular")
    public Calculadora calcularPrecioVenta(@RequestBody Calculadora calculadora) {
		// Realizar cálculos con los datos recibidos en la instancia de Calculadora

		float vh = 5208;
        float vm = vh / 60;
        float vt = vm * calculadora.getMin();

        float vgramo = (float) calculadora.getCostolanaC() / calculadora.getPesolanaC();
        float tgramo = calculadora.getPesolanaU() * vgramo;

        List<Float> accesorios = calculadora.getAccesorios();
        float accesoriosTotal = 0;

        for (float accesorio : accesorios) {
            accesoriosTotal += accesorio;
        }

        float promedio = tgramo + accesoriosTotal + vt;
        calculadora.setPromed(promedio);

        float comision = calculadora.getComision();
        float total;

        if (comision >= 0.00 && comision <= 0.99) {
            float pfinal = comision * promedio;
            calculadora.setComision(pfinal);
            total = pfinal + promedio;
        } else if (comision <= 100) {
            calculadora.setComision(promedio);
            total = promedio * 2;
        } else {
            // Manejo de error para comisión no válida
            // Aquí puedes ajustar el manejo del error según tu lógica
            calculadora.setComision(0);
            total = 0;
        }

        calculadora.setTotal(total);

        return calculadora;
    }
}
