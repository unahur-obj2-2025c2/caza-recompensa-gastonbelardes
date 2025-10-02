package ar.edu.unahur.obj2.Profugos;

public class Profugos implements IProfugo {
    private Integer inocencia;
    private Integer habilidad;
    private Boolean nervioso;

    @Override
    public Integer getInocencia() {
        return this.inocencia;
    }

    @Override
    public Integer getHabilidad() {
        return this.habilidad;
    }

    @Override
    public Boolean esNervioso() {
        return this.nervioso;
    }

    @Override
    public void volverseNervioso() {
        this.nervioso = true;
    }

    @Override
    public void dejarDeEstarNervioso() {
        this.nervioso = false;
    }

    @Override
    public void reducirHabilidad() {
        this.habilidad = Math.max(0, this.habilidad - 5);
    }

    @Override
    public void disminuirInocencia() {
        this.inocencia = Math.max(0, this.inocencia - 5);
    }

}
