package ma.cu.lalewicz.enigmaapi.controller;

import ma.cu.lalewicz.enigmaapi.model.EnigmaSettings;
import ma.cu.lalewicz.enigmaapi.service.EnigmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnigmaController {

    @Autowired
    private EnigmaService enigmaService;

    @GetMapping("/getset")
    private EnigmaSettings getSettings(){
        return enigmaService.getEnigmaSet();
    }

    @GetMapping("/encrypt/{sign}")
    private EnigmaSettings encrypt(@PathVariable char sign){
        return enigmaService.encrypt(sign);

    }
}
