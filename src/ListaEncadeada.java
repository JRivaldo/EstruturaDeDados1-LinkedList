
public class ListaEncadeada {
	
	private No cabeca;
	private int size; // Serve para ter controle sobre a quantidade de elementos na lista.
	
	public ListaEncadeada(){ //Inicializa��o das variaveis.
		this.cabeca = null;
		this.size = 0;
	}
	/*
	 * Esse m�todo abaixo serve para auxiliar na procura do n�, mesmo ela sendo de procura linear
	 * ela � muito util, evitando no caso ter que repetir o mesmo c�digo para varrer os n�s.
	 * Deixei o m�todo privado porque ele s� vai ser necess�rio na pr�pria classe.
	 */
	private No getNo(int pos){
		if((pos < 0) || (pos >= size)){
			throw new IndexOutOfBoundsException(); //Lan�a uma exception caso a posi��o seja inv�lida.
		}
		No temp = this.cabeca;// vari�vel tempor�ria para a vari�vel "cabeca".
		for(int i = 0; i < pos; i++){
			temp =  temp.getProximo(); //No final da itera��o "temp" estar� com o valor da posi��o desejada.
		}			
		return temp; //Retorna "temp".
	}
	
	/*
	 * Esse m�todo serve para adicionar o objeto a posi��es v�lidas na lista.
	 * Esse m�todo tamb�m serve de auxilio para os m�todos "addInicio" onde ser� adicionado o valor
	 * no inicio da lista, e o m�todo "add" onde o valor ser� adicionado no final da lista.
	 */
	public void addPosicao(Object obj, int pos){
		if((pos < 0) || (pos > size)){ //verifica se a posi��o escolhida � v�lida, caso n�o, � jogado uma exception.
			throw new IndexOutOfBoundsException();
		}
		
		if(this.cabeca == null || pos == 0){// caso a "cabe�a" seja null ou a "posi��o" seja 0 o valor ser� adicionado no inicio.
			this.cabeca = new No(obj, this.cabeca);//Nessa linha a "cabe�a" recebe o objeto e o "proximo" como a pr�pria cabe�a para ficar referenciando a cabe�a antes de ser atualizada.
		}
		else{
			No temp = this.getNo(pos - 1); // vari�vel tempor�ria a qual recebe o n� na posi��o anterior a desejada, chamando o m�todo privado "getNo".
			temp.setProximo(new No(obj, temp.getProximo())); // Atualiza o valor da pr�xima posi��o atual com o novo valor e seta a refer�ncia do novo valor com a do valor antes de ser atualizado. 
		}
		
		this.size++;// incrementa o tamanho em +1		
	}
	
	/*
	 * Esse m�todo abaixo usa o m�todo "addPosicao" para adicionar o elemento no inicio da lista.
	 */
	public void addInicio(Object obj){
		this.addPosicao(obj, 0);// chama o m�todo "addPosicao" passando o objeto e a posi��o 0 para ser adicionado no inicio.
	}
	
	/*
	 * Esse m�todo abaixo usa o m�todo "addPosicao" para adicionar o elemento no final da lista.
	 */
	public void add(Object obj){
		this.addPosicao(obj, size);// chama o m�todo "addPosicao" passando o objeto e a posi��o atual do tamanho da lista para ser adicionado no final.
	}
	
	
public void remover(int pos){
		
		if((pos < 0) || (pos > size)){ 
			throw new IndexOutOfBoundsException();
		}
		
		No aux = this.cabeca;
		
		for(int i = 0; i < pos -1; i++){
			aux = aux.getProximo();			
		}
		if(pos == 0){
			this.cabeca =  this.cabeca.getProximo();
		}
		else if(pos == this.size -1){
			aux.setProximo(null);
		}
		else{
			aux.setProximo(aux.getProximo().getProximo());
		}		
		
		this.size--;
		
	}
	
	
	/*
	 * Esse m�todo abaixo s� serve para mostrar todos os valores de vari�veis primitivas, como String, Int, Float e etc.
	 */
	public String toString() {
		if(this.size == 0){ //caso o tamanho da lista seja 0 ser� retornado uma string indicando que ela est� vazia.
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No atual = this.cabeca;
		
		for (int i = 0; i < this.size -1; i++) { //itera��o varrendo do inicio ao penultimo valor da lista.
			builder.append(atual.getObjeto()); //adiciona o valor atual do objeto como string na string.
			builder.append(", "); // adiciona uma separa��o entre os valores adicionados para melhor visualiza��o.
			atual = atual.getProximo(); // atualiza a vari�vel "atual" com o pr�ximo valor.
		}
		
		builder.append(atual.getObjeto()); // pega o ultimo valor v�lido da lista e adiciona na string.
		builder.append("]");
		return builder.toString(); //Retorna o m�todo "toString" padr� da classe "StringBuild".
	}
	

}
