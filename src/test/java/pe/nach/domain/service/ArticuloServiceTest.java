package pe.nach.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pe.nach.domain.entity.articulos.Articulos.Articulo;
import pe.nach.domain.repository.ArticuloRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ArticuloServiceTest {

    @Mock
    private ArticuloRepository articuloRepository;

    @InjectMocks
    private ArticuloService articuloService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_ShouldReturnPageOfArticulos() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        List<Articulo> articulos = List.of(
            Articulo.builder()
                .id(1)
                .descripcion("Test Articulo")
                .codigoFabricacion("TEST001")
                .build()
        );
        Page<Articulo> page = new PageImpl<>(articulos);
        when(articuloRepository.findAll(pageable)).thenReturn(page);

        // Act
        Page<Articulo> result = articuloService.findAll(pageable);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(articuloRepository).findAll(pageable);
    }

    @Test
    void findById_ShouldReturnArticulo_WhenExists() {
        // Arrange
        Integer id = 1;
        Articulo articulo = Articulo.builder()
            .id(id)
            .descripcion("Test Articulo")
            .codigoFabricacion("TEST001")
            .build();
        when(articuloRepository.findById(id)).thenReturn(Optional.of(articulo));

        // Act
        Articulo result = articuloService.findById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(articuloRepository).findById(id);
    }

    @Test
    void save_ShouldReturnSavedArticulo() {
        // Arrange
        Articulo articulo = Articulo.builder()
            .descripcion("Test Articulo")
            .codigoFabricacion("TEST001")
            .build();
        when(articuloRepository.save(any(Articulo.class))).thenReturn(articulo);

        // Act
        Articulo result = articuloService.save(articulo);

        // Assert
        assertNotNull(result);
        assertEquals(articulo.getDescripcion(), result.getDescripcion());
        verify(articuloRepository).save(articulo);
    }

    @Test
    void delete_ShouldCallRepository() {
        // Arrange
        Integer id = 1;

        // Act
        articuloService.delete(id);

        // Assert
        verify(articuloRepository).deleteById(id);
    }
}