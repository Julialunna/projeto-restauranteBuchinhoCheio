import java.util.Scanner; 
public class Mesa {
    private int numeroMesa;
    private String data;
    private boolean reserva=false;
    private int numPessoas;
    private double valorTotal;

    Cliente[] clientes;
    ComandaComida comidas;
    ComandaBebida bebidas;

    public Mesa (double precog, double precoml){
        comidas=new ComandaComida(precog);
        bebidas=new ComandaBebida(precoml);
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public ComandaComida getComidas() {
        return comidas;
    }
    public void setComidas(ComandaComida comidas) {
        this.comidas = comidas;
    }
    public ComandaBebida getBebidas() {
        return bebidas;
    }
    public void setBebidas(ComandaBebida bebidas) {
        this.bebidas = bebidas;
    }
    public Cliente[] getClientes_geral() {
        return clientes;
    }
    public void setClientes_geral(Cliente[] clientes) {
        this.clientes = clientes;
    }
    public Cliente getClientes(int i) {
        return clientes[i];
    }
    public void setClientes(Cliente clientes, int i) {
        this.clientes[i] = clientes;
    }
    public int getNumPessoas() {
        return numPessoas;
    }
    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }
    public int getNumeroMesa() {
        return numeroMesa;
    }
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public boolean getReserva() {
        return reserva;
    }
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    public void atualiza_valor(){
        setValorTotal(getBebidas().getValor()+getComidas().getValor());
    }

    public boolean reservar(int numPessoas){
        Scanner ler = new Scanner(System.in);
        this.setReserva(true);
        this.setNumPessoas(numPessoas);
        System.out.println("Qual a data da reserva");
        this.setData(ler.nextLine());
        System.out.println(getData());
        return this.getReserva();
    }
        

    public void adiciona_cliente (Cliente novoCliente){
        if(this.getReserva()==true){
            if(this.getClientes_geral()==null||this.getClientes_geral().length==0){
                this.clientes=new Cliente[1];
                this.setClientes(novoCliente, 0);
            }else{
                if(this.getClientes_geral().length<this.getNumPessoas()){
                    Cliente[] clientes_reserva = new Cliente[this.getClientes_geral().length];
                    for(int i=0; i<getClientes_geral().length;i++){
                        clientes_reserva[i]=this.getClientes(i);
                    }
                    this.clientes= new Cliente[this.getClientes_geral().length + 1];
                    for(int i=0; i<clientes_reserva.length;i++){
                        this.setClientes(clientes_reserva[i], i);
                    }
                    this.setClientes(novoCliente, this.getClientes_geral().length-1);
                }else{
                    System.out.println("A mesa já esta cheia");
                }
               
            }
        }else{
            System.out.println("Nao é possível fazer a reserva, mesa não reservada");
        }
        if(this.clientes!=null){
            for (int i=0;i<this.clientes.length;i++){
                System.out.println(this.clientes[i].getNome());
            }
        }

    }

    public void divisaoDaConta(){
        Scanner ler = new Scanner(System.in);
        int numClientes=0;
        double valor_cliente=0;

        System.out.println("Quantas pessoas dividirão a conta?");
        numClientes=ler.nextInt();

        valor_cliente=getValorTotal()/numClientes;

        System.out.println("Cada cliente pagara: "+valor_cliente);
    }

    public void DezPorcentoGarcom(){
        double valor=0, comando=0;
        Scanner ler = new Scanner(System.in);
        System.out.println(getBebidas().calcular10porcento());
        System.out.println(getComidas().calcular10porcento());
        valor=getBebidas().calcular10porcento()+getComidas().calcular10porcento();
        System.out.println("Deseja adicionar os 10% ao valor final da conta?\n1-sim 0-nao");
        comando=ler.nextInt();

        if(comando==1){
            setValorTotal(getValorTotal()+valor);
        }
        System.out.println(valor);
    }

    public void listar_clientes(){
        for(int i=0;i<this.getClientes_geral().length;i++){
            System.out.println(this.getClientes(i).getNome());
        }
    }

    public void finalizar_reserva(){
        double precog=0, precoml=0;
        setData(null);
        setReserva(false);
        setNumPessoas(0);
        setValorTotal(0);
        precog=getComidas().getValorDoGrama();
        precoml=getBebidas().getPrecodoml();
        comidas=new ComandaComida(precog);
        bebidas=new ComandaBebida(precoml);
        clientes=new Cliente[0];
    }

}
