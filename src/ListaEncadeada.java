
public class ListaEncadeada<E> {
	
	private No<E> primeiro;
	private int size;
	
	public ListaEncadeada(){ 
		this.primeiro = null;
		this.size = 0;
	}
	
	private No<E> getNo(int pos){
		if((pos < 0) || (pos >= size)){
			throw new IndexOutOfBoundsException();
		}
		No<E> temp = this.primeiro;
		for(int i = 0; i < pos; i++){
			temp =  temp.getProximo();
		}			
		return temp;
	}
	
	public E getObjeto(int pos){
		return this.getNo(pos).getObjeto();
	}

	public void addPosicao(Object obj, int pos){
		if((pos < 0) || (pos > size)){ 
			throw new IndexOutOfBoundsException();
		}
		
		if(this.primeiro == null || pos == 0){
			this.primeiro = new No(obj, this.primeiro);
		}
		else{
			No<E> temp = this.getNo(pos - 1); 
			temp.setProximo(new No(obj, temp.getProximo())); 
		}		
		this.size++;
	}	
	
	public void addInicio(Object obj){
		this.addPosicao(obj, 0);
	}

	public void add(Object obj){
		this.addPosicao(obj, this.size);
	}
	
	public E removerInicio(){
		return this.remover(0);		
	}
	
	public E removerFim(){
		return this.remover(this.size -1);
	}
	
	public E remover(int pos){		
		if((pos < 0) || (pos > this.size)){ 
			throw new IndexOutOfBoundsException();
		}
		int tam = this.size;
		this.size--;
		E removido;
		
		if(pos == 0){
			removido = this.primeiro.getObjeto();
			this.primeiro =  this.primeiro.getProximo();
			return removido;
		}
		No<E> aux = this.primeiro;
		
		for(int i = 0; i < pos -1; i++){
			aux = aux.getProximo();			
		}
		
		if(pos == tam -1){
			removido = aux.getProximo().getObjeto();
			aux.setProximo(null);
			return removido;
		}
		
		No<E> remover = aux.getProximo();
		removido = remover.getObjeto();
		aux.setProximo(remover.getProximo());
		return removido;
		
	}
	
	public int tamanho(){
		return this.size;
	}
	
	public String toString() {
		if(this.size == 0){
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<E> atual = this.primeiro;
		
		for (int i = 0; i < this.size -1; i++) { 
			builder.append(atual.getObjeto()); 
			builder.append(", "); 
			atual = atual.getProximo(); 
		}
		
		builder.append(atual.getObjeto()); 
		builder.append("]");
		return builder.toString(); 
	}
	

}
