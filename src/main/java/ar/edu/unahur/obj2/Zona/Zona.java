package ar.edu.unahur.obj2.Zona;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;



public class Zona {
    private String nombre;

    List<IProfugo> profugos;

    

    public Zona(List<IProfugo> profugos) {
        this.profugos = new ArrayList<>(profugos);
    }
    

    public List<IProfugo> getProfugos() {
        return profugos;
    }

    public void eliminarProfugo(IProfugo profugo) {
        profugos.remove(profugo);
    }

}
