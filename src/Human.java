public class Human {

    byte[] ssnArr = new byte[22];//22bytes ssn
    char[] nameArr = new char[100];//100bytes name
    char[] addressArr = new char[1000];//500 byte address

    int ssn;
    String name;
    String address;

    Human() {

    }

    Human(int ssn, String name, String address) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
    }





}
