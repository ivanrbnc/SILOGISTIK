package apap.ti.silogistik2106701892.service;

import java.time.LocalDateTime;
import java.util.List;

import apap.ti.silogistik2106701892.model.PermintaanPengiriman;

public interface PermintaanPengirimanService {
    void savePermintaanPengiriman(PermintaanPengiriman permintaanPengiriman);
    List<PermintaanPengiriman> getAllPermintaan();
    List<PermintaanPengiriman> getAllPermintaanSortByWaktuPermintaan();
    PermintaanPengiriman getPermintaanById(Long idPermintaanPengiriman);
    void deletePermintaan(PermintaanPengiriman permintaanPengiriman);
    List<PermintaanPengiriman> getBetweenTime(LocalDateTime startDate, LocalDateTime endDate);
}
