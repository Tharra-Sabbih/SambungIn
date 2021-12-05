package RK.Jakarta.service;

import RK.Jakarta.repository.PesanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import RK.Jakarta.model.PesanModel;
import RK.Jakarta.model.TokenModel;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PesanServiceImpl implements PesanService {

    @Autowired
    private PesanDB pesanDB;

    @Autowired
    private TokenService tokenService;

    @Override
    public PesanModel getPesanById(Long id) {
        Optional<PesanModel> psn = pesanDB.findById(id);
        if (psn.isPresent()) return psn.get();
        return null;
    }

    @Override
    public PesanModel kirimPesan(PesanModel pesan) {
        return pesanDB.save(pesan);
    }

    @Override
    public List<PesanModel> getListPesanByPenerima(TokenModel penerima) {
        List<PesanModel> listPesan = new ArrayList<>();
        for (PesanModel psn : pesanDB.findAll()) {
            if (psn.getPenerima().equals(penerima)) {
                listPesan.add(psn);
            }
        }
        return listPesan;
    }

}
