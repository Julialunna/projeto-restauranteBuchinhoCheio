import java.util.Scanner; 
public class ComandaComida extends Comanda {
    protected double quantidadeGramas;
    //valor do grama do self-service
    protected double valorDoGrama;
    protected String acrescimos=" ";
    protected double valorAcrescimos=0;

    public ComandaComida(double precog){
        setValorDoGrama(precog);
    }

    public double getQuantidadeGramas() {
        return quantidadeGramas;
    }
    public void setQuantidadeGramas(double quantidadeGramas) {
        this.quantidadeGramas = quantidadeGramas;
    }
    public String getAcrescimos() {
        return acrescimos;
    }
    public void setAcrescimos(String acrescimos) {
        this.acrescimos = acrescimos;
    }
    public double getValorAcrescimos() {
        return valorAcrescimos;
    }
    public void setValorAcrescimos(double valorAcrescimos) {
        this.valorAcrescimos = valorAcrescimos;
    }
    public double getValorDoGrama() {
        return valorDoGrama;
    }
    public void setValorDoGrama(double valorDoGrama) {
        this.valorDoGrama = valorDoGrama;
    }

    @Override
    public void anotar_pedido(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o pedido?");
        setConsumo(getConsumo()+ler.nextLine());
        System.out.println("Qual a quantidade?");
        setQuantidadeGramas(ler.nextDouble());
        setValor(getValor()+getQuantidadeGramas()/100*getValorDoGrama());
        setConsumo(getConsumo()+" "+getQuantidadeGramas()+" g, ");
    }

    @Override
    public void listarConsumo(){
        System.out.println("Consumo: ");
        System.out.println(this.getConsumo());
        System.out.println("Acrescimos: ");
        System.out.println(this.getAcrescimos());
        System.out.println("Valor: ");
        System.out.println(this.getValor());
    }

    public void adicionar_acrescimo(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o acrescimo?");
        setAcrescimos(getAcrescimos()+ler.nextLine()+", ");
        System.out.println("Qual o valor?");
        setValorAcrescimos(getValorAcrescimos()+ler.nextDouble());
        setValor(getValor()+getValorAcrescimos());
        System.out.println(getValorAcrescimos());
    }
}
