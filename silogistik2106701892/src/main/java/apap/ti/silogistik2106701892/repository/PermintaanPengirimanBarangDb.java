package apap.ti.silogistik2106701892.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.PermintaanPengiriman;
import apap.ti.silogistik2106701892.model.PermintaanPengirimanBarang;
import java.util.List;


@Repository
public interface PermintaanPengirimanBarangDb extends JpaRepository<PermintaanPengirimanBarang, Long>{
    List<PermintaanPengirimanBarang> findByPermintaanPengiriman(PermintaanPengiriman permintaanPengiriman);
    List<PermintaanPengirimanBarang> findByBarang(Barang barang);
    PermintaanPengirimanBarang findByPermintaanPengirimanAndBarang(PermintaanPengiriman permintaanPengiriman, Barang barang);
}
