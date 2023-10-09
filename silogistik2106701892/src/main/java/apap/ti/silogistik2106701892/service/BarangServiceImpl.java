package apap.ti.silogistik2106701892.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.GudangBarang;
import apap.ti.silogistik2106701892.repository.BarangDb;

@Service
public class BarangServiceImpl implements BarangService{
    @Autowired
    BarangDb barangDb;

    @Autowired
    GudangBarangService gudangBarangService;

    @Override
    public void saveBarang(Barang barang) {
        barangDb.save(barang);
    }

    @Override
    public List<Barang> getAllBarang() {
        return barangDb.findAll();
    }

    @Override
    public Barang getBarangById(String sku) {
        for (Barang barang : getAllBarang()){
            if (barang.getSku().equals(sku)){
                return barang;
            }
        }
        return null;
    }

    @Override
    public int getTotalStok(Barang barang) {
        var totalStok = 0;
        var listGudangBarang = gudangBarangService.getAllByBarang(barang);

        for (GudangBarang gudangBarang : listGudangBarang) {
            totalStok += gudangBarang.getStok();
        }

        return totalStok;
    }

    @Override
    public void updateBarang(Barang barangFromDto) {
        Barang barang = getBarangById(barangFromDto.getSku());
        if (barang != null){
            barang.setMerk(barangFromDto.getMerk());
            barang.setHargaBarang(barangFromDto.getHargaBarang());
            barangDb.save(barang);
        }
    }

    @Override
    public Long getTotalHarga(String sku, Integer kuantitasPesanan) {
        Barang barang = getBarangById(sku);
        return barang.getHargaBarang() * kuantitasPesanan;
    }
}
