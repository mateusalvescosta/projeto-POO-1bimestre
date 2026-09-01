public class Apartamento extends Imovel {
    private int andar;
    private double taxaCondominio;

    public Apartamento() {
    }

    public Apartamento(String endereco, double areaM2, double valorM2, int anoConstrucao, int andar, double taxaCondominio) {
        super(endereco, areaM2, valorM2, anoConstrucao);
        this.andar = andar;
        this.taxaCondominio = taxaCondominio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        if(andar <= 0){
            throw new IllegalArgumentException("Andar não pode ser negativo ou igual a zero.");
        }
        this.andar = andar;
    }

    public double getTaxaCondominio() {
        return taxaCondominio;
    }

    public void setTaxaCondominio(double taxaCondominio){
        if(taxaCondominio < 0){
            throw new IllegalArgumentException("Taxa de condomínio não pode ser negativa.");
        }
        this.taxaCondominio = taxaCondominio;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Andar: " + andar);
        System.out.println("Taxa de Condomínio: " + taxaCondominio);
    }

    
}
