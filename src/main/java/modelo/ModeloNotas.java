package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloNotas {
    private List<Nota> notas;

    public ModeloNotas() {
        notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public List<Nota> getNotas() {
        return notas;
    }
    
    public void eliminarNota(int indice) {
        if (indice >= 0 && indice < notas.size()) {
            notas.remove(indice);
        }
    }
}
