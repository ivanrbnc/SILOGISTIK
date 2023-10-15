package apap.ti.silogistik2106701892.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateKaryawanRequestDTO {
    @NotBlank(message="Nama tidak boleh kosong!")
    private String nama;

    @Max(value = 2, message = "Karyawan hanya berkelamin laki atau perempuan!")
    @Min(value = 1, message = "Karyawan hanya berkelamin laki atau perempuan!")
    private Integer jenisKelamin;

    @NotNull(message="Tanggal lahir tidak boleh kosong!")
    private Date tanggalLahir;
}
