package ar.edu.unahur.obj2.Zona;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;



public class Zona {
    private String nombre;

    List<IProfugo> listaProfugos = new ArrayList<>();

    

    public Zona(String nombre, List<IProfugo> listaProfugos) {
        this.listaProfugos = new ArrayList<>(listaProfugos);
    }
    

    public List<IProfugo> getProfugos() {
        return listaProfugos;
    }

    public void eliminarProfugo(IProfugo profugo) {
        listaProfugos.remove(profugo);
    }

}
