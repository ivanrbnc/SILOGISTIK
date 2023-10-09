package apap.ti.silogistik2106701892.dto.request;

import java.util.List;

import apap.ti.silogistik2106701892.model.Karyawan;
import apap.ti.silogistik2106701892.model.PermintaanPengirimanBarang;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePermintaanPengirimanRequestDTO {
    @NotBlank(message = "Penerima tidak boleh kosong!")
    private String namaPenerima;

    @NotBlank(message = "Alamat tidak boleh kosong!")
    private String alamatPenerima;

    @NotNull(message = "Tanggal tidak boleh kosong!")
    private String tanggalPengirimanString;

    @NotNull(message = "Jenis tidak boleh kosong!")
    private Integer jenisLayanan;

    @Positive(message = "Biaya pengiriman harus positif!")
    private Integer biayaPengiriman;

    @NotNull(message = "Karyawan tidak boleh kosong!")
    private Karyawan karyawan;

    // Restriction isn't required as this request only used as container
    private List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang;
}
