
package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class DolgozoProgram {
    private static List<Dolgozo> dolgozok = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        Path path = Path.of("Dolgozok.txt");    
        String egySor = Files.readString(path);
        System.out.println("egySor = " + egySor);
        
        List<String> sorok = Files.readAllLines(path);
        sorok.remove(0);
        for (String sor : sorok) {
            System.out.println("sor = " + sor);
            String[] s = sor.split(";");
            String nev = s[0];
            try{
            int kor = Integer.parseInt(s[1]);
            int fizetes = Integer.parseInt(s[2]);
            Dolgozo dolgozo = new Dolgozo(nev,kor,fizetes);
            dolgozok.add(dolgozo);
            }catch (NumberFormatException e) {
                System.err.println("HIBÁS SOR ÁTUGORVA! Érvénytelen kor vagy fizetés adat:      " + sor );
            }
        }
        hanyanDolgoznak(); 
        atlagFizetes();
        legjobbanKereso();
        boolean vanFiatal = vanEFiatalabbMint(30);
        System.out.println("Van e fiatalabb dolgozó mint 30 év: " + (vanFiatal ? "igen" : "nem"));
        
    }
    private static void hanyanDolgoznak(){
            System.out.println("A dolgozok szama:" + dolgozok.size());
        }
    private static void atlagFizetes(){
        int osszesen = 0;
        for (int i = 0; i < dolgozok.size(); i++) {
            osszesen += dolgozok.get(i).getFizetes();
            
        }
        double atlag =  osszesen / dolgozok.size();
        System.out.println("Átlagfizetés: " + atlag + " Ft");

    }
    private static void legjobbanKereso() {
    Dolgozo legjobbanKereso = dolgozok.get(0);
    
    for (int i = 1; i < dolgozok.size(); i++) {
        if (dolgozok.get(i).getFizetes() > legjobbanKereso.getFizetes()) {
            legjobbanKereso= dolgozok.get(i);
        }
    }
    
    System.out.println("A legjobban kereső dolgozó: " + legjobbanKereso.getNev() + " (" + legjobbanKereso.getFizetes() + " Ft)");
}
    private static boolean vanEFiatalabbMint(int korlimit){
        for (int i = 0; i < dolgozok.size(); i++) {
            if(dolgozok.get(i).getKor() < korlimit){
                return true;
            }
            
        }
        return false;
    }
}
