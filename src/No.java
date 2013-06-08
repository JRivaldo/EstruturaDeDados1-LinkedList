
public class No<E> {

	private No<E> proximo;
	private E objeto;
	
	public No(E o){
		this.setObjeto(o);
	}
	
	public No(E o, No<E> proximo){
		this.objeto = o;
		this.proximo = proximo;
	}

	public No<E> getProximo() {
		return proximo;
	}

	public void setProximo(No<E> proximo) {
		this.proximo = proximo;
	}

	public E getObjeto() {
		return objeto;
	}

	public void setObjeto(E objeto) {
		this.objeto = objeto;
	}
	
}
