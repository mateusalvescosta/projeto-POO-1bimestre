public class Imovel {
    private String endereco;
    private double areaM2;
    private double valorM2;
    private int anoConstrucao;

    public Imovel(){
    }

    public Imovel(String endereco, double areaM2, double valorM2, int anoConstrucao) {
        this.endereco = endereco;
        this.areaM2 = areaM2;
        this.valorM2 = valorM2;
        this.anoConstrucao = anoConstrucao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco == null || endereco.isEmpty()){
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    public double getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(double areaM2) {
        if(areaM2 <= 0){
            throw new IllegalArgumentException("Área não pode ser nula ou negativa.");
        }
        this.areaM2 = areaM2;
    }

    public double getValorM2() {
        return valorM2;
    }

    public void setValorM2(double valorM2) {
        if(valorM2 <= 0){
            throw new IllegalArgumentException("Valor por metro quadrado não pode ser nulo ou negativo.");
        }
        this.valorM2 = valorM2;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        if(anoConstrucao <= 0){
            throw new IllegalArgumentException("Ano de construção não pode ser nulo ou negativo.");
        }
        this.anoConstrucao = anoConstrucao;
    }

    public double calcularValor() {
        return areaM2 * valorM2;
    }

    public double calcularValor(double desconto) {
        return (areaM2 * valorM2) - desconto;
    }

    public double calcularValor(double entrada, double juros){
        if(juros < 0){
            throw new IllegalArgumentException("Juros não pode ser negativo.");
        }

        if(entrada < 0){
            throw new IllegalArgumentException("Entrada não pode ser negativa.");
        }
        
        return ((areaM2 * valorM2) - entrada) * (1 + (juros / 100));
    }

    public void exibirInformacoes() {
        System.out.println("Endereço: " + endereco);
        System.out.println("Área (m²): " + areaM2);
        System.out.println("Valor por m²: " + valorM2);
        System.out.println("Ano de Construção: " + anoConstrucao);
        System.out.println("Valor Total: " + calcularValor());
    }

    
}
