package monitores;



public class CochesNorte extends Thread {

    Puente puente;

    public CochesNorte(Puente p_puente) {//Crea el constructor del coche para pasarle el monitor que va a utilizar como par�metro
        puente = p_puente;
    }

    public void run() {
        try {
            puente.entrarCocheNorte();//llama al m�todo correspondiente para entrar al puente
            System.out.println("ENTRO " + getName());//muestra por pantalla el nombre del coche que entr� al puente
            //PASAR EL PUENTE
            sleep(200);//duerme el hilo
            puente.salirCocheNorte();//llama al m�todo correspondiente para salir del puente
            System.out.println("SALIO " + getName());//muestra por pantalla el nombre del coche que sali� del puente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
