package apap.ti.silogistik2106701892.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106701892.model.Gudang;

@Repository
public interface GudangDb extends JpaRepository<Gudang, Long>{
    
}
