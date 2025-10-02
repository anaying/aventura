import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = saludo(sc);

        entrada.nodos = new Nodo[]{null,null,techo0,null};
        techo0.nodos = new Nodo[]{techo1,null,cabeza, null};
        techo1.nodos = new Nodo[]{null, techo2,mesa,null};
        techo2.nodos = new Nodo[]{null,canon, silla, techo1};
        base.nodos = new Nodo[]{null,techo2, null,techo1};
        cabeza.nodos = new Nodo[]{base,null,nuca,null};
        mesa.nodos = new Nodo[]{base,foto,null, silla};
        foto.nodos = new Nodo[]{null,silla,null,null};
        silla.nodos = new Nodo[]{ base,abrigo,null, mesa};
        abrigo.nodos = new Nodo[]{base,salida, null,null};
        canon.nodos = new Nodo[]{null,null,null,techo1};
//        System.out.println(gps.gameOver);

        javax.swing.SwingUtilities.invokeLater(() -> new Ventana(nombre).setNewStage(entrada,null));
//        Ventana frame = new Ventana(nombre);
//        frame.setNewScenario(entrada,null);
    }


    private static String saludo(Scanner sc) {
        System.out.println("Bienvenido, pequeño arácnido, al aula 2 de FP/trompa. ¿Cómo te llamas?");
        return sc.nextLine();
    }

    private static final Nodo entrada = new Nodo(
            "Es un hermoso día de otoño. El sol brilla y no hay nubes en el cielo, aunque tú eso no lo sabes porque solo eres una mísera araña de m*****. Estás trepando por una superficie lisa, buscando un buen lugar donde tejer tu tela, cuando percibes un cambio abrupto en el terreno. Curiosa, decides investigarlo.",
            new String[]{null,null,"Adentrarse",null});
    private static final Nodo techo0 = new Nodo(
            "La luz y la temperatura cambian. La gravedad ya no tira de ti hacia atrás, sino hacia arriba. Intuyes que se trata de un hábitat distinto al que estás acostumbrada, pero no te acobardas porque tu sistema nervioso es tan básico que no puede ni liberar adrenalina.",
            new String[]{"Avanzar",null,"Descender", null});
    private static final Nodo techo1 = new Nodo(
            "Continúas tu camino hacia lo desconocido en busca de un mejor asentamiento donde tender tu trampa mortal para incautos seres minúsculos. Sin embargo, cada vez hay más luz y hace más calor, lo cual te resulta agobiante.",
            new String[]{null, "Girar","Descender",null});
    private static final Nodo techo2 = new Nodo(
            "Avanzas hasta que percibes una extraña fuente de luz por encima de ti. Además, descubres que hay una estructura cilíndrica que sube hacia ella.",
            new String[]{null,"Seguir la luz", "Descender", "Retroceder"});
    private static final Nodo base = new Nodo(
            "Obedeciendo a la sabia voz de la prudencia, optas por regresar a la base de tu hilo.",
            new String[]{null, "Ir hacia otro lado",null,"Ir hacia un lado"});
    private static final Nodo cabeza = new Nodo(
            "Después de haber descendido más de un metro, te topas con otra superficie, esta vez redondeada. De ella brotan unas curiosas hebras.",
            new String[]{ "Volver a subir",null,"Seguir descendiendo",null});
    private static final Nodo nuca = new Nodo(
            "Atraviesas el bosque de hebras hasta llegar a una explanada.\n―Eh... Tienes una araña en el cuello ―dice alguien.\nTú no lo oyes porque no tienes oídos. Lo que sí notas son unas violentas sacudidas del nivel de un terremoto de magnitud 8 (a escala, claro). Unas enormes estructuras te golpean y te lanzan por los aires, esta vez sin ningún hilo al que asirte. Mareada y por fin en tierra firme, tratas de escapar, pero eres aplastada sin piedad por una lámina de caucho.",
            null);
    private static final Nodo mesa = new Nodo(
            "Llegas a un extraño paisaje salpicado por diferentes obstáculos. Vagas de aquí para allá cuando una amenazadora sombra se cierne sobre ti. Tu final se acerca, pero algo la detiene:\n―Las arañas son buenas compañeras ―dice una voz providencial. ―Se comen a los bichos y no hacen daño a nadie.",
            new String[]{ "Ascender","Quedarse",null, "Marcharse"});
    private static final Nodo foto = new Nodo(
            "Te quedas donde estás. Del horizonte surge una masa rectangular que se detiene flotando frente a ti. Un destello te ciega momentáneamente.\n―Esta va para el grupo de profesores.\nLa verdad es que sales monísima, a pesar de que Eva la de IPE1 no opine lo mismo.",
            new String[]{null,"Huir",null,null});
    private static final Nodo silla = new Nodo(
            "Llegas a un terreno irregular con texturas rugosas y lisas. Algunas partes son incluso frías. No has recorrido un paraje igual en tu corta y monótona vida de araña.",
            new String[]{ "Ascender","Quedarse",null,"Marcharse"});
    private static final Nodo abrigo = new Nodo(
            "Algo aterriza junto a ti. Es un manto formado por varias capas y parece abarcar una gran extensión. Podría ser un buen refugio.",
            new String[]{ "Ascender","Refugiarse",null,null});
    private static final Nodo canon = new Nodo(
            "Deslumbrada por el haz de luz misterioso, alcanzas el borde de una superficie convexa. Intrigada, pones una pata sobre ella, luego otra y otra...\n―La araña está en el proyector.\n―Así no veo el encerado.\n―Bueno, no pasa nada. Aprovechamos y hacemos el descanso.",
            new String[]{null,null,null,"Retroceder"});
    private static final Nodo salida = new Nodo(
            "Al cabo de un tiempo indefinido, sientes que el terreno se mueve. Tras un par de sacudidas, notas que te desplazas a ritmo constante. Cuando el movimiento cesa, desciendes hasta que das con suelo firme.\n\nHa sido un día intenso, lleno de misterios y zozobras. Estás cansada y todavía no has encontrado un lugar donde tejer tu tela. Mientras reconsideras tus planes, un ente se aproxima y te espachurra contra el pavimento.\n\nAsí concluye este viaje (y todos los demás), pero tu travesía no ha sido en vano: pasarás a los anales de la historia como código fuente de dos docenas de estudiantes de DAM.",
            null);
//    private static final String huida = "\nHuyes despavorida cual diva pillada in fraganti por los paparazzis.";
//    private static final String descenso = "\nComienzas a segregar seda líquida mientras te cuelgas de ella. Es un hilo de gran resistencia, aunque insuficiente para soportar el peso de un elefante balanceándose (ya no digamos el de varios). ";


}