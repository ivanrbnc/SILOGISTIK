package apap.ti.silogistik2106701892.dto.request;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateGudangRequestDTO {
    @Size(max = 255, message = "Nama gudang terlalu panjang!")
    private String nama;

    @Size(max = 255, message = "Alamat gudang terlalu panjang!")
    private String alamatGudang;
}
