package apap.ti.silogistik2106701892.service;

import java.util.List;

import apap.ti.silogistik2106701892.model.Barang;

public interface BarangService {
    void saveBarang(Barang barang);
    List<Barang> getAllBarang();
    Barang getBarangById(String sku);
    int getTotalStok(Barang barang);
    Long getTotalHarga(String sku, Integer kuantitasPesanan);
    void updateBarang(Barang barangFromDto);
}
