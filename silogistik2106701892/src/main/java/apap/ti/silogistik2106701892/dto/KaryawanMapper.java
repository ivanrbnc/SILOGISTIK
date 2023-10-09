package apap.ti.silogistik2106701892.dto;

import org.mapstruct.Mapper;

import apap.ti.silogistik2106701892.dto.request.CreateKaryawanRequestDTO;
import apap.ti.silogistik2106701892.model.Karyawan;

@Mapper(componentModel = "spring")
public interface KaryawanMapper {
    Karyawan createKaryawanRequestDTOToKaryawan(CreateKaryawanRequestDTO createKaryawanRequestDTO);
}
