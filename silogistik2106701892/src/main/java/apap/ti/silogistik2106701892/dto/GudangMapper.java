package apap.ti.silogistik2106701892.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106701892.dto.request.CreateGudangRequestDTO;
import apap.ti.silogistik2106701892.model.Gudang;

@Mapper(componentModel = "spring")
public interface GudangMapper {
    Gudang createGudangRequestDTOToGudang(CreateGudangRequestDTO createGudangRequestDTO);
}
