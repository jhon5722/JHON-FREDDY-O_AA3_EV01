package com.zapatillasjyr.catalogo.controller;

import com.zapatillasjyr.catalogo.model.Zapatilla;
import com.zapatillasjyr.catalogo.service.ZapatillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints para la gestión del catálogo de zapatillas.
 * Permite realizar operaciones CRUD y filtrado a través de peticiones HTTP.
 * 
 * @author Manus AI
 */
@RestController
@RequestMapping("/api/zapatillas")
public class ZapatillaController {

    private final ZapatillaService service;

    /**
     * Constructor para la inyección del servicio.
     * 
     * @param service El servicio de zapatillas.
     */
    @Autowired
    public ZapatillaController(ZapatillaService service) {
        this.service = service;
    }

    /**
     * Endpoint para obtener todas las zapatillas o filtrarlas.
     * Ejemplo: GET /api/zapatillas?marca=Nike&talla=42
     * 
     * @param marca (Opcional) Marca para filtrar.
     * @param talla (Opcional) Talla para filtrar.
     * @return Lista de zapatillas y estado HTTP 200.
     */
    @GetMapping
    public ResponseEntity<List<Zapatilla>> listar(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) Integer talla) {
        List<Zapatilla> zapatillas = service.filtrar(marca, talla);
        return new ResponseEntity<>(zapatillas, HttpStatus.OK);
    }

    /**
     * Endpoint para obtener el detalle de una zapatilla específica.
     * 
     * @param id ID de la zapatilla.
     * @return La zapatilla si existe, o estado 404 si no.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Zapatilla> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(zapatilla -> new ResponseEntity<>(zapatilla, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint para agregar una nueva zapatilla al catálogo.
     * 
     * @param zapatilla Objeto zapatilla enviado en el cuerpo de la petición.
     * @return La zapatilla creada y estado 201.
     */
    @PostMapping
    public ResponseEntity<Zapatilla> crear(@RequestBody Zapatilla zapatilla) {
        Zapatilla nuevaZapatilla = service.guardar(zapatilla);
        return new ResponseEntity<>(nuevaZapatilla, HttpStatus.CREATED);
    }

    /**
     * Endpoint para actualizar la información de una zapatilla.
     * 
     * @param id ID de la zapatilla a actualizar.
     * @param zapatilla Datos actualizados.
     * @return La zapatilla actualizada o estado 404.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Zapatilla> actualizar(@PathVariable Long id, @RequestBody Zapatilla zapatilla) {
        return service.buscarPorId(id)
                .map(existente -> {
                    zapatilla.setId(id);
                    Zapatilla actualizada = service.guardar(zapatilla);
                    return new ResponseEntity<>(actualizada, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint para eliminar una zapatilla del catálogo.
     * 
     * @param id ID de la zapatilla a eliminar.
     * @return Estado 204 (No Content) tras la eliminación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
