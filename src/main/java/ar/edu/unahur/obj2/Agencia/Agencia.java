package ar.edu.unahur.obj2.Agencia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Profugos.IProfugo;

public class Agencia {
    private List<Cazador> cazadores;

    public Agencia(List<Cazador> cazadores) {
        this.cazadores = new ArrayList<>(cazadores);
    }

    // 1️⃣ Todos los prófugos capturados por todos los cazadores
    public List<IProfugo> todosLosCapturados() {
        List<IProfugo> resultado = new ArrayList<>();
        for (Cazador c : cazadores) {
            resultado.addAll(c.getCapturados());
        }
        return resultado;
    }

    // 2️⃣ El prófugo más hábil capturado
    public IProfugo profugoMasHabil() {
        return todosLosCapturados().stream()
                .max(Comparator.comparingInt(IProfugo::getHabilidad))
                .orElse(null); // null si no hay capturados
    }

    // 3️⃣ El cazador con más capturas realizadas
    public Cazador cazadorConMasCapturas() {
        return cazadores.stream()
                .max(Comparator.comparingInt(c -> c.getCapturados().size()))
                .orElse(null); // null si no hay cazadores
    }
}

