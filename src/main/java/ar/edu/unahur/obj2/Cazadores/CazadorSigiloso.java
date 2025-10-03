package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public class CazadorSigiloso extends Cazador {

    @Override
    public void capturar(Zona zona) {
        // Lista temporal para no modificar la zona mientras iteramos
        List<IProfugo> capturadosTemp = new ArrayList<>();

        for (IProfugo profugo : zona.getProfugos()) {
            if (puedeCapturar(profugo)) {
                capturadosTemp.add(profugo);
            } else {
                intimidados.add(profugo);
            }
        }

        // Aplicar intimidación
        for (IProfugo profugo : intimidados) {
            profugo.disminuirInocencia();        // efecto general
            aplicarIntimidacion(profugo);        // efecto específico del sigiloso
        }

        // Mover capturados de la zona a la lista del cazador
        for (IProfugo profugo : capturadosTemp) {
            zona.eliminarProfugo(profugo);
            capturados.add(profugo);
        }

        // Incrementar experiencia
        int minHabilidad = intimidados.stream()
                .mapToInt(IProfugo::getHabilidad)
                .min()
                .orElse(0);

        experiencia += minHabilidad + 2 * capturadosTemp.size();
    }

    @Override
    protected boolean puedeCapturar(IProfugo profugo) {
        return experiencia > profugo.getInocencia() && profugo.getHabilidad() < 50;
    }

    @Override
    protected void aplicarIntimidacion(IProfugo profugo) {
        profugo.reducirHabilidad();
    }
}


