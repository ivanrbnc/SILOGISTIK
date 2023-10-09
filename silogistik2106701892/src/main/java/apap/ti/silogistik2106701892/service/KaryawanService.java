package apap.ti.silogistik2106701892.service;

import java.util.List;

import apap.ti.silogistik2106701892.model.Karyawan;

public interface KaryawanService {
    void saveKaryawan(Karyawan karyawan);
    List<Karyawan> getAllKaryawan();
}
