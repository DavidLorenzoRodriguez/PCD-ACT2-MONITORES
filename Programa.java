package monitores;


public class Programa {

    public static void main(String arg[]) {
        boolean carrera = true;
        int lap = 1;
//Crea el monitor que se va a utilizar
        while (carrera == true) {//Mientras la variable booleana carrera sea true, se repetirá el proceso de generar el monitor y los hilos
            Puente puente = new Puente();
//Crea los hilos con el constructor correspondiente a cada coche, pasándole el monitor que se va a utilizar como parámetro
            CochesSur c1 = new CochesSur(puente);
            CochesNorte b1 = new CochesNorte(puente);
            CochesSur c2 = new CochesSur(puente);
            CochesNorte b2 = new CochesNorte(puente);
            CochesSur c3 = new CochesSur(puente);
            CochesNorte b3 = new CochesNorte(puente);
            CochesSur c4 = new CochesSur(puente);
            CochesNorte b4 = new CochesNorte(puente);
            CochesSur c5 = new CochesSur(puente);
            CochesNorte b5 = new CochesNorte(puente);
//Le pone el nombre a los hilos (será el nombre que se muestre por pantalla posteriormente cuando un coche entre o salga del puente)
            c1.setName("CocheSur 01\n");
            c2.setName("CocheSur 02\n");
            c3.setName("CocheSur 03\n");
            c4.setName("CocheSur 04\n");
            c5.setName("CocheSur 05\n");
            b1.setName("CocheNorte 06\n");
            b2.setName("CocheNorte 07\n");
            b3.setName("CocheNorte 08\n");
            b4.setName("CocheNorte 09\n");
            b5.setName("CocheNorte 10\n");
//Ejecuta los hilos

            try {
                c1.start();
                b1.start();
                c2.start();
                b2.start();
                c3.start();
                b3.start();
                c4.start();
                b4.start();
                c5.start();
                b5.start();
                lap++;
                if (lap >= 10) {
                    carrera = false;
                }
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }
}
