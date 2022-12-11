import java.util.Scanner; 
abstract public class Comanda {
    protected String consumo = "";
    protected double valor;

    public String getConsumo() {
        return consumo;
    }
    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void anotar_pedido(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o pedido?");
        setConsumo(getConsumo()+ler.nextLine()+", ");
        System.out.println("Qual o valor?");
        setValor(getValor()+ler.nextDouble());
    }

    public double calcular10porcento(){
        return getValor()*0.10;
    }

    public double dividirConta(int numPessoas){
        double valor_individual=0;
        valor_individual=getValor()/numPessoas;
        return valor_individual;
    }

    public void listarConsumo(){
        System.out.println("Consumo: ");
        System.out.println(this.getConsumo());
        System.out.println("Valor: ");
        System.out.println(this.getValor());
    }


}
