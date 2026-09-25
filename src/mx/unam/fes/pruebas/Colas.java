package mx.unam.fes.pruebas;
import java.util.LinkedList;
import java.util.Queue;
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
	        
	        Queue<Cliente> cola = new LinkedList<>();
	        
	        int totalClientesGenerados = 0;
	        
	        // Variables para la Caja 1
	        int tiempoRestanteCaja1 = 0;
	        Cliente clienteEnCaja1 = null;
	        
	        // Variables para la Caja 2
	        boolean caja2Abierta = false;
	        int tiempoRestanteCaja2 = 0;
	        Cliente clienteEnCaja2 = null;

	        // Simularemos 30 ciclos (puedes subir este número si quieres ver una prueba más larga)
	        int ciclosDeSimulacion = 30;

	        for (int ciclo = 1; ciclo <= ciclosDeSimulacion; ciclo++) {
	       
	            // 1. LLEGADA DE PERSONAS 
	            int probabilidadLlegada = r.nextInt(100) + 1;
	            if (probabilidadLlegada <= 50) {
	                totalClientesGenerados++;
	                cola.add(new Cliente(totalClientesGenerados));
	                System.out.println("-> Llegó el Cliente #" + totalClientesGenerados + " a la fila.");
	            } else {
	                System.out.println("-> No llegó nadie nuevo.");
	            }

	            // REVISAR SI SE DEBE ABRIR LA CAJA 2
	            // Si alguien en la cola lleva más de 10 ciclos esperando, abrimos la caja 2
	            if (!caja2Abierta) {
	                for (Cliente c : cola) {
	                    if (c.tiempoEnCola > 10) {
	                        caja2Abierta = true;
	                        System.out.println("*** ¡Alerta! Un cliente superó los 10 ciclos de espera. SE ABRE LA CAJA 2 ***");
	                        break; // Con uno que cumpla la condición es suficiente
	                    }
	                }
	            }

	            // ATENCIÓN EN CAJA 1 (Si está libre y hay gente en la cola)
	            if (tiempoRestanteCaja1 == 0 && !cola.isEmpty()) {
	                clienteEnCaja1 = cola.poll(); // Saca al primero de la cola (FIFO)
	                int tiempoEnCaja = r.nextInt(15) + 1; // Random de 1 a 15
	                tiempoRestanteCaja1 = tiempoEnCaja;
	                
	                int tiempoTotal = clienteEnCaja1.tiempoEnCola + tiempoEnCaja;
	                System.out.println("[Caja 1] Atendiendo al Cliente #" + clienteEnCaja1.id + 
	                                   " | Esperó en cola: " + clienteEnCaja1.tiempoEnCola + 
	                                   " | Tardará en caja: " + tiempoEnCaja + 
	                                   " | Tiempo total: " + tiempoTotal);
	            }

	            // ATENCIÓN EN CAJA 2 (Si está abierta, libre y hay gente en la cola)
	            if (caja2Abierta && tiempoRestanteCaja2 == 0 && !cola.isEmpty()) {
	                clienteEnCaja2 = cola.poll();
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
	            if (tiempoRestanteCaja1 > 0) {
	                tiempoRestanteCaja1--;
	                if (tiempoRestanteCaja1 == 0) System.out.println("  * Caja 1 terminó de atender y quedó libre.");
	            }
	            if (tiempoRestanteCaja2 > 0) {
	                tiempoRestanteCaja2--;
	                if (tiempoRestanteCaja2 == 0) System.out.println("  * Caja 2 terminó de atender y quedó libre.");
	            }

	            // Sumar 1 al tiempo de espera de todos los que siguen formados en la cola
	            for (Cliente c : cola) {
	                c.tiempoEnCola++;
	            }
	            
	            System.out.println("Personas formadas actualmente en la cola: " + cola.size() + "\n");
	        }
	    }

}
