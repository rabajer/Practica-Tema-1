
package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Controlador REST para consultar los artículos del almacén.
 */
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    /**
     * Construye el controlador con el servicio de artículos.
     *
     * @param servicio servicio que gestiona las consultas de artículos
     */
    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * Devuelve todos los artículos del almacén.
     *
     * @return respuesta HTTP 200 con la lista de artículos
     */
    @GetMapping
    public ResponseEntity<List<Articulo>> listarTodos() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    /**
     * Devuelve los datos básicos de un artículo.
     *
     * @param id identificador del artículo que se desea consultar
     * @return respuesta HTTP 200 con los datos del artículo,
     *         o HTTP 404 si no existe
     */
    @GetMapping("/{id}/basico")
    public ResponseEntity<Map<String, Object>> buscarBasico(
            @PathVariable Integer id) {

        return servicio.buscarBasico(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
