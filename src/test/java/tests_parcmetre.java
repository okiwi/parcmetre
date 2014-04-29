import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.fest.assertions.Assertions.*;

public class tests_parcmetre {

    private Parcmetre parcmetre;
    private Calendar jour_de_la_semaine;

    @Test
    public void test_1€_retourne_20_minutes(){
        int montant = 1;
        int temps = parcmetre.convertir_en_temps(montant, jour_de_la_semaine);
        int minutes = 20;
        assertThat(temps).isEqualTo(minutes);
    }

    @Test
    public void test_2€_retourne_60_minutes(){
        int montant = 2;
        int temps = parcmetre.convertir_en_temps(montant, jour_de_la_semaine);
        int minutes = 60;
        assertThat(temps).isEqualTo(minutes);
    }

    @Test
    public void test_3€_retourne_120_minutes(){
        int montant = 3;
        int temps = parcmetre.convertir_en_temps(montant, jour_de_la_semaine);
        int minutes = 120;
        assertThat(temps).isEqualTo(minutes);
    }

    @Test
    public void le_dimanche_est_gratuit(){
        int montant = 1;
        Calendar dimanche = Calendar.getInstance();
        dimanche.set(2014, 3, 27);

        int temps = parcmetre.convertir_en_temps(montant, dimanche);
        int minutes = 0;
        assertThat(temps).isEqualTo(0);
    }

    @Before
    public void setUp(){
        parcmetre = new Parcmetre();
        jour_de_la_semaine = Calendar.getInstance();
        jour_de_la_semaine.set(2014, 3, 28);
    }
}


class Parcmetre {
    public Parcmetre() {
        montantsTemps.put(1,20);
        montantsTemps.put(2,60);
        montantsTemps.put(3, 120);
    }
    private HashMap<Integer, Integer> montantsTemps = new HashMap<Integer, Integer>();

    public int convertir_en_temps(int montant, Calendar date) {

        if (Calendar.SUNDAY == date.get(Calendar.DAY_OF_WEEK)){
            return 0;
        }
        return (montantsTemps.get(montant));
    }
}