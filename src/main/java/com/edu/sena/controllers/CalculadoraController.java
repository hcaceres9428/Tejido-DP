package com.edu.sena.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.sena.models.entity.Calculadora;

/*Se definen que esta clase es un controlador y que todas las solicitudes que 
comiencen con /calculadora serán manejadas por este controlador.
*/
@RestController
@RequestMapping("/calculadora")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
//Se establece un Endpoin
public class CalculadoraController {
	
	@PostMapping("/calcular")
    public Calculadora calcularPrecioVenta(@RequestBody Calculadora calculadora) {
		// Realizar cálculos con los datos recibidos en la instancia de Calculadora
		
		//Formula del calculo de tiempo por minutos y horas.
		int sumahoras = 5208 * calculadora.getHor();
		float vh = 5208;
        float vm = vh / 60;
        float vt = (vm * calculadora.getMin())+ sumahoras;
        
        //Formula costo de la lana usada
        float vgramo = (float) calculadora.getCostolanaC() / calculadora.getPesolanaC();
        float tgramo = calculadora.getPesolanaU() * vgramo;
        
        //Arreglo para guardar varios accesorios
        List<Float> accesorios = calculadora.getAccesorios();
        //variable accesoriosTotal
        float accesoriosTotal = 0;
        //Buche mejorado o for-each para recorrer el valor de cada accesorios y sumarlos
        for (float accesorio : accesorios) {
            accesoriosTotal += accesorio;
        }
        
        //costo promedio
        float promedio = tgramo + accesoriosTotal + vt;
        //tomando valor de Promedio para Promed
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
