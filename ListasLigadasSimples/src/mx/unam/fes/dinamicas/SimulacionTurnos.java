package mx.unam.fes.dinamicas;

import java.util.Random;

public class SimulacionTurnos {
	public static void main(String[] args) {
		Random random=new Random();
		Lista<String>filaBanco=new Lista<>();
		
		
		int totalClientesLlegan=0;
		int totalClientesAtendidos=0;
		int contadorCliente=0;
		int tiempoEspera=0;
		
		//LLEGADA DEL CLIENTE
		
		int randomLlegada=random.nextInt(100)+1;
		
		if(randomLlegada<=50) {
			String nuevoCliente="Cliente #"+ contadorCliente++;
			filaBanco.agregarCola(nuevoCliente);
			totalClientesLlegan++;
			System.out.println("[+] Llego una persona (Random:" +randomLlegada +" <=50)-> " + nuevoCliente+ "se formo.");
		}else {
			System.out.println("[]No llego nadie  (Random:"+ randomLlegada +" >50).");
		}
		
		//ATENCION DEL CAJERO
		
		if(!filaBanco.esVacia()){
			String clienteAtendido=filaBanco.eliminarDeCabeza();
			totalClientesAtendidos++;
			System.out.println("El cajero atendio a: "+clienteAtendido);		
		}else {
			System.out.println("El cajero esta libre");
		}
		
	}

}
