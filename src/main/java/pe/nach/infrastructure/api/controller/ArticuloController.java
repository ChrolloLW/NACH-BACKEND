package pe.nach.infrastructure.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.nach.domain.entity.articulos.Articulo;
import pe.nach.domain.service.ArticuloService;
import pe.nach.infrastructure.api.dto.ArticuloDTO;

@RestController
@RequestMapping("/api/articulos")
@RequiredArgsConstructor
public class ArticuloController {
    private final ArticuloService articuloService;

    @GetMapping
    public ResponseEntity<Page<Articulo>> findAll(Pageable pageable) {
        return ResponseEntity.ok(articuloService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(articuloService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Articulo> create(@RequestBody ArticuloDTO articuloDTO) {
        Articulo articulo = mapToEntity(articuloDTO);
        return ResponseEntity.ok(articuloService.save(articulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> update(@PathVariable Integer id, @RequestBody ArticuloDTO articuloDTO) {
        Articulo existingArticulo = articuloService.findById(id);
        updateEntityFromDTO(existingArticulo, articuloDTO);
        return ResponseEntity.ok(articuloService.save(existingArticulo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        articuloService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Articulo mapToEntity(ArticuloDTO dto) {
        return Articulo.builder()
                .id(dto.getId())
                .descripcion(dto.getDescripcion())
                .codigoFabricacion(dto.getCodigoFabricacion())
                .estadoRegistro(dto.getEstadoRegistro())
                .flagSerie(dto.getFlagSerie())
                .idCompania(dto.getIdCompania())
                .codigoFox(dto.getCodigoFox())
                .codigoMarcaFox(dto.getCodigoMarcaFox())
                .codigoSublineaFox(dto.getCodigoSublineaFox())
                .codigoProducto(dto.getCodigoProducto())
                .idEquivalencia(dto.getIdEquivalencia())
                .aplicacion(dto.getAplicacion())
                .comentario(dto.getComentario())
                .tieneIgv(dto.getTieneIgv())
                .tieneIsc(dto.getTieneIsc())
                .build();
    }

    private void updateEntityFromDTO(Articulo entity, ArticuloDTO dto) {
        entity.setDescripcion(dto.getDescripcion());
        entity.setCodigoFabricacion(dto.getCodigoFabricacion());
        entity.setEstadoRegistro(dto.getEstadoRegistro());
        entity.setFlagSerie(dto.getFlagSerie());
        entity.setIdCompania(dto.getIdCompania());
        entity.setCodigoFox(dto.getCodigoFox());
        entity.setCodigoMarcaFox(dto.getCodigoMarcaFox());
        entity.setCodigoSublineaFox(dto.getCodigoSublineaFox());
        entity.setCodigoProducto(dto.getCodigoProducto());
        entity.setIdEquivalencia(dto.getIdEquivalencia());
        entity.setAplicacion(dto.getAplicacion());
        entity.setComentario(dto.getComentario());
        entity.setTieneIgv(dto.getTieneIgv());
        entity.setTieneIsc(dto.getTieneIsc());
    }
}