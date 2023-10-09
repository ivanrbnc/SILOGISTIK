package apap.ti.silogistik2106701892.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106701892.dto.request.CreatePermintaanPengirimanRequestDTO;
import apap.ti.silogistik2106701892.model.PermintaanPengiriman;

@Mapper(componentModel = "spring")
public interface PermintaanPengirimanMapper {
    PermintaanPengiriman createPermintaanPengirimanRequestDTOToPermintaanPengiriman(CreatePermintaanPengirimanRequestDTO createPermintaanPengirimanRequestDTO);
}
