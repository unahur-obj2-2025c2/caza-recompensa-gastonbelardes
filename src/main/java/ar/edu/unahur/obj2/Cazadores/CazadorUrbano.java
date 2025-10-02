package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public class CazadorUrbano extends Cazador {

@Override
    public void capturar(Zona zona) {

    }

@Override
protected boolean puedeCapturar(IProfugo profugo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'puedeCapturar'");
}

@Override
protected void aplicarIntimidacion(IProfugo profugo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'aplicarIntimidacion'");
}

}
