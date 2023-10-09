package apap.ti.silogistik2106701892.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.ti.silogistik2106701892.dto.request.CreateGudangBarangRequestDTO;
import apap.ti.silogistik2106701892.model.Barang;
import apap.ti.silogistik2106701892.model.Gudang;
import apap.ti.silogistik2106701892.model.GudangBarang;
import apap.ti.silogistik2106701892.service.BarangService;
import apap.ti.silogistik2106701892.service.GudangBarangService;
import apap.ti.silogistik2106701892.service.GudangService;
import jakarta.validation.Valid;

@Controller
public class GudangController {

    @Autowired
    private GudangService gudangService;

    @Autowired
    private BarangService barangService;

    @Autowired
    private GudangBarangService gudangBarangService;

    @GetMapping("gudang")
    public String listGudang(Model model) {
        var listGudang = gudangService.getAllGudang();
        model.addAttribute("listGudang", listGudang);
        return "viewall-gudang";
    }

    @GetMapping("gudang/{idGudang}")
    public String detailGudang(@PathVariable("idGudang") Long idGudang, Model model) {
        var gudang = gudangService.getGudangById(idGudang);
        var listGudangBarang = gudangBarangService.getAllByGudang(gudang);
        model.addAttribute("gudang", gudang);
        model.addAttribute("listGudangBarang", listGudangBarang);
        return "view-gudang";
    }

    @GetMapping("gudang/{idGudang}/restock-barang")
    public String formRestockBarang(@PathVariable("idGudang") Long idGudang, Model model) {
        var gudang = gudangService.getGudangById(idGudang);

        var gudangBarangDTO = new CreateGudangBarangRequestDTO();
        gudangBarangDTO.setIdGudang(idGudang);

        model.addAttribute("idGudang", idGudang);
        model.addAttribute("gudang", gudang);
        model.addAttribute("gudangBarangDTO", gudangBarangDTO);

        return "form-restock-barang";
    }

    @PostMapping(value = "gudang/{idGudang}/restock-barang", params={"addRow"})
    public String addRowBarangGudang(@PathVariable("idGudang") Long idGudang, @ModelAttribute CreateGudangBarangRequestDTO createGudangBarangRequestDTO, Model model) {
        if (createGudangBarangRequestDTO.getListGudangBarang() == null || createGudangBarangRequestDTO.getListGudangBarang().size() == 0) {
            createGudangBarangRequestDTO.setListGudangBarang(new ArrayList<>());
        }

        createGudangBarangRequestDTO.getListGudangBarang().add(new GudangBarang());
        createGudangBarangRequestDTO.setIdGudang(idGudang);

        model.addAttribute("idGudang", idGudang);
        model.addAttribute("gudang", gudangService.getGudangById(idGudang));
        model.addAttribute("listBarangExist", barangService.getAllBarang());
        model.addAttribute("gudangBarangDTO", createGudangBarangRequestDTO);
        return "form-restock-barang";
    }

    @PostMapping("gudang/{idGudang}/restock-barang")
    public String restockBarang(@Valid @ModelAttribute CreateGudangBarangRequestDTO createGudangBarangRequestDTO, BindingResult bindingResult, Model model) {
        // https://www.baeldung.com/spring-mvc-custom-validator
        if (bindingResult.hasErrors()) {
            var errorMessage = bindingResult.getFieldError().getDefaultMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "error-view"; 
        }

        for (GudangBarang gudangBarang : createGudangBarangRequestDTO.getListGudangBarang()) {
            Gudang gudang = gudangService.getGudangById(createGudangBarangRequestDTO.getIdGudang());
            Barang barang = gudangBarang.getBarang();
            Integer stok = gudangBarang.getStok();

            gudangBarang.setGudang(gudang);
            gudangBarangService.saveGudangBarang(gudangBarang, gudang, barang, stok);
        }

        return "success";
    }

    @GetMapping("gudang/cari-barang")
    public String findRelatedGudang(@RequestParam(value = "sku", required = false) String sku, Model model) {
        
        List<Barang> listBarang = barangService.getAllBarang();
        List<GudangBarang> listGudangBarang = null;

        if (sku != null && !sku.isEmpty()) {
            Barang barang = barangService.getBarangById(sku);
            listGudangBarang = gudangBarangService.getAllByBarang(barang);
        }

        model.addAttribute("listBarang", listBarang);
        model.addAttribute("listGudangBarang", listGudangBarang);
        return "viewsearch-barang";
    }
}
