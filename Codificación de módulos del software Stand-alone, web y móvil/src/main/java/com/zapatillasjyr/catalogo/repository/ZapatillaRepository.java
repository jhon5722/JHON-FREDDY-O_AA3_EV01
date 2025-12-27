package com.zapatillasjyr.catalogo.repository;

import com.zapatillasjyr.catalogo.model.Zapatilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz de repositorio para la entidad Zapatilla.
 * Proporciona métodos CRUD estándar gracias a la herencia de JpaRepository.
 * 
 * 
 */
@Repository
public interface ZapatillaRepository extends JpaRepository<Zapatilla, Long> {

    /**
     * Busca zapatillas filtrando por marca y talla.
     * 
     * @param marca La marca a buscar.
     * @param talla La talla a buscar.
     * @return Una lista de zapatillas que coinciden con los criterios.
     */
    List<Zapatilla> findByMarcaAndTalla(String marca, Integer talla);
    
    /**
     * Busca zapatillas por marca.
     * 
     * @param marca La marca a buscar.
     * @return Una lista de zapatillas de la marca especificada.
     */
    List<Zapatilla> findByMarca(String marca);
}
