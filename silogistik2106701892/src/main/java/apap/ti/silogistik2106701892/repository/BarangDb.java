package apap.ti.silogistik2106701892.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106701892.model.Barang;
import java.util.List;


@Repository
public interface BarangDb extends JpaRepository<Barang, String>{
    List<Barang> findAllByOrderByMerkLowerAsc();
}
