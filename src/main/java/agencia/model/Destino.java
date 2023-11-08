package agencia.model;

public class Destino {
    private int id;
    private String cidade;
    private String estado;
    private String localDestino;
    private float valor;
    
    

	public Destino(){
        super();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getLocalDestino(){
        return localDestino;
    }
    public void setLocalDestino(String localDestino){
        this.localDestino = localDestino;
    }
    public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
