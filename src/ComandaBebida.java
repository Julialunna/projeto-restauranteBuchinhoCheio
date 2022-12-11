import java.util.Scanner; 
public class ComandaBebida extends Comanda {
    protected double quantidademl;
    protected double precodoml;

    public ComandaBebida(double precoml){
        setPrecodoml(precoml);
    }

    public double getPrecodoml() {
        return precodoml;
    }
    public void setPrecodoml(double precodoml) {
        this.precodoml = precodoml;
    }
    //valor por 100 ml = 2
    public double getQuantidademl() {
        return quantidademl;
    }
    public void setQuantidademl(double quantidademl) {
        this.quantidademl = quantidademl;
    }

    @Override
    public void anotar_pedido(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o pedido?");
        setConsumo(getConsumo()+ler.nextLine());
        System.out.println("Qual a quantidade?");
        setQuantidademl(ler.nextDouble());
        setValor(getValor()+getQuantidademl()/100*getPrecodoml());
        setConsumo(getConsumo()+" "+getQuantidademl()+" ml, ");
    }

}
