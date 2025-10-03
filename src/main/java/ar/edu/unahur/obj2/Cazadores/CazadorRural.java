package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public class CazadorRural extends Cazador {

    @Override
    public void capturar(Zona zona) {
        List<IProfugo> capturadosTemp = new ArrayList<>();

        for (IProfugo profugo : zona.getProfugos()) {
            if (puedeCapturar(profugo)) {
                capturadosTemp.add(profugo);
            } else {
                intimidados.add(profugo);
            }
        }

        for (IProfugo profugo : intimidados) {
            profugo.disminuirInocencia();
            aplicarIntimidacion(profugo);
        }

        for (IProfugo profugo : capturadosTemp) {
            zona.eliminarProfugo(profugo);
            capturados.add(profugo);
        }

        int minHabilidad = intimidados.stream()
                .mapToInt(IProfugo::getHabilidad)
                .min()
                .orElse(0);

        experiencia += minHabilidad + 2 * capturadosTemp.size();
    }

    @Override
    protected boolean puedeCapturar(IProfugo profugo) {
        return experiencia > profugo.getInocencia() && profugo.esNervioso();
    }

    @Override
    protected void aplicarIntimidacion(IProfugo profugo) {
        profugo.volverseNervioso();
    }
}


