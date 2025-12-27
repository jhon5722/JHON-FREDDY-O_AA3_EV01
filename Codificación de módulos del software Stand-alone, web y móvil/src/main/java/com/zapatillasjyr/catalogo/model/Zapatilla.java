package com.zapatillasjyr.catalogo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa una zapatilla en el catálogo de la tienda.
 * Esta clase está mapeada a una tabla en la base de datos mediante JPA.
 * 
 * @author Manus AI
 */
@Entity
@Table(name = "zapatillas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zapatilla {

    /**
     * Identificador único de la zapatilla (Clave Primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre o modelo de la zapatilla.
     */
    private String nombre;

    /**
     * Marca del fabricante (ej. Nike, Adidas, Puma).
     */
    private String marca;

    /**
     * Talla de la zapatilla (formato numérico).
     */
    private Integer talla;

    /**
     * Precio de venta al público.
     */
    private Double precio;

    /**
     * Descripción detallada del producto.
     */
    private String descripcion;

    /**
     * Cantidad disponible en inventario.
     */
    private Integer stock;
}
