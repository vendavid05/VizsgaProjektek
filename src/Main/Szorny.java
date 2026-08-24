
package Main;


import java.util.Objects;

public class Szorny {
    
    private static final String Nincs_nev = "Ismeretlen";
    private static final int Nincs_elet  = 10;
    private static final int Nincs_sebzes = 4;
    
    private Tipusok tipus;
    private String nev;
    private int elet;
    private int sebzes;

    public Szorny(Tipusok tipus, String nev, int elet,int sebzes) {
        setNev(nev);
        this.tipus = tipus;
        setElet(elet);
        setSebzes(sebzes);
        
    }

    public Szorny() {
        this(Tipusok.ZOMBI,Nincs_nev,Nincs_elet,Nincs_sebzes);
    }

    public int getSebzes() {
        return sebzes;
    }

    public Tipusok getTipus() {
        return tipus;
    }

    public String getNev() {
        return nev;
    }

    public int getElet() {
        return elet;
    }
    public void setElet(int elet) {
        this.elet = elet < 0 ? Nincs_elet : elet;
    }
    public void setSebzes(int sebzes) {
        this.sebzes = sebzes < 1 ? Nincs_sebzes : sebzes;
    }
    public void setNev(String nev) {
        this.nev = (nev == null || nev.length() < 3) ? Nincs_nev : nev;
    }
    
    public boolean ErosebbMint(Szorny masik){
        if(this.elet > masik.elet){
            return true;
        }else{
            return false;   
        }
    }

    @Override
    public String toString() {
        return "Szorny{" + "tipus=" + tipus + ", nev=" + nev + ", elet=" + elet + ", sebzes=" + sebzes + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tipus);
        hash = 59 * hash + Objects.hashCode(this.nev);
        hash = 59 * hash + this.elet;
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
        final Szorny other = (Szorny) obj;
        if (this.elet != other.elet) {
            return false;
        }
        if (!Objects.equals(this.nev, other.nev)) {
            return false;
        }
        return this.tipus == other.tipus;
    }

    
    
    
    
}
