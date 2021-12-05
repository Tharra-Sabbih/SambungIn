package RK.Jakarta.service;

import RK.Jakarta.model.PesanModel;
import RK.Jakarta.model.TokenModel;

import java.util.List;

public interface PesanService {
    PesanModel getPesanById(Long id);
    PesanModel kirimPesan(PesanModel pesan);
    List<PesanModel> getListPesanByPenerima(TokenModel penerima);
}
