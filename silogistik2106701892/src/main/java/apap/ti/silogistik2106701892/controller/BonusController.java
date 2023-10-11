package apap.ti.silogistik2106701892.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.PermintaanPengiriman;
import apap.ti.silogistik2106701892.model.PermintaanPengirimanBarang;
import apap.ti.silogistik2106701892.service.BarangService;
import apap.ti.silogistik2106701892.service.PermintaanPengirimanBarangService;
import apap.ti.silogistik2106701892.service.PermintaanPengirimanService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BonusController {

    @Autowired
    PermintaanPengirimanService permintaanPengirimanService;

    @Autowired
    PermintaanPengirimanBarangService permintaanPengirimanBarangService;

    @Autowired
    BarangService barangService;

    @GetMapping("filter-permintaan-pengiriman")
    public String filterPermintaan(
            @RequestParam(value = "startDate", required = false) String startDate, 
            @RequestParam(value = "endDate", required = false) String endDate, 
            @RequestParam(value = "sku", required = false) String sku, 
            Model model) {

        List<PermintaanPengiriman> listShowed = null; 

        if (sku != null && !startDate.isEmpty() && !endDate.isEmpty()) {

            // Convert the date input
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate temp = LocalDate.parse(startDate, formatter);
            LocalDateTime tempStartDate = temp.atStartOfDay();
            LocalDate temp2 = LocalDate.parse(endDate, formatter);
            LocalDateTime tempEndDate = temp2.atStartOfDay();
            
            Barang barang = barangService.getBarangById(sku);

            List<PermintaanPengiriman> listPermintaanPengiriman = permintaanPengirimanService.getBetweenTime(tempStartDate, tempEndDate);
            
            List<PermintaanPengirimanBarang> listPermintaanPengirimanBarang = permintaanPengirimanBarangService.getPermintaanPengirimanBarangByBarang(barang);
            
            listShowed = new ArrayList<>();

            // Trying to look for the intersection
            for (PermintaanPengiriman permintaanPengiriman : listPermintaanPengiriman) {
                for (PermintaanPengirimanBarang permintaanPengirimanBarang : listPermintaanPengirimanBarang) {
                    if (permintaanPengirimanBarang.getPermintaanPengiriman().equals(permintaanPengiriman)) {
                        listShowed.add(permintaanPengiriman);
                    }
                }
            }

            // Revert it back to null if there is no intersection
            if (listShowed.size() == 0) {
                listShowed = null;
            }
        }

        model.addAttribute("listBarang", barangService.getAllBarang());
        model.addAttribute("listShowed", listShowed);

        return "filter-permintaan";
    }
}
