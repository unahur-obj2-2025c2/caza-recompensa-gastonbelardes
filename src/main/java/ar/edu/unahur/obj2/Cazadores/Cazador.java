package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public abstract class Cazador {

    protected Integer experiencia;

    public abstract void capturar(Zona zona);


    protected abstract boolean puedeCapturar(IProfugo profugo);


    protected abstract void aplicarIntimidacion(IProfugo profugo);
}