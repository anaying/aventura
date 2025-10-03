public class Nodo {
    String contexto;
    String[] ramas;
    Nodo[] nodos;
    boolean visitado = false;

    public Nodo(String contexto, String[] ramas) {
        this.contexto = contexto;
        this.ramas = ramas;
    }
}
