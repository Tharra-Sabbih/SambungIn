package RK.Jakarta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "token")
public class TokenModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "token", nullable = false)
    private String token;

    @NotNull
    @Size(max = 20)
    @Column(name = "nama", nullable = false)
    private String nama;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PesanModel> pesan;

}
