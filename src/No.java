
public class No {

	private No proximo;
	private Object objeto; //Resolvi deixa como objeto para ficar mais dinâmico.
	
	public No(Object o){
		this.setObjeto(o);
	}
	
	public No(Object o, No proximo){
		this.objeto = o;
		this.proximo = proximo;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
}
