package apap.ti.silogistik2106701892.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106701892.dto.request.CreateBarangRequestDTO;
import apap.ti.silogistik2106701892.dto.request.UpdateBarangRequestDTO;
import apap.ti.silogistik2106701892.model.Barang;

@Mapper(componentModel = "spring")
public interface BarangMapper {
    Barang createBarangRequestDTOToBarang(CreateBarangRequestDTO createBarangRequestDTO);
    Barang updateBarangRequestDTOToBarang(UpdateBarangRequestDTO updateBarangRequestDTO);
    UpdateBarangRequestDTO barangToUpdateBarangRequestDTO (Barang barang);
}
