package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public class CazadorSigiloso extends Cazador {

List<IProfugo> capturados = new ArrayList<>();

List<IProfugo> intimidados = new ArrayList<>();


@Override
    public void capturar(Zona zona) {
        List<IProfugo> capturadosLocal = new ArrayList<>();

        List<IProfugo> intimidados = new ArrayList<>();
        

        for (IProfugo profugo : zona.getProfugos()) {
            if (puedeCapturar(profugo)) {
                capturadosLocal.add(profugo);
            } else {
                intimidados.add(profugo);
            }
        }
        
        for (IProfugo profugo : intimidados) {
            profugo.disminuirInocencia();  // efecto general
            aplicarIntimidacion(profugo);  // efecto específico del tipo de cazador
        }

        for (IProfugo profugo : capturadosLocal) {
            zona.eliminarProfugo(profugo);
            this.capturados.add(profugo);
        }

        int minHabilidad = intimidados.stream()
                .mapToInt(IProfugo::getHabilidad)
                .min()
                .orElse(0);

        this.experiencia += minHabilidad + 2 * capturadosLocal.size();
    }

@Override
    protected boolean puedeCapturar(IProfugo profugo) {
        return this.experiencia > profugo.getInocencia() && profugo.getHabilidad() < 50;
    }

@Override
    protected void aplicarIntimidacion(IProfugo profugo) {
        profugo.reducirHabilidad(); // efecto específico del sigiloso
    }

    }


