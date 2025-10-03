package ar.edu.unahur.obj2.Profugos;

public class ProfugoDeElite implements IProfugo {
    private IProfugo profugo;

    public ProfugoDeElite(IProfugo profugo) {
        this.profugo = profugo;
    }

    @Override
    public Integer getInocencia() {
        return profugo.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return profugo.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        // Nunca nervioso
        return false;
    }

    @Override
    public void volverseNervioso() {
        // No hace nada
    }

    @Override
    public void dejarDeEstarNervioso() {
        // No hace nada
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