package pe.nach.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.nach.domain.entity.articulos.Articulo;
import pe.nach.domain.repository.ArticuloRepository;

@Service
@RequiredArgsConstructor
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    @Transactional(readOnly = true)
    public Page<Articulo> findAll(Pageable pageable) {
        return articuloRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Articulo findById(Integer id) {
        return articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ArtÃ­culo no encontrado"));
    }

    @Transactional
    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Transactional
    public void delete(Integer id) {
        articuloRepository.deleteById(id);
    }
}