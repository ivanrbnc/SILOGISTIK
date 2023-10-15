package apap.ti.silogistik2106701892.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import apap.ti.silogistik2106701892.dto.BarangMapper;
import apap.ti.silogistik2106701892.dto.request.CreateBarangRequestDTO;
import apap.ti.silogistik2106701892.dto.request.UpdateBarangRequestDTO;
import apap.ti.silogistik2106701892.service.BarangService;
import apap.ti.silogistik2106701892.service.GudangBarangService;
import jakarta.validation.Valid;

@Controller
public class BarangController {

    @Autowired
    private BarangMapper barangMapper;

    @Autowired
    private BarangService barangService;

    @Autowired
    private GudangBarangService gudangBarangService;

    @GetMapping("barang")
    public String listBarang(Model model) {
        var listBarang = barangService.getAllBarang();

        model.addAttribute("listBarang", listBarang);
        model.addAttribute("barangService", barangService);
        return "viewall-barang";
    }

    @GetMapping("barang/{idBarang}")
    public String detailBarang(@PathVariable("idBarang") String idBarang, Model model) {
        var barang = barangService.getBarangById(idBarang);
        var listGudangBarang = gudangBarangService.getAllByBarang(barang);

        String[] typesString = {
            "Produk Elektronik", 
            "Pakaian & Aksesoris", 
            "Makanan & Minuman", 
            "Kosmetik", 
            "Perlengkapan Rumah"
        };
        
        String type = typesString[barang.getTipeBarang() - 1];

        var totalStok = barangService.getTotalStok(barang);

        model.addAttribute("barang", barang);
        model.addAttribute("type", type);
        model.addAttribute("totalStok", totalStok);
        model.addAttribute("listGudangBarang", listGudangBarang);
        return "view-barang";
    }

    @GetMapping("barang/tambah")
    public String formAddBarang(Model model) {
        var barangDTO = new CreateBarangRequestDTO();

        model.addAttribute("barangDTO", barangDTO);
        return "form-create-barang";
    }

    @PostMapping("barang/tambah")
    public String addBarang(@Valid @ModelAttribute CreateBarangRequestDTO createBarangRequestDTO, BindingResult bindingResult, Model model) {
        // https://www.baeldung.com/spring-mvc-custom-validator
        if (bindingResult.hasErrors()) {
            var errorMessage = bindingResult.getFieldError().getDefaultMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "error-view"; 
        }
        
        var barang = barangMapper.createBarangRequestDTOToBarang(createBarangRequestDTO);

        String[] types = {"ELEC", "CLOT", "FOOD", "COSM", "TOOL"};
        String type = types[createBarangRequestDTO.getTipeBarang() - 1];
        String skuNumber = String.format("%03d", barangService.getAllBarang().size() + 1);
        barang.setSku(type + skuNumber);

        barangService.saveBarang(barang);

        model.addAttribute("sku", barang.getSku());
        return "success-add-barang";
    }

    @GetMapping("barang/{idBarang}/ubah")
    public String formUpdateBarang(@PathVariable("idBarang") String idBarang, Model model) {
        var barang = barangService.getBarangById(idBarang);
    
        String[] types = {
            "Produk Elektronik", 
            "Pakaian & Aksesoris", 
            "Makanan & Minuman", 
            "Kosmetik", 
            "Perlengkapan Rumah"
        };
        
        String type = types[barang.getTipeBarang() - 1];

        var barangDTO = barangMapper.barangToUpdateBarangRequestDTO(barang);
    
        model.addAttribute("barangDTO", barangDTO);
        model.addAttribute("type", type);
    
        return "form-update-barang";
    }

    @PostMapping(value="barang/{idBarang}/ubah")
    public String updateBarang(@Valid @ModelAttribute UpdateBarangRequestDTO barangDTO, BindingResult bindingResult, Model model) {
        // https://www.baeldung.com/spring-mvc-custom-validator
        if (bindingResult.hasErrors()) {
            var errorMessage = bindingResult.getFieldError().getDefaultMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "error-view"; 
        }

        var barangFromDto = barangMapper.updateBarangRequestDTOToBarang(barangDTO);
        barangService.updateBarang(barangFromDto);

        model.addAttribute("sku", barangFromDto.getSku());

        return "success-update-barang";
    }
}
