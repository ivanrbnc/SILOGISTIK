package apap.ti.silogistik2106701892.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBarangRequestDTO {
    @Pattern(regexp = "^[1-5]$", message = "Tipe barang tidak terdefinisi!")
    private Integer tipeBarang;

    @NotBlank(message = "Merk barang tidak boleh kosong!")
    private String merk;

    @Positive(message = "Harga barang tidak boleh negatif!")
    private Long hargaBarang;
}
