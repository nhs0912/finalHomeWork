public class Human {

    byte[] ssnArr = new byte[22];//22bytes ssn
    char[] nameArr = new char[100];//100bytes name
    char[] addressArr = new char[250];//500 byte address

    int ssn;

    Human() {

    }

    Human(int ssn, char[] name, char[] address) {
        this.ssn = ssn;
        this.nameArr = name;
        this.addressArr = address;
    }

    public byte[] getSsnArr() {
        return ssnArr;
    }

    public void setSsnArr(byte[] ssnArr) {
        this.ssnArr = ssnArr;
    }

    public char[] getNameArr() {
        return nameArr;
    }

    public void setNameArr(char[] nameArr) {
        this.nameArr = nameArr;
    }

    public char[] getAddressArr() {
        return addressArr;
    }

    public void setAddressArr(char[] addressArr) {
        this.addressArr = addressArr;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }


}
