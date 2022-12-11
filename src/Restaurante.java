public class Restaurante {
    private String nome;
    private String endereco;
    Mesa[] mesas;

    public Mesa[] getMesas_geral() {
        return mesas;
    }
    public void setMesas_geral (Mesa[] mesas) {
        this.mesas = mesas;
    }

    public Mesa getMesas(int i) {
        return this.mesas[i];
    }
    public void setMesas (Mesa mesas, int i) {
        this.mesas[i] = mesas;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    void adiciona_mesa (Mesa mesa){
        if(this.getMesas_geral()==null){
            this.mesas=new Mesa[1];
            this.setMesas(mesa, 0);

        }else{
            Mesa[] mesas_reserva = new Mesa[this.getMesas_geral().length];
            for(int i=0; i<getMesas_geral().length;i++){
                mesas_reserva[i]=this.getMesas(i);
            }

            this.mesas= new Mesa[this.getMesas_geral().length + 1];

            for(int i=0; i<mesas_reserva.length;i++){
                this.setMesas(mesas_reserva[i], i);
            }
            this.setMesas(mesa, this.getMesas_geral().length-1);
        }
    }
}
