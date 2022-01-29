package ma.cu.lalewicz.enigmaapi.model;

import ma.cu.lalewicz.enigmaapi.utils.Util;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// klasa abstrakcyjna będąca wzorem dwóch elementów bębenka odwracającego i przełącznicy kablowej
@Component
public abstract class SimpleSwitch {
    private int[] tableWire = new int[26];

    public SimpleSwitch() {
    }

    public SimpleSwitch(String switchSetting) {
        for (int i=0; i<26; i++) tableWire[i]=i;
        String[] switchSettingsTable = switchSetting.split(" ");
        for (String element:switchSettingsTable) {
            int index1 = element.codePointAt(1) - 65;
            int index2 = element.codePointAt(2) - 65;
            this.tableWire[index1] = index2;
            this.tableWire[index2] = index1;
        }
    }

    public int encode(int position){
            return this.tableWire[position];


    }

    @Override
    public String toString() {
        String temp="";
        for (int i=0; i<26; i++) {
            if (tableWire[i]!=i){
                temp=temp+"("+ Util.toChar(i)+Util.toChar(tableWire[i])+") ";
            }
        }
        return temp;
    }
}
