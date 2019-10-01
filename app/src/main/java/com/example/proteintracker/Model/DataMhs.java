package com.example.proteintracker.Model;

public class DataMhs {
    private String nama;
    private String nim;
    private String gender;
    private String citacita;
    private String motohidup;

    public DataMhs(String nama, String nim, String gender, String citacita, String motohidup) {
        this.nama = nama;
        this.nim = nim;
        this.gender = gender;
        this.citacita = citacita;
        this.motohidup = motohidup;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitacita() {
        return citacita;
    }

    public void setCitacita(String citacita) {
        this.citacita = citacita;
    }

    public String getMotohidup() {
        return motohidup;
    }

    public void setMotohidup(String motohidup) {
        this.motohidup = motohidup;
    }
}
