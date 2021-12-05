package RK.Jakarta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pesan")

public class PesanModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 5000)
    @Column(name = "pesan", nullable = false)
    private String pesan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_pengirim", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TokenModel pengirim;

//    @NotNull
//    @Column(name = "token_pengirim", nullable = false)
//    private String pengirim;

//    @NotNull
//    @Column(name = "token_penerima", nullable = false)
//    private String penerima;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_penerima", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TokenModel penerima;

}
