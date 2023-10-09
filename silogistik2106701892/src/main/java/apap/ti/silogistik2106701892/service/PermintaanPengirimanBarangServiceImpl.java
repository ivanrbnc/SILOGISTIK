package apap.ti.silogistik2106701892.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.PermintaanPengiriman;
import apap.ti.silogistik2106701892.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106701892.repository.PermintaanPengirimanBarangDb;

@Service
public class PermintaanPengirimanBarangServiceImpl implements PermintaanPengirimanBarangService {
    @Autowired
    PermintaanPengirimanBarangDb permintaanPengirimanBarangDb;

    @Autowired
    PermintaanPengirimanService permintaanPengirimanService;

    @Override
    public void savePermintaanPengirimanBarang(PermintaanPengirimanBarang permintaanPengirimanBarang) {
        permintaanPengirimanBarangDb.save(permintaanPengirimanBarang);
    }

    @Override
    public List<PermintaanPengirimanBarang> getAllPermintaan() {
        return permintaanPengirimanBarangDb.findAll();
    }

    @Override
    public List<PermintaanPengirimanBarang> getPermintaanPengirimanBarangByPermintaanPengiriman(PermintaanPengiriman permintaanPengiriman) {
        return permintaanPengirimanBarangDb.findByPermintaanPengiriman(permintaanPengiriman);
    }

    @Override
    public List<PermintaanPengirimanBarang> getPermintaanPengirimanBarangByBarang(Barang barang) {
        return permintaanPengirimanBarangDb.findByBarang(barang);
    }

}
