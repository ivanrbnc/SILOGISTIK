package apap.ti.silogistik2106701892.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106701892.dto.request.CreateGudangBarangRequestDTO;
import apap.ti.silogistik2106701892.model.GudangBarang;

@Mapper(componentModel = "spring")
public interface GudangBarangMapper {
    GudangBarang createGudangBarangRequestDTOToGudangBarang(CreateGudangBarangRequestDTO createGudangBarangRequestDTO);
    
}
