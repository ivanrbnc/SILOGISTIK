package apap.ti.silogistik2106701892.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import apap.ti.silogistik2106701892.service.BarangService;
import apap.ti.silogistik2106701892.service.GudangService;
import apap.ti.silogistik2106701892.service.KaryawanService;
import apap.ti.silogistik2106701892.service.PermintaanPengirimanService;

import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    private GudangService gudangService;

    @Autowired
    private BarangService barangService;
    
    @Autowired
    private KaryawanService karyawanService;

    @Autowired
    private PermintaanPengirimanService permintaanPengirimanService;

    @GetMapping("/")
    public String home(Model model) {

        var gudangSize = gudangService.getAllGudang().size();
        var karyawanSize = karyawanService.getAllKaryawan().size();
        var barangSize = barangService.getAllBarang().size();
        var permintaanPengirimanSize = permintaanPengirimanService.getAllPermintaan().size();
        
        model.addAttribute("gudangSize", gudangSize);
        model.addAttribute("barangSize", barangSize);
        model.addAttribute("karyawanSize", karyawanSize);
        model.addAttribute("permintaanPengirimanSize", permintaanPengirimanSize);
        return "home";
    }
}
