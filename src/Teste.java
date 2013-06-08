
public class Teste {
	
	public static void main(String [] args){
		
		ListaEncadeada<Integer> list = new ListaEncadeada<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println(list.toString());
		
		list.remover(1);
		
		System.out.println(list.toString());
		
	}

}
