package com.hellin.almacen.controller;

import java.util.List;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.hellin.almacen.model.Articulo;

/**
 * Controlador REST para consultar los artículos de la papelería.
 * Proporciona endpoints para obtener el catálogo y los datos básicos
 * de un artículo.
 */

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
 * Obtiene todos los artículos del catálogo.
 *
 * @return respuesta HTTP 200 con la lista completa de artículos.
 */
@GetMapping
public ResponseEntity<List<Articulo>> listarTodos() {
    return ResponseEntity.ok(servicio.listarTodos());
}
    // TODO (#n de la incidencia): GET /api/articulos/{id}/basico -> datos básicos (200) o 404 si no existe
}
