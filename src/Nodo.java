public class Nodo {
    String contexto;
    String[] ramas;
    Nodo[] nodos;
    boolean visitado = false;

    public Nodo(String contexto, String[] ramas) {
        this.contexto = contexto;
        this.ramas = ramas;
    }

/*
    public void escenario() {
        System.out.println(formatearString(contexto));
        for (int i = 0; i < ramas.length; i++) {
            System.out.println((i + 1) + ". " + ramas[i]);
        }
    }
*/

    public static String formatearString(String string) {
        char[] chars = string.toCharArray();
        int n = 66;
        StringBuilder s = new StringBuilder();
        for (int i = 0, salto = 0; i < string.length(); i++, salto++) {
            if (salto % n == 0)
                s.append("\n");
            if (chars[i] == '\n')
                salto = 0;
            s.append(chars[i]);
        }
        return s +"\n";
    }
}
