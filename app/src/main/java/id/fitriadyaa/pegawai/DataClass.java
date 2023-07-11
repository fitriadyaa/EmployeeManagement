package id.fitriadyaa.pegawai;

public class DataClass {
    private String dataName;
    private String dataNip;
    private String dataSalary;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDataName() {
        return dataName;
    }
    public String getDataNip() {
        return dataNip;
    }
    public String getDataSalary() {
        return dataSalary;
    }
    public String getDataImage() {
        return dataImage;
    }
    public DataClass(String dataName, String dataNip, String dataSalary, String dataImage) {
        this.dataName = dataName;
        this.dataNip = dataNip;
        this.dataSalary = dataSalary;
        this.dataImage = dataImage;
    }
    public DataClass(){
    }
}
