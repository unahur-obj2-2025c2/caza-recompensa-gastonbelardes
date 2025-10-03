package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public abstract class Cazador {

    protected List<IProfugo> intimidados = new ArrayList<>();


    protected List<IProfugo> capturados = new ArrayList<>();

    protected Integer experiencia;

    public abstract void capturar(Zona zona);


    protected abstract boolean puedeCapturar(IProfugo profugo);


    protected abstract void aplicarIntimidacion(IProfugo profugo);

    


    public List<IProfugo> getCapturados() {
        return capturados;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }
}