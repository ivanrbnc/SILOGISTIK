package apap.ti.silogistik2106701892;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

import apap.ti.silogistik2106701892.dto.GudangMapper;
import apap.ti.silogistik2106701892.dto.KaryawanMapper;
import apap.ti.silogistik2106701892.dto.request.CreateGudangRequestDTO;
import apap.ti.silogistik2106701892.dto.request.CreateKaryawanRequestDTO;
import apap.ti.silogistik2106701892.service.GudangService;
import apap.ti.silogistik2106701892.service.KaryawanService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;

import java.util.Locale;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Silogistik2106701892Application {

	public static void main(String[] args) {
		SpringApplication.run(Silogistik2106701892Application.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run (GudangService gudangService, KaryawanService karyawanService, GudangMapper gudangMapper, KaryawanMapper karyawanMapper){
		return args -> {
			// var faker = new Faker(new Locale("in-ID"));

			// for (int i = 0; i < 3; i++) {
			// 	var gudangDTO = new CreateGudangRequestDTO();
			// 	gudangDTO.setNama(faker.company().name());
			// 	gudangDTO.setAlamatGudang(faker.address().fullAddress());

			// 	var gudang = gudangMapper.createGudangRequestDTOToGudang(gudangDTO);
			// 	gudangService.saveGudang(gudang);
			// }

			// for (int i = 0; i < 10; i++) {
			// 	var karyawanDTO = new CreateKaryawanRequestDTO();

			// 	karyawanDTO.setNama(faker.name().fullName());
			// 	karyawanDTO.setJenisKelamin(new Random().nextInt(2) + 1);
			// 	karyawanDTO.setTanggalLahir(faker.date().birthday(19, 25));

			// 	var karyawan = karyawanMapper.createKaryawanRequestDTOToKaryawan(karyawanDTO);
			// 	karyawanService.saveKaryawan(karyawan);
			// }
		};
	}
}
