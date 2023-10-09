package apap.ti.silogistik2106701892.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.Gudang;
import apap.ti.silogistik2106701892.model.GudangBarang;

@Repository
public interface GudangBarangDb extends JpaRepository<GudangBarang, String>{
    List<GudangBarang> findByGudang(Gudang gudang);
    List<GudangBarang> findByBarang(Barang barang);
    GudangBarang findByGudangAndBarang(Gudang gudang, Barang barang);
}
