package apap.ti.silogistik2106701892.model;

import jakarta.persistence.*;
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
    private String merkLower;

    @NotNull
    @Column(name = "harga_barang", nullable = false)
    private Long hargaBarang;
}
