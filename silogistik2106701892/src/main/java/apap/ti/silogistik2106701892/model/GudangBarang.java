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
@Table(name = "gudang_barang")
public class GudangBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGudangBarang;

    @ManyToOne
    @JoinColumn(name = "id_gudang", referencedColumnName = "idGudang", unique = false)
    private Gudang gudang;

    @ManyToOne
    @JoinColumn(name = "sku_barang", referencedColumnName = "sku", unique = false)
    private Barang barang;

    @NotNull
    @Column(name = "stok", nullable = false)
    private Integer stok = 0;
}
