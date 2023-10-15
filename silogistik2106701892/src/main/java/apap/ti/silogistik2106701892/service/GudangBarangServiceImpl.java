package apap.ti.silogistik2106701892.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.Gudang;
import apap.ti.silogistik2106701892.model.GudangBarang;
import apap.ti.silogistik2106701892.repository.GudangBarangDb;

@Service
public class GudangBarangServiceImpl implements GudangBarangService{
    @Autowired
    GudangBarangDb gudangBarangDb;

    @Override
    public void saveGudangBarang(GudangBarang gudangBarang, Gudang gudang, Barang barang, Integer stok) {
        GudangBarang gudangBarangExisted = gudangBarangDb.findByGudangAndBarang(gudang, barang);

        if (!(gudangBarangExisted == null)) {
            gudangBarangExisted.setStok(gudangBarangExisted.getStok() + stok);
            gudangBarangDb.save(gudangBarangExisted);
        } else {
            gudangBarangDb.save(gudangBarang);
        }        
    }

    @Override
    public List<GudangBarang> getAllGudangBarang() {
        return gudangBarangDb.findAll();
    }

    @Override
    public List<GudangBarang> getAllByGudang(Gudang gudang) {
        return gudangBarangDb.findByGudang(gudang);
    }

    @Override
    public List<GudangBarang> getAllByBarang(Barang barang) {
        return gudangBarangDb.findByBarang(barang);
    }

    @Override
    public void deleteGudangBarang(GudangBarang gudangBarang) {
        gudangBarangDb.delete(gudangBarang);
    }

    @Override
    public GudangBarang getGudangBarangById(Long idGudangBarang) {
        for (GudangBarang gudangBarang : getAllGudangBarang()){
            if (gudangBarang.getIdGudangBarang().equals(idGudangBarang)){
                return gudangBarang;
            }
        }
        return null;
    }

    @Override
    public GudangBarang getGudangBarangByGudangAndBarang(Gudang gudang, Barang barang) {
        return gudangBarangDb.findByGudangAndBarang(gudang, barang);
    }
}
