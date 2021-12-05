package RK.Jakarta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import RK.Jakarta.model.PesanModel;
import RK.Jakarta.model.TokenModel;
import RK.Jakarta.repository.PesanDB;
import RK.Jakarta.repository.TokenDB;
import RK.Jakarta.service.PesanService;
import RK.Jakarta.service.TokenService;

@Controller
public class BaseController {

    @Autowired
    private TokenDB tokenDB;

    @Autowired
    private PesanDB pesanDB;

    @Qualifier("tokenServiceImpl")
    @Autowired
    private TokenService tokenService;

    @Autowired
    private PesanService pesanService;

    @GetMapping("/")
    private String home() {
        return "base";
    }

    @GetMapping("/user")
    private String homeSubmit(
            @RequestParam String token,
            Model model
    ) {
        model.addAttribute("token", token);
        model.addAttribute("tkn", tokenService.getTokenByToken(token));
        return "home";
    }

    @GetMapping("/{token}/kirim-pesan")
    private String kirimPesan(
            @PathVariable String token,
            Model model
    ) {
        model.addAttribute("pengirim", tokenService.getTokenByToken(token));
        model.addAttribute("listPenerima", tokenDB.findAll());
        model.addAttribute("pesan", new PesanModel());
        return "form-kirim-pesan";
    }

    @PostMapping("/{token}/kirim-pesan")
    private String kirimPesanSubmit(
            @PathVariable String token,
            @ModelAttribute PesanModel pesan,
            Model model
    ) {
        model.addAttribute("pengirim", tokenService.getTokenByToken(token));
        model.addAttribute("listPenerima", tokenDB.findAll());
        pesanService.kirimPesan(pesan);
        model.addAttribute("respon", "Pesan terkirim! Kirim lagi yuk");
        return "form-kirim-pesan";
    }

    @GetMapping("/{token}/viewall-pesan")
    private String viewAllPesan(
            @PathVariable String token,
            @ModelAttribute PesanModel pesan,
            Model model
    ) {
        model.addAttribute("penerima", tokenService.getTokenByToken(token));
        model.addAttribute("listPesan", pesanService.getListPesanByPenerima(tokenService.getTokenByToken(token)));
        return "viewall-pesan";
    }

    @GetMapping("/private-add-token/1958949438")
    private String addTokenForm(
            Model model
    ) {
        return "form-add-token";
    }

    @PostMapping("/private-add-token/1958949438")
    private String addTokenSubmit(
            @ModelAttribute TokenModel token,
            Model model
    ) {
        if (tokenService.addToken(token) != null) {
            tokenService.addToken((token));
            model.addAttribute("respon", "Token berhasil ditambahkan!");
            return "form-add-token";
        }
        model.addAttribute("respon", "Token gagal ditambahkan!");
        return "form-add-token";
    }
}

