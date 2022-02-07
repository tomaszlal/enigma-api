package ma.cu.lalewicz.enigmaapi.controller;

import ma.cu.lalewicz.enigmaapi.model.EnigmaSettings;
import ma.cu.lalewicz.enigmaapi.service.EnigmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnigmaController {

    @Autowired
    private EnigmaService enigmaService;

    @GetMapping("/getset")
    private EnigmaSettings getSettings() {
        return enigmaService.getEnigmaSet();
    }

    @GetMapping("/encrypt/{sign}")
    private EnigmaSettings encrypt(@PathVariable char sign) {
        return enigmaService.encrypt(sign);
    }

    @GetMapping("/{location}/{position}")
    private EnigmaSettings setRotorPos(@PathVariable String location, @PathVariable char position) {
        return enigmaService.setRotorPosition(location, position);
    }

    @GetMapping("/rotor-block/{rotorLocation}/{nameRotor}")
    private EnigmaSettings setRotorsName (@PathVariable String rotorLocation, @PathVariable String nameRotor){
        return enigmaService.setRotorNumber(rotorLocation,nameRotor);
    }

    @GetMapping("/switch-board")
    private EnigmaSettings setSwitchBoardWirings(@RequestParam String wirings){
        return enigmaService.setSwitchBoard(wirings);
    }
}
