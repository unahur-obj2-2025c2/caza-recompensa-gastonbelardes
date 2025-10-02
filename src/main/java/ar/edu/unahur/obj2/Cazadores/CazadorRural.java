package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Zona.Zona;

public class CazadorRural extends Cazador{

List<IProfugo> capturados = new ArrayList<>();

List<IProfugo> intimidados = new ArrayList<>();

@Override
public void capturar(Zona zona) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'capturar'");
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

