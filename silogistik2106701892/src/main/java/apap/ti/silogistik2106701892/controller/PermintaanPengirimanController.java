package apap.ti.silogistik2106701892.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import apap.ti.silogistik2106701892.dto.PermintaanPengirimanMapper;
import apap.ti.silogistik2106701892.dto.request.CreatePermintaanPengirimanRequestDTO;
import apap.ti.silogistik2106701892.model.PermintaanPengiriman;
import apap.ti.silogistik2106701892.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106701892.service.BarangService;
import apap.ti.silogistik2106701892.service.KaryawanService;
import apap.ti.silogistik2106701892.service.PermintaanPengirimanBarangService;
import apap.ti.silogistik2106701892.service.PermintaanPengirimanService;
import jakarta.validation.Valid;

@Controller
public class PermintaanPengirimanController {

    @Autowired
    private PermintaanPengirimanMapper permintaanPengirimanMapper;

    @Autowired
    BarangService barangService;

    @Autowired
    KaryawanService karyawanService;

    @Autowired
    PermintaanPengirimanService permintaanPengirimanService;

    @Autowired
    PermintaanPengirimanBarangService permintaanPengirimanBarangService;
    
    @GetMapping("permintaan-pengiriman")
    public String listPermintaan(Model model) {
        var listPermintaan = permintaanPengirimanService.getAllPermintaan();

        model.addAttribute("listPermintaan", listPermintaan);
        return "viewall-permintaan";
    }

    @GetMapping("permintaan-pengiriman/{idPermintaanPengiriman}")
    public String detailPermintaan(@PathVariable("idPermintaanPengiriman") Long idPermintaanPengiriman, Model model) {
        var permintaanPengiriman = permintaanPengirimanService.getPermintaanById(idPermintaanPengiriman);
        var permintaanPengirimanBarang = permintaanPengirimanBarangService.getPermintaanPengirimanBarangByPermintaanPengiriman(permintaanPengiriman);

        String[] types = {"Same Day", "Kilat", "Reguler", "Hemat"};
        String type = types[permintaanPengiriman.getJenisLayanan() - 1];

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime createdTime = permintaanPengiriman.getWaktuPermintaan();

        Duration duration = Duration.between(currentDateTime, createdTime);

        if (duration.toHours() < 24) {
            model.addAttribute("canCancel", true);
        } else {
            model.addAttribute("canCancel", false);
        }
        
        model.addAttribute("permintaanPengiriman", permintaanPengiriman);
        model.addAttribute("permintaanPengirimanBarang", permintaanPengirimanBarang);
        model.addAttribute("barangService", barangService);
        model.addAttribute("type", type);
        return "view-permintaan";
    }

    @GetMapping("permintaan-pengiriman/tambah")
    public String formAddPermintaan(Model model) {
        var listKaryawan = karyawanService.getAllKaryawan();

        var permintaanPengirimanBarangDTO = new CreatePermintaanPengirimanRequestDTO();

        model.addAttribute("listKaryawan", listKaryawan);
        model.addAttribute("permintaanPengirimanBarangDTO", permintaanPengirimanBarangDTO);

        return "form-create-request";
    }

    @PostMapping(value = "permintaan-pengiriman/tambah", params={"addRow"})
    public String addRowPermintaanPengirimanBarang(@ModelAttribute CreatePermintaanPengirimanRequestDTO createPermintaanPengirimanRequestDTO, Model model) {
        if (createPermintaanPengirimanRequestDTO.getListPermintaanPengirimanBarang() == null || createPermintaanPengirimanRequestDTO.getListPermintaanPengirimanBarang().size() == 0) {
            createPermintaanPengirimanRequestDTO.setListPermintaanPengirimanBarang(new ArrayList<>());
        }

        var listKaryawan = karyawanService.getAllKaryawan();

        createPermintaanPengirimanRequestDTO.getListPermintaanPengirimanBarang().add(new PermintaanPengirimanBarang());

        model.addAttribute("listKaryawan", listKaryawan);
        model.addAttribute("listBarangExist", barangService.getAllBarang());
        model.addAttribute("permintaanPengirimanBarangDTO", createPermintaanPengirimanRequestDTO);
        return "form-create-request";
    }

    @PostMapping("permintaan-pengiriman/tambah")
    public String addPermintaan(@Valid @ModelAttribute CreatePermintaanPengirimanRequestDTO createPermintaanPengirimanRequestDTO, BindingResult bindingResult, Model model) {
        // https://www.baeldung.com/spring-mvc-custom-validator
        if (bindingResult.hasErrors()) {
            var errorMessage = bindingResult.getFieldError().getDefaultMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "error-view"; 
        }

        Integer totalKuantitasPesanan = 0;

        for (PermintaanPengirimanBarang permintaan : createPermintaanPengirimanRequestDTO.getListPermintaanPengirimanBarang()) {
            totalKuantitasPesanan += permintaan.getKuantitasPesanan();
        }

        PermintaanPengiriman permintaanPengiriman = permintaanPengirimanMapper.createPermintaanPengirimanRequestDTOToPermintaanPengiriman(createPermintaanPengirimanRequestDTO);
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        permintaanPengiriman.setWaktuPermintaan(currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        permintaanPengiriman.setWaktuPermintaanString(currentDateTime.format(formatter));

        String request = "REQ";
        String quantity = String.format("%02d", totalKuantitasPesanan > 99 ? totalKuantitasPesanan % 100 : totalKuantitasPesanan);

        String[] types = {"SAM", "KIL", "REG", "HEM"};
        String type = types[createPermintaanPengirimanRequestDTO.getJenisLayanan() - 1];

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        permintaanPengiriman.setNomorPengiriman(request + quantity + type + currentDateTime.format(formatter2));

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tempTime = LocalDate.parse(createPermintaanPengirimanRequestDTO.getTanggalPengirimanString(), formatter3);
        permintaanPengiriman.setTanggalPengiriman(tempTime);

        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        permintaanPengiriman.setTanggalPengirimanString(tempTime.format(formatter4));
        
        permintaanPengirimanService.savePermintaanPengiriman(permintaanPengiriman);        

        for (PermintaanPengirimanBarang permintaan : createPermintaanPengirimanRequestDTO.getListPermintaanPengirimanBarang()) {
            permintaan.setPermintaanPengiriman(permintaanPengiriman);
            permintaanPengirimanBarangService.savePermintaanPengirimanBarang(permintaan);
        }

        model.addAttribute("nomorPengiriman", permintaanPengiriman.getNomorPengiriman());
        return "success-add-permintaan";
    }

    @GetMapping("permintaan-pengiriman/{idPermintaanPengiriman}/cancel")
    public String cancelPermintaan(@PathVariable("idPermintaanPengiriman") Long idPermintaanPengiriman, Model model) {
        var permintaanPengiriman = permintaanPengirimanService.getPermintaanById(idPermintaanPengiriman);
        permintaanPengirimanService.deletePermintaan(permintaanPengiriman);
        
        model.addAttribute("nomorPengiriman", permintaanPengiriman.getNomorPengiriman());
        return "success-delete-permintaan";
    }
}
