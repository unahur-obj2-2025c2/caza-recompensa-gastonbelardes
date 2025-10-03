package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cazadores.CazadorRural;
import ar.edu.unahur.obj2.Cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.Cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.Profugos;
import ar.edu.unahur.obj2.Zona.Zona;

public class CazadorTest {

    @Test
    public void testCapturaCazadorSigiloso() {
        // Crear prófugos
        IProfugo profugo1 = new Profugos(40, 5, false); // habilidad < 50 -> capturable
        IProfugo profugo2 = new Profugos(60, 3, false); // habilidad > 50 -> intimidable

        // Zona con los prófugos
        List<IProfugo> lista = new ArrayList<>();
        lista.add(profugo1);
        lista.add(profugo2);
        Zona zona = new Zona("Ciudad", lista);

        // Crear cazador sigiloso con experiencia suficiente
        CazadorSigiloso cazador = new CazadorSigiloso();
        cazador.setExperiencia(10); // mayor que la inocencia de ambos

        // Ejecutar captura
        cazador.capturar(zona);

        // Verificar capturas e intimidaciones
        assertTrue(cazador.getCapturados().contains(profugo1));
        assertFalse(cazador.getCapturados().contains(profugo2));

        assertEquals(1, zona.getProfugos().size());
        assertTrue(zona.getProfugos().contains(profugo2));
    }

    @Test
    public void testCapturaCazadorRural() {
        IProfugo profugo1 = new Profugos(30, 10, true);  // nervioso -> capturable
        IProfugo profugo2 = new Profugos(50, 5, false);  // no nervioso -> intimidable

        List<IProfugo> lista = new ArrayList<>();
        lista.add(profugo1);
        lista.add(profugo2);
        Zona zona = new Zona("Campo", lista);

        CazadorRural cazador = new CazadorRural();
        cazador.setExperiencia(20);

        cazador.capturar(zona);

        assertTrue(cazador.getCapturados().contains(profugo1));
        assertFalse(cazador.getCapturados().contains(profugo2));

        assertEquals(1, zona.getProfugos().size());
        assertTrue(zona.getProfugos().contains(profugo2));
        assertTrue(profugo2.esNervioso()); // intimidado se vuelve nervioso
    }

    @Test
    public void testCapturaCazadorUrbano() {
        IProfugo profugo1 = new Profugos(20, 15, false); // no nervioso -> capturable
        IProfugo profugo2 = new Profugos(40, 5, true);   // nervioso -> intimidable

        List<IProfugo> lista = new ArrayList<>();
        lista.add(profugo1);
        lista.add(profugo2);
        Zona zona = new Zona("Ciudad", lista);

        CazadorUrbano cazador = new CazadorUrbano();
        cazador.setExperiencia(25);

        cazador.capturar(zona);

        assertTrue(cazador.getCapturados().contains(profugo1));
        assertFalse(cazador.getCapturados().contains(profugo2));

        assertEquals(1, zona.getProfugos().size());
        assertTrue(zona.getProfugos().contains(profugo2));
        assertFalse(profugo2.esNervioso()); // intimidado deja de estar nervioso
    }
}

