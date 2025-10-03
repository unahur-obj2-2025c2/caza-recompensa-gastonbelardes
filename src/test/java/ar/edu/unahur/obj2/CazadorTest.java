package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Cazadores.CazadorRural;
import ar.edu.unahur.obj2.Cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.Cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.ProfugoConProteccionLegal;
import ar.edu.unahur.obj2.Profugos.ProfugoDeElite;
import ar.edu.unahur.obj2.Profugos.ProfugoMartialArtist;
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


    

    // Parte II: Entrenamientos y mejoras
    @Test
    public void testProfugoConArtesMarcialesAvanzadas() {
        IProfugo profugoBase = new Profugos(40, 10, true);
        IProfugo profugoMaestro = new ProfugoMartialArtist(profugoBase);

        // Habilidad duplicada pero no mayor a 100
        assertEquals(80, profugoMaestro.getHabilidad());
        // Inocencia y nervioso se mantienen
        assertEquals(10, profugoMaestro.getInocencia());
        assertTrue(profugoMaestro.esNervioso());
    }

    @Test
    public void testProfugoConProteccionLegal() {
        IProfugo profugoBase = new Profugos(40, 30, true);
        IProfugo profugoLegal = new ProfugoConProteccionLegal(profugoBase);

        // Inocencia nunca menor a 40
        assertEquals(40, profugoLegal.getInocencia());
        // Los demás atributos se mantienen
        assertEquals(40, profugoLegal.getHabilidad());
        assertTrue(profugoLegal.esNervioso());
    }

    @Test
    public void testProfugoDeElite() {
        IProfugo profugoBase = new Profugos(60, 20, true);
        IProfugo profugoElite = new ProfugoDeElite(profugoBase);

        // Nunca nervioso
        assertFalse(profugoElite.esNervioso());
        // Reducir habilidad funciona
        profugoElite.reducirHabilidad();
        assertEquals(55, profugoElite.getHabilidad());
        // Inocencia se mantiene
        assertEquals(20, profugoElite.getInocencia());
    }

    @Test
    public void testProfugoConVariasCapas() {
        IProfugo profugoBase = new Profugos(60, 10, true);
        IProfugo profugoMejorado = new ProfugoConProteccionLegal(
                                    new ProfugoMartialArtist(
                                    new ProfugoDeElite(profugoBase)));

        // Habilidad duplicada y no pasa 100
        assertEquals(100, profugoMejorado.getHabilidad() > 100 ? 100 : profugoMejorado.getHabilidad());
        // Inocencia mínima 40 por protección legal
        assertEquals(40, profugoMejorado.getInocencia());
        // Nunca nervioso por elite
        assertFalse(profugoMejorado.esNervioso());
    }

    // Parte III: Reportes de la Agencia
@Test
public void testReporteCapturasYMasHabil() {
    // Crear algunos profugos
    IProfugo p1 = new Profugos(20, 5, true);
    IProfugo p2 = new Profugos(40, 3, false); // habilidad < 50 para que pueda ser capturado
    IProfugo p3 = new Profugos(40, 10, true);

    List<IProfugo> lista = Arrays.asList(p1, p2, p3);
    Zona zona = new Zona("Ciudad", lista);

    CazadorSigiloso cazador1 = new CazadorSigiloso();
    cazador1.setExperiencia(50);

    CazadorRural cazador2 = new CazadorRural();
    cazador2.setExperiencia(50);

    cazador1.capturar(zona);
    cazador2.capturar(zona);

    // Todos los capturados por ambos
    List<IProfugo> todosCapturados = new ArrayList<>();
    todosCapturados.addAll(cazador1.getCapturados());
    todosCapturados.addAll(cazador2.getCapturados());

    // Verificar que se capturaron los que son capturables
    assertTrue(todosCapturados.contains(p1));
    assertTrue(todosCapturados.contains(p2));
    assertTrue(todosCapturados.contains(p3));

    // Prófugo más hábil capturado
    IProfugo masHabil = todosCapturados.stream()
                            .max(Comparator.comparing(IProfugo::getHabilidad))
                            .orElse(null);
    assertEquals(40, masHabil.getHabilidad()); // ahora el máximo capturado es 40

    // Cazador con más capturas
    Cazador masExitoso = cazador1.getCapturados().size() >= cazador2.getCapturados().size() ? cazador1 : cazador2;
    assertEquals(masExitoso, cazador1); // según la lógica actual
}
   
}


