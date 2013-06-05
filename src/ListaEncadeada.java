
public class ListaEncadeada {
	
	private No cabeca;
	private int size; // Serve para ter controle sobre a quantidade de elementos na lista.
	
	public ListaEncadeada(){ //Inicialização das variaveis.
		this.cabeca = null;
		this.size = 0;
	}
	/*
	 * Esse método abaixo serve para auxiliar na procura do nó, mesmo ela sendo de procura linear
	 * ela é muito util, evitando no caso ter que repetir o mesmo código para varrer os nós.
	 * Deixei o método privado porque ele só vai ser necessário na própria classe.
	 */
	private No getNo(int pos){
		if((pos < 0) || (pos >= size)){
			throw new IndexOutOfBoundsException(); //Lança uma exception caso a posição seja inválida.
		}
		No temp = this.cabeca;// variável temporária para a variável "cabeca".
		for(int i = 0; i < pos; i++){
			temp =  temp.getProximo(); //No final da iteração "temp" estará com o valor da posição desejada.
		}			
		return temp; //Retorna "temp".
	}
	
	/*
	 * Esse método serve para adicionar o objeto a posições válidas na lista.
	 * Esse método também serve de auxilio para os métodos "addInicio" onde será adicionado o valor
	 * no inicio da lista, e o método "add" onde o valor será adicionado no final da lista.
	 */
	public void addPosicao(Object obj, int pos){
		if((pos < 0) || (pos > size)){ //verifica se a posição escolhida é válida, caso não, é jogado uma exception.
			throw new IndexOutOfBoundsException();
		}
		
		if(this.cabeca == null || pos == 0){// caso a "cabeça" seja null ou a "posição" seja 0 o valor será adicionado no inicio.
			this.cabeca = new No(obj, this.cabeca);//Nessa linha a "cabeça" recebe o objeto e o "proximo" como a própria cabeça para ficar referenciando a cabeça antes de ser atualizada.
		}
		else{
			No temp = this.getNo(pos - 1); // variável temporária a qual recebe o nó na posição anterior a desejada, chamando o método privado "getNo".
			temp.setProximo(new No(obj, temp.getProximo())); // Atualiza o valor da próxima posição atual com o novo valor e seta a referência do novo valor com a do valor antes de ser atualizado. 
		}
		
		this.size++;// incrementa o tamanho em +1		
	}
	
	/*
	 * Esse método abaixo usa o método "addPosicao" para adicionar o elemento no inicio da lista.
	 */
	public void addInicio(Object obj){
		this.addPosicao(obj, 0);// chama o método "addPosicao" passando o objeto e a posição 0 para ser adicionado no inicio.
	}
	
	/*
	 * Esse método abaixo usa o método "addPosicao" para adicionar o elemento no final da lista.
	 */
	public void add(Object obj){
		this.addPosicao(obj, size);// chama o método "addPosicao" passando o objeto e a posição atual do tamanho da lista para ser adicionado no final.
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
	 * Esse método abaixo só serve para mostrar todos os valores de variáveis primitivas, como String, Int, Float e etc.
	 */
	public String toString() {
		if(this.size == 0){ //caso o tamanho da lista seja 0 será retornado uma string indicando que ela está vazia.
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No atual = this.cabeca;
		
		for (int i = 0; i < this.size -1; i++) { //iteração varrendo do inicio ao penultimo valor da lista.
			builder.append(atual.getObjeto()); //adiciona o valor atual do objeto como string na string.
			builder.append(", "); // adiciona uma separação entre os valores adicionados para melhor visualização.
			atual = atual.getProximo(); // atualiza a variável "atual" com o próximo valor.
		}
		
		builder.append(atual.getObjeto()); // pega o ultimo valor válido da lista e adiciona na string.
		builder.append("]");
		return builder.toString(); //Retorna o método "toString" padrã da classe "StringBuild".
	}
	

}
