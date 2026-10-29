package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Servicio encargado de gestionar las operaciones de los artículos.
 */
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    /**
     * Crea el servicio de artículos.
     *
     * @param repositorio repositorio para acceder a los artículos.
     */
    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Obtiene todos los artículos almacenados en la base de datos.
     *
     * @return una lista con todos los artículos.
     */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    /**
     * Busca un artículo por su identificador y devuelve sus datos básicos.
     *
     * @param id identificador del artículo.
     * @return un mapa con los datos del artículo o vacío si no existe.
     */
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        // TODO (#n de la incidencia): buscar el artículo por id y devolver un mapa con id, nombre y stock.
        // Si el stock es 0, añadir "mensaje": "Agotado". Si no existe, Optional.empty().
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}