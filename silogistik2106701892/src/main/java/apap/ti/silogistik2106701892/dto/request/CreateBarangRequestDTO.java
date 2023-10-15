package apap.ti.silogistik2106701892.dto.request;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBarangRequestDTO {
    @Max(value = 5, message = "Tipe barang tidak boleh lebih dari 5")
    @Min(value = 1, message = "Tipe barang tidak boleh kurang dari 1")
    private Integer tipeBarang;

    @NotBlank(message = "Merk barang tidak boleh kosong!")
    private String merk;

    @Positive(message = "Harga barang tidak boleh negatif!")
    private Long hargaBarang;
}
