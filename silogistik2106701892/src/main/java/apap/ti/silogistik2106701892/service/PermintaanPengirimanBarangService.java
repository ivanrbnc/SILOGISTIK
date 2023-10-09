package apap.ti.silogistik2106701892.service;

import java.util.List;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.PermintaanPengiriman;
import apap.ti.silogistik2106701892.model.PermintaanPengirimanBarang;

public interface PermintaanPengirimanBarangService {
    void savePermintaanPengirimanBarang(PermintaanPengirimanBarang permintaanPengirimanBarang);
    List<PermintaanPengirimanBarang> getAllPermintaan();
    List<PermintaanPengirimanBarang> getPermintaanPengirimanBarangByPermintaanPengiriman(PermintaanPengiriman permintaanPengiriman);
    List<PermintaanPengirimanBarang> getPermintaanPengirimanBarangByBarang(Barang barang);
}