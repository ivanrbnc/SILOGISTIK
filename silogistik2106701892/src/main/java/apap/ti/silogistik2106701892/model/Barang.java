package apap.ti.silogistik2106701892.model;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barang")
public class Barang {
    @Id
    private String sku;

    @NotNull
    @Column(name = "tipe_barang", nullable = false)
    private Integer tipeBarang;

    @NotNull
    @Column(name = "merk", nullable = false)
    private String merk;

    @NotNull
    @Column(name = "harga_barang", nullable = false)
    private Long hargaBarang;

    public static Map<Integer, Integer> typeCounters = new HashMap<>();

    static {
        for (int i = 1; i <= 5; i++) {
            typeCounters.put(i, 0);
        }
    }

    public String generateSKU(Integer tipeBarang) {
        String[] types = {"ELEC", "CLOT", "FOOD", "COSM", "TOOL"};
        String type = types[tipeBarang - 1];
        String skuNumber = String.format("%03d", getAutoIncrementedNumber(tipeBarang));
        return type + skuNumber;
    }

    private int getAutoIncrementedNumber(Integer tipeBarang) {
        int nextNumber = typeCounters.get(tipeBarang);
        typeCounters.put(tipeBarang, nextNumber + 1);
        return nextNumber;
    } 
}
