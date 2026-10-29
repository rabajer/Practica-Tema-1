
package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Servicio encargado de gestionar las consultas de artículos.
 */
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    /**
     * Construye el servicio con el repositorio de artículos.
     *
     * @param repositorio repositorio que permite consultar los artículos
     */
    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Obtiene todos los artículos almacenados.
     *
     * @return lista de todos los artículos
     */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    /**
     * Busca los datos básicos de un artículo.
     *
     * @param id identificador del artículo
     * @return datos básicos del artículo, si existe
     */
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        // Pendiente de implementar.
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
