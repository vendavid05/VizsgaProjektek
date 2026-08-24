
package Main;

import java.util.Objects;


public class Dolgozo {
    private String nev;
    private int kor;
    private int fizetes;

    public Dolgozo(String nev, int kor, int fizetes) {
        this.nev = nev;
        this.kor = kor;
        this.fizetes = fizetes;
    }

    public String getNev() {
        return nev;
    }

    public int getKor() {
        return kor;
    }

    public int getFizetes() {
        return fizetes;
    }

    @Override
    public String toString() {
        return "Dolgozo{" + "nev=" + nev + ", kor=" + kor + ", fizetes=" + fizetes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nev);
        hash = 83 * hash + this.kor;
        hash = 83 * hash + this.fizetes;
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
        final Dolgozo other = (Dolgozo) obj;
        if (this.kor != other.kor) {
            return false;
        }
        if (this.fizetes != other.fizetes) {
            return false;
        }
        return Objects.equals(this.nev, other.nev);
    }
    

    
    


    
    
    

}
