
package entity;

public class brans {
    private int brans_id;
    private String brans;

    public brans() {
    }

    public brans(int brans_id, String brans) {
        this.brans_id = brans_id;
        this.brans = brans;
    }

    @Override
    public String toString() {
        return "brans{" + "brans_id=" + brans_id + ", brans=" + brans + '}';
    }
    
    
    
    public int getBrans_id() {
        return brans_id;
    }

    public void setBrans_id(int brans_id) {
        this.brans_id = brans_id;
    }

    public String getBrans() {
        return brans;
    }

    public void setBrans(String brans) {
        this.brans = brans;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.brans_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final brans other = (brans) obj;
        if (this.brans_id != other.brans_id) {
            return false;
        }
        return true;
    }
    
}
