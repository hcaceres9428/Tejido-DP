package com.edu.sena.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.sena.models.entity.Calculadora;

@RestController
@RequestMapping("/calculadora")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CalculadoraController {

    @PostMapping("/calcular")
    public Calculadora calcularPrecioVenta(@RequestBody Calculadora calculadora) {
        double hours = calculadora.getHor();
        double minutes = calculadora.getMin();
        double costLana = calculadora.getCostolanaC();
        double purchasedLana = calculadora.getPesolanaC();
        double quantityLana = calculadora.getPesolanaU();
        List<Double> accesorios = calculadora.getAccesorios();
        double comision = calculadora.getComision();

        double priceHora = 8000;

        // Calculo de tiempo
        double priceTiempo = priceHora * hours + (priceHora / 60) * minutes;

        // Calculo del costo de la lana utilizada
        double priceGramoLana = costLana / purchasedLana;
        double totalLana = quantityLana * priceGramoLana;

        // Calculo del total de accesorios
        double totalAccesorios = 0;
        for (double accesorio : accesorios) {
            totalAccesorios += accesorio;
        }

        // Calculo del promedio
        double promedio = totalLana + totalAccesorios + priceTiempo;
        promedio = redondearSegunRegla(promedio);

        // Calculo de la comision
        double priceComision;
        if (comision >= 0 && comision <= 100) {
            priceComision = (comision / 100) * promedio;
        } else {
            // Manejo de error para comisión no válida
            priceComision = 0;
        }
        priceComision = redondearSegunRegla(priceComision);

        // Calculo del total
        double priceTotal = priceComision + promedio;
        priceTotal = redondearSegunRegla(priceTotal);

        // Asignacion de resultados a la instancia de Calculadora
        calculadora.setPromed(promedio);
        calculadora.setComision(priceComision);
        calculadora.setTotal(priceTotal);

        // Agregar campos para los resultados individuales si se requieren
        calculadora.setPriceTiempo(priceTiempo);
        calculadora.setTotalAccesorios(totalAccesorios);
        calculadora.setTotalLana(totalLana);

        return calculadora;
    }

    // Método para redondear según la regla especificada
    private static double redondearSegunRegla(double valor) {
        double parteDecimal = valor - (int) valor;
        if (parteDecimal >= 0.6) {
            return Math.ceil(valor);
        } else {
            return Math.floor(valor);
        }
    }
}
