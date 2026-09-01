public class Casa extends Imovel{
    private boolean possuiMuro;
    private double areaM2NaoConstruida;

    public Casa(){
    }

    public Casa(String endereco, double areaM2, double valorM2, int anoConstrucao, boolean possuiMuro, double areaM2NaoConstruida) {
        super(endereco, areaM2, valorM2, anoConstrucao);
        this.possuiMuro = possuiMuro;
        this.areaM2NaoConstruida = areaM2NaoConstruida;
    }

    public boolean possuiMuro() {
        return possuiMuro;
    }

    public void setPossuiMuro(boolean possuiMuro) {
        this.possuiMuro = possuiMuro;
    }

    public double getAreaM2NaoConstruida() {
        return areaM2NaoConstruida;
    }

    public void setAreaM2NaoConstruida(double areaM2NaoConstruida) {
        if(areaM2NaoConstruida < 0 && areaM2NaoConstruida > getAreaM2()){
            throw new IllegalArgumentException("Área não construída não pode ser negativa ou maior que a área total.");
        }
        this.areaM2NaoConstruida = areaM2NaoConstruida;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Possui Muro: " + (possuiMuro ? "Sim" : "Não"));
        System.out.println("Área Não Construída: " + areaM2NaoConstruida);
    }
}
