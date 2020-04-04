package entity;

public class bossaatler {

    private int bossaatler_id;
    private int personel_id;
    private String pazartesi;
    private String sali;
    private String carsamba;
    private String persembe;
    private String cuma;
    private String cumartesi;
    private String pazar;

    public bossaatler(int bossaatler_id, int personel_id, String pazartesi, String sali, String carsamba, String persembe, String cuma, String cumartesi, String pazar) {
        this.bossaatler_id = bossaatler_id;
        this.personel_id = personel_id;
        this.pazartesi = pazartesi;
        this.sali = sali;
        this.carsamba = carsamba;
        this.persembe = persembe;
        this.cuma = cuma;
        this.cumartesi = cumartesi;
        this.pazar = pazar;
    }

    @Override
    public String toString() {
        return "bossaatler{" + "bossaatler_id=" + bossaatler_id + ", personel_id=" + personel_id + ", pazartesi=" + pazartesi + ", sali=" + sali + ", carsamba=" + carsamba + ", persembe=" + persembe + ", cuma=" + cuma + ", cumartesi=" + cumartesi + ", pazar=" + pazar + '}';
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

   

    public int getBossaatler_id() {
        return bossaatler_id;
    }

    public void setBossaatler_id(int bossaatler_id) {
        this.bossaatler_id = bossaatler_id;
    }

    public bossaatler() {
    }

    public String getPazartesi() {
        return pazartesi;
    }

    public void setPazartesi(String pazartesi) {
        this.pazartesi = pazartesi;
    }

    public String getSali() {
        return sali;
    }

    public void setSali(String sali) {
        this.sali = sali;
    }

    public String getCarsamba() {
        return carsamba;
    }

    public void setCarsamba(String carsamba) {
        this.carsamba = carsamba;
    }

    public String getPersembe() {
        return persembe;
    }

    public void setPersembe(String persembe) {
        this.persembe = persembe;
    }

    public String getCuma() {
        return cuma;
    }

    public void setCuma(String cuma) {
        this.cuma = cuma;
    }

    public String getCumartesi() {
        return cumartesi;
    }

    public void setCumartesi(String cumartesi) {
        this.cumartesi = cumartesi;
    }

    public String getPazar() {
        return pazar;
    }

    public void setPazar(String pazar) {
        this.pazar = pazar;
    }

}
