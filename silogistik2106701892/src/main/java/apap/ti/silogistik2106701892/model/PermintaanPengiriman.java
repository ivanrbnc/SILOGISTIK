package apap.ti.silogistik2106701892.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Table(name = "permintaan_pengiriman")
// https://www.baeldung.com/spring-jpa-soft-delete
@SQLDelete(sql = "UPDATE permintaan_pengiriman SET is_cancelled = true WHERE id_permintaan_pengiriman=?")
@Where(clause = "is_cancelled=false")
public class PermintaanPengiriman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermintaanPengiriman;

    @NotNull
    @Column(name = "nomor_pengiriman", nullable = false)
    private String nomorPengiriman;

    @NotNull
    @Column(name = "is_cancelled", nullable = false)
    private Boolean isCancelled = false;

    @NotNull
    @Column(name = "nama_penerima", nullable = false)
    private String namaPenerima;

    @NotNull
    @Column(name = "alamat_penerima", nullable = false)
    private String alamatPenerima;

    @NotNull
    @Column(name = "tanggal_pengiriman", nullable = false) 
    private LocalDate tanggalPengiriman;
    private String tanggalPengirimanString;

    @NotNull
    @Column(name = "biaya_pengiriman", nullable = false)
    private Integer biayaPengiriman;

    @NotNull
    @Column(name = "jenis_layanan", nullable = false)
    private Integer jenisLayanan;

    @NotNull
    @Column(name = "waktu_permintaan", nullable = false)
    private LocalDateTime waktuPermintaan;
    private String waktuPermintaanString;

    @ManyToOne
    @JoinColumn(name = "id_karyawan", referencedColumnName = "idKaryawan")
    private Karyawan karyawan;
}
