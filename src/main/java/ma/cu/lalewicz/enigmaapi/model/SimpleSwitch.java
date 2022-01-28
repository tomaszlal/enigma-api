package ma.cu.lalewicz.enigmaapi.model;

public abstract class SimpleSwitch {
    private int[] tableWire = new int[26];

    public SimpleSwitch(String switchSetting) {
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

}
