/**
 * 
 */
package br.com.wesley;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Wesley
 *
 */
public class SegundoGrauRemoteImpl extends UnicastRemoteObject implements SegundoGrauRemote {

	protected SegundoGrauRemoteImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		try{
			Registry  r = LocateRegistry.getRegistry();
			/**
			 * r.bind("equacao" onde "equacao" é o nome do metodo que será
			 * Invocado na URI do RMI.
			 */
			r.bind("equacao", new SegundoGrauRemoteImpl());
			System.out.println("Servidor On-line...\nAguardando Requisições...");
		}catch (Exception e){
			e.printStackTrace();
		}

	}


	@Override
	public String setCoeficientes(int a, int b, int c) throws RemoteException {

		System.out.println("Determinando o Delta....\n");
		/**
		 * Delta = b2 - 4 * a * c
		 */
		int delta = (int) (Math.pow(b, 2) - (4*a*c));

		int x1 = (int) ((-b + Math.sqrt(delta)) / (2 * a));

		int x2 = (int) ((-b - Math.sqrt(delta)) / (2 * a));

		String _b="",_c="";
		if(b>=0){
			_b = "+"+b;
		}else{
			_b = ""+b;
		}
		if(c>=0){
			_c = "+"+c;
		}else{
			_c = ""+c;
		}

		String result = "";
		if(delta<0){
			result = "O Delta da Equação ficou negativo, não existe Raizes para Delta Negativo";
		}else{
			result = "O Delta da Equação "+a+"x"+(char)178+""+_b+"x"+_c+" é: "+ delta + ".\n ";
			result+= "Os valores de X que Satisfazem a Equação são respectivamente: \n"
					+ "X': "+ x1 + "\nX'': "+x2+".";
		}
		System.out.println("Servidor On-line...\nAguardando Requisições...");
		return result;
	}

}
