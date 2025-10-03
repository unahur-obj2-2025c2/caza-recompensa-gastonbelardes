package ar.edu.unahur.obj2.Profugos;

public class ProfugoMartialArtist implements IProfugo {
    private IProfugo profugo;

    public ProfugoMartialArtist(IProfugo profugo) {
        this.profugo = profugo;
    }

    @Override
    public Integer getInocencia() {
        return profugo.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        
        return Math.min(100, profugo.getHabilidad() * 2);
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
