package monitores;

import java.util.concurrent.locks.*;

public class Puente {

    //Declaramos el objeto de la clase ReentrantLock que vamos a usar como cerrojo
    final ReentrantLock cerrojo = new ReentrantLock();
    //Declaramos las condiciones que vamos a utilizar en el cerrojo
    final Condition okCocheE = cerrojo.newCondition();
    final Condition okCocheO = cerrojo.newCondition();
    int c, b;//Variables para calcular el número de coches que están pasando por el puente

    public Puente() {
        b = 0;
        c = 0;
    }

    public void entrarCocheSur() throws InterruptedException {
        cerrojo.lock();
        try {
            while ((b > 0)) {
                System.out.println("coche del Sur esperando..puente ocupado");
                okCocheE.await(); //El coche espera
            }
            c++; //Incrementa el número de coches pasando
            okCocheE.signal(); //Despierta si hay otro coche esperando
            //BAJAR PUENTE
        } finally {//Desbloquea el cerrojo pase lo que pase
            cerrojo.unlock();
        }
    }

    public void salirCocheSur() throws InterruptedException {
        cerrojo.lock();
        try {
            System.out.println("coche del Sur saliendo..puente libre");
            c--; //Disminuye el número de coches pasando
            if (c == 0) {
                okCocheO.signal(); //El último coche que pasa comunica al coche que puede pasar (si lo hay)
            }//
        } finally {//Desbloquea el cerrojo pase lo que pase
            cerrojo.unlock();
        }
    }

    public void entrarCocheNorte() throws InterruptedException {
        cerrojo.lock();
        try {
            while ((c > 0)) //Si hay coches pasando
            {
                System.out.println("Coche del Norte esperando..puente ocupado");
                okCocheO.await(); //Esperar a que pasen los coches
            }
            b++; //Incrementa el número de coches pasando
            okCocheO.signal(); //Despierta a otro coche si lo hay para que intente pasar
        } finally {//Desbloquea el cerrojo pase lo que pase
            cerrojo.unlock();
        }
    }

    public void salirCocheNorte() throws InterruptedException {
        cerrojo.lock();
        try {
            System.out.println("Coche del Norte saliendo..puente libre");
            b--; //Disminuye el número de coches  que están pasando
            if (b == 0) {
                okCocheE.signal(); //El último coche comunica al coche que espera (si lo hay) que puede intentar pasar
            }
        } finally {//Desbloquea el cerrojo pase lo que pase
            cerrojo.unlock();
        }
    }

    private int awaited(Condition condicion) { //Devuelve el número de hilos que esperan sobre la variable condicion
        return cerrojo.getWaitQueueLength(condicion);
    }
}
