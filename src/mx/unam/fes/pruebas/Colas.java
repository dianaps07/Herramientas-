package mx.unam.fes.pruebas;
import java.util.Random;

public class Colas {
	 static class Cliente {
	        int id;
	        int tiempoEnCola;

	        public Cliente(int id) {
	            this.id = id;
	            this.tiempoEnCola = 0;
	        }
	    }

	    public static void main(String[] args) {
	        Random r = new Random();
	        
	        Cola cola = new Cola();
	        
	        int totalClientesGenerados = 0;
	        
	        // Variables para la Caja 1
	        int tiempoRestanteCaja1 = 0;
	        Cliente clienteEnCaja1 = null;
	        
	        // Variables para la Caja 2
	        boolean caja2Abierta = false;
	        int tiempoRestanteCaja2 = 0;
	        Cliente clienteEnCaja2 = null;

	        // Simularemos 30 ciclos
	        int ciclosDeSimulacion = 30;

	        for (int ciclo = 1; ciclo <= ciclosDeSimulacion; ciclo++) {
	       
	            // LLEGADA DE PERSONAS 
	            int probabilidadLlegada = r.nextInt(100) + 1;
	            if (probabilidadLlegada <= 50) {
	                totalClientesGenerados++;
	                cola.insertar(new Cliente(totalClientesGenerados));
	                System.out.println("-> Llegó el Cliente #" + totalClientesGenerados + " a la fila.");
	            } else {
	                System.out.println("-> No llegó nadie nuevo.");
	            }

	            // REVISAR SI SE DEBE ABRIR LA CAJA 2
	            if (!caja2Abierta) {
	                int size = cola.getLongitud();
	                boolean abrirCaja = false;
	                
	                // Desencolar y volver a encolar
	                for (int i = 0; i < size; i++) {
	                    Cliente c = (Cliente) cola.eliminar();
	                    if (c.tiempoEnCola > 10) {
	                        abrirCaja = true;
	                    }
	                    cola.insertar(c); // Lo regresamos a la fila
	                }
	                
	                if (abrirCaja) {
	                    caja2Abierta = true;
	                    System.out.println("*** ¡Alerta! Un cliente superó los 10 ciclos de espera. SE ABRE LA CAJA 2 ***");
	                }
	            }

	            // ATENCIÓN EN CAJA 1 (Si está libre y hay gente en la cola)
	            if (tiempoRestanteCaja1 == 0 && !cola.esVacia()) {
	                clienteEnCaja1 = (Cliente)cola.eliminar();
	                int tiempoEnCaja = r.nextInt(15) + 1;
	                tiempoRestanteCaja1 = tiempoEnCaja;
	                
	                int tiempoTotal = clienteEnCaja1.tiempoEnCola + tiempoEnCaja;
	                System.out.println("[Caja 1] Atendiendo al Cliente #" + clienteEnCaja1.id + 
	                                   " | Esperó en cola: " + clienteEnCaja1.tiempoEnCola + 
	                                   " | Tardará en caja: " + tiempoEnCaja + 
	                                   " | Tiempo total: " + tiempoTotal);
	            }

	            // ATENCIÓN EN CAJA 2 (Si está abierta, libre y hay gente en la cola)
	            if (caja2Abierta && tiempoRestanteCaja2 == 0 && !cola.esVacia()) {
	                clienteEnCaja2 = (Cliente)cola.eliminar();
	                int tiempoEnCaja = r.nextInt(15) + 1;
	                tiempoRestanteCaja2 = tiempoEnCaja;
	                
	                int tiempoTotal = clienteEnCaja2.tiempoEnCola + tiempoEnCaja;
	                System.out.println("[Caja 2] Atendiendo al Cliente #" + clienteEnCaja2.id + 
	                                   " | Esperó en cola: " + clienteEnCaja2.tiempoEnCola + 
	                                   " | Tardará en caja: " + tiempoEnCaja + 
	                                   " | Tiempo total: " + tiempoTotal);
	            }

	            // ACTUALIZAR TIEMPOS PARA EL SIGUIENTE CICLO
	            // Restar 1 al tiempo de los clientes que ya están en las cajas
	            int numFormados = cola.getLongitud();
	            for (int i = 0; i < numFormados; i++) {
	                Cliente c = (Cliente) cola.eliminar(); // Lo sacamos
	                c.tiempoEnCola++; // Le sumamos el tiempo
	                cola.insertar(c); // Lo regresamos a su lugar
	            }

	            // Se usa getLongitud() en lugar de size()
	            System.out.println("Personas formadas actualmente en la cola: " + cola.getLongitud() + "\n");
	        }
	    }
}

