package apap.ti.silogistik2106701892.dto.request;

import java.util.List;

import apap.ti.silogistik2106701892.model.GudangBarang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateGudangBarangRequestDTO {
    // Restriction isn't required as this request only used as container and already restricted in controller
    private Long idGudang;
    private List<GudangBarang> listGudangBarang;
}
