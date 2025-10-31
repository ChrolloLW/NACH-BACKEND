package pe.nach.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.nach.domain.entity.documentos.DocVenta;
import pe.nach.domain.repository.DocVentaRepository;

import java.util.Optional;

@Service
public class DocVentaService {

    private final DocVentaRepository docVentaRepository;

    public DocVentaService(DocVentaRepository docVentaRepository) {
        this.docVentaRepository = docVentaRepository;
    }

    @Transactional
    public DocVenta save(DocVenta docVenta) {
        // rely on cascade settings for articulos/servicios
        return docVentaRepository.save(docVenta);
    }

    @Transactional(readOnly = true)
    public Optional<DocVenta> findById(Integer id) {
        return docVentaRepository.findById(id);
    }

}
