package apap.ti.silogistik2106701892.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.ti.silogistik2106701892.model.PermintaanPengiriman;
import apap.ti.silogistik2106701892.repository.PermintaanPengirimanDb;

@Service
public class PermintaanPengirimanServiceImpl implements PermintaanPengirimanService {
    @Autowired
    PermintaanPengirimanDb permintaanPengirimanDb;

    @Override
    public void savePermintaanPengiriman(PermintaanPengiriman permintaanPengiriman) {
        permintaanPengirimanDb.save(permintaanPengiriman);
    }

    @Override
    public List<PermintaanPengiriman> getAllPermintaan() {
        return permintaanPengirimanDb.findAll();
    }

    @Override
    public PermintaanPengiriman getPermintaanById(Long idPermintaanPengiriman) {
        for (PermintaanPengiriman permintaan : getAllPermintaan()){
            if (permintaan.getIdPermintaanPengiriman().equals(idPermintaanPengiriman)){
                return permintaan;
            }
        }
        return null;
    }

    @Override
    public void deletePermintaan(PermintaanPengiriman permintaanPengiriman) {
        permintaanPengirimanDb.delete(permintaanPengiriman);
    }

    @Override
    public List<PermintaanPengiriman> getBetweenTime(LocalDateTime startDate, LocalDateTime endDate) {
        return permintaanPengirimanDb.findByWaktuPermintaanBetween(startDate, endDate);
    }
}
