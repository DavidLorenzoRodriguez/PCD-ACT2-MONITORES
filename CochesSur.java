package monitores;



public class CochesSur extends Thread {

    Puente puente;

    public CochesSur(Puente p_puente) {//Crea el constructor del coche para pasarle el monitor que va a utilizar como parámetro
        puente = p_puente;
    }

    public void run() {
        try {
            puente.entrarCocheSur(); //llama al método correspondiente para entrar en el puente
            System.out.println("ENTRO " + getName());//muestra por pantalla el nombre del coche que ha entrado en el puente
            //PASAR EL PUENTE
            sleep(100);//duerme el hilo
            puente.salirCocheSur();//llama al método correspondiente para salir del puente
            System.out.println("SALIO " + getName());//muestra por pantalla el nombre del coche que ha entrado en el puente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
