package ar.edu.unahur.obj2.Profugos;

public class ProfugoConProteccionLegal implements IProfugo {
    private IProfugo profugo;

    public ProfugoConProteccionLegal(IProfugo profugo) {
        this.profugo = profugo;
    }

    @Override
    public Integer getInocencia() {
        // Nunca menor a 40
        return Math.max(40, profugo.getInocencia());
    }

    @Override
    public Integer getHabilidad() {
        return profugo.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public void volverseNervioso() {
        profugo.volverseNervioso();
    }

    @Override
    public void dejarDeEstarNervioso() {
        profugo.dejarDeEstarNervioso();
    }

    @Override
    public void reducirHabilidad() {
        profugo.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        profugo.disminuirInocencia();
    }
}
