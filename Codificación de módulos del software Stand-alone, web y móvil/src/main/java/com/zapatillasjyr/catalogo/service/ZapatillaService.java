package com.zapatillasjyr.catalogo.service;

import com.zapatillasjyr.catalogo.model.Zapatilla;
import com.zapatillasjyr.catalogo.repository.ZapatillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que contiene la lógica de negocio para la gestión de zapatillas.
 * Actúa como intermediario entre el controlador y el repositorio.
 * 
 * @author Manus AI
 */
@Service
public class ZapatillaService {

    private final ZapatillaRepository repository;

    /**
     * Constructor para la inyección de dependencias del repositorio.
     * 
     * @param repository El repositorio de zapatillas.
     */
    @Autowired
    public ZapatillaService(ZapatillaRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todas las zapatillas del catálogo.
     * 
     * @return Lista completa de zapatillas.
     */
    public List<Zapatilla> listarTodas() {
        return repository.findAll();
    }

    /**
     * Busca una zapatilla por su identificador único.
     * 
     * @param id El ID de la zapatilla.
     * @return Un Optional que contiene la zapatilla si se encuentra.
     */
    public Optional<Zapatilla> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Filtra las zapatillas por marca y talla.
     * 
     * @param marca Marca de la zapatilla.
     * @param talla Talla de la zapatilla.
     * @return Lista de zapatillas filtradas.
     */
    public List<Zapatilla> filtrar(String marca, Integer talla) {
        if (marca != null && talla != null) {
            return repository.findByMarcaAndTalla(marca, talla);
        } else if (marca != null) {
            return repository.findByMarca(marca);
        }
        return repository.findAll();
    }

    /**
     * Guarda una nueva zapatilla o actualiza una existente.
     * 
     * @param zapatilla El objeto zapatilla a guardar.
     * @return La zapatilla guardada con su ID generado.
     */
    public Zapatilla guardar(Zapatilla zapatilla) {
        return repository.save(zapatilla);
    }

    /**
     * Elimina una zapatilla del catálogo por su ID.
     * 
     * @param id El ID de la zapatilla a eliminar.
     */
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
