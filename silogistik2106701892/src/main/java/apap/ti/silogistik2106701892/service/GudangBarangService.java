package apap.ti.silogistik2106701892.service;

import java.util.List;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.Gudang;
import apap.ti.silogistik2106701892.model.GudangBarang;

public interface GudangBarangService {
    void saveGudangBarang(GudangBarang gudangBarang, Gudang gudang, Barang barang, Integer stok);
    List<GudangBarang> getAllGudangBarang();
    List<GudangBarang> getAllByGudang(Gudang gudang);
    List<GudangBarang> getAllByBarang(Barang barang);
    void deleteGudangBarang(GudangBarang gudangBarang);
    GudangBarang getGudangBarangById(Long idGudangBarang);
    GudangBarang getGudangBarangByGudangAndBarang(Gudang gudang, Barang barang);
}
