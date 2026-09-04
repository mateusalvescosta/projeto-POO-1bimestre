import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaImoveis {
    public static void main(String[] args) {
        sistema();
    }

    private static void sistema() {
        List<Imovel> imoveis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Imóveis do Mateus Alves Costa!");

        do {
            System.out.println("1. Cadastrar Imóvel");
            System.out.println("2. Listar Imóveis");
            System.out.println("3. Calcular Valor de um Imóvel");
            System.out.println("4. Buscar Imóvel por Endereço");
            System.out.println("5. Remover Imóvel");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarImovel(imoveis, sc);
                case 2 -> listarImoveis(imoveis, sc);
                case 3 -> calcularValorImovel(imoveis, sc);
                case 4 -> buscarImovel(imoveis, sc);
                case 5 -> removerImovel(imoveis, sc);
                case 0 -> encerrarSistema();
                default -> System.out.println("Opção inválida!");
            }

        } while (true);
    }

    private static void cadastrarImovel(List<Imovel> imoveis, Scanner sc) {
        limparTerminal();
        System.out.println("Escolha o tipo de imóvel que deseja cadastrar:");
        System.out.println("1. Casa");
        System.out.println("2. Apartamento");
        int tipoImovel = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha
        limparTerminal();

        if (tipoImovel == 1) {
            // Lógica para cadastrar uma casa
            System.out.println("Digite o endereço da casa:");
            String endereco = sc.nextLine();
            limparTerminal();
            System.out.println("Digite a área da casa (em m²):");
            double areaM2 = sc.nextDouble();
            limparTerminal();
            System.out.println("Digite o valor por m² da casa:");
            double valorM2 = sc.nextDouble();
            limparTerminal();
            System.out.println("Digite o ano de construção da casa:");
            int anoConstrucao = sc.nextInt();
            limparTerminal();
            System.out.println("Digite a área não construída da casa (em m²):");
            double areaM2NaoConstruida = sc.nextDouble();
            limparTerminal();
            System.out.println("A casa possui muro? (true/false):");
            boolean possuiMuro = sc.nextBoolean();
            sc.nextLine(); // Consumir a quebra de linha
            limparTerminal();

            Casa casa = new Casa(endereco, areaM2, valorM2, anoConstrucao, possuiMuro, areaM2NaoConstruida);
            imoveis.add(casa);
            System.out.println("Casa cadastrada com sucesso!\n");

        } else if (tipoImovel == 2) {
            // Lógica para cadastrar um apartamento
            System.out.println("Digite o endereço do apartamento: ");
            String endereco = sc.nextLine();
            limparTerminal();
            System.out.println("Digite a área do apartamento (em m²): ");
            double areaM2 = sc.nextDouble();
            limparTerminal();
            System.out.println("Digite o valor por m² do apartamento: ");
            double valorM2 = sc.nextDouble();
            limparTerminal();
            System.out.println("Digite o ano de construção do apartamento: ");
            int anoConstrucao = sc.nextInt();
            limparTerminal();
            System.out.println("Digite o andar do apartamento: ");
            int andar = sc.nextInt();
            limparTerminal();
            System.out.println("Digite a taxa de condomínio do apartamento: ");
            double taxaCondominio = sc.nextDouble();
            sc.nextLine(); // Consumir a quebra de linha
            limparTerminal();

            Apartamento apartamento = new Apartamento(endereco, areaM2, valorM2, anoConstrucao, andar, taxaCondominio);
            imoveis.add(apartamento);
            System.out.println("Apartamento cadastrado com sucesso!\n");
        } else {
            System.out.println("Tipo de imóvel inválido!\n");
            cadastrarImovel(imoveis, sc);
        }
    }

    private static void listarImoveis(List<Imovel> imoveis, Scanner sc) {
        limparTerminal();
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.\n");
            return;
        }

        System.out.println("Lista de Imóveis Cadastrados:");
        System.out.println("---------------------------");

        for (Imovel imovel : imoveis) {
            imovel.exibirInformacoes();
            System.out.println("---------------------------");
        }
    }

    private static void calcularValorImovel(List<Imovel> imoveis, Scanner sc) {
        limparTerminal();
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.\n");
            return;
        }

        System.out.println("Escolha o imóvel para calcular o valor:");
        for (int i = 0; i < imoveis.size(); i++) {
            System.out.println((i + 1) + ". " + imoveis.get(i).getEndereco());
        }
        int escolha = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha

        if (escolha < 1 || escolha > imoveis.size()) {
            limparTerminal();
            System.out.println("Escolha inválida!\n");
            calcularValorImovel(imoveis, sc);
        }

        Imovel imovelSelecionado = imoveis.get(escolha - 1);

        limparTerminal();
        System.out.println("Desconto? (s/n)");
        String resposta = sc.nextLine();
        limparTerminal();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Digite o valor do desconto (em R$) ou 0 se não houver desconto:");
            double desconto = sc.nextDouble();
            sc.nextLine(); // Consumir a quebra de linha
            double valorTotal = imovelSelecionado.calcularValor(desconto);
            limparTerminal();
            System.out.println("O valor total do imóvel " + imovelSelecionado.getEndereco() + " é: R$ " + valorTotal + "\n");
            return;
        }

        limparTerminal();
        System.out.println("Parcelado? (s/n)");
        resposta = sc.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            limparTerminal();
            System.out.println("Digite o valor da entrada (em R$):");
            double entrada = sc.nextDouble();
            limparTerminal();
            System.out.println("Digite a taxa de juros (em %):");
            double juros = sc.nextDouble();
            limparTerminal();
            sc.nextLine(); // Consumir a quebra de linha
            double valorTotal = imovelSelecionado.calcularValor(entrada, juros);
            limparTerminal();
            System.out.println("O valor total do imóvel " + imovelSelecionado.getEndereco() + " é: R$ " + valorTotal + "\n");
            return;
        }

        double valorTotal = imovelSelecionado.calcularValor();
        limparTerminal();
        System.out.println("O valor total do imóvel " + imovelSelecionado.getEndereco() + " é: R$ " + valorTotal + "\n");
    }

    private static void buscarImovel(List<Imovel> imoveis, Scanner sc) {
        limparTerminal();
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
            return;
        }

        System.out.println("Digite o endereço do imóvel que deseja buscar:");
        String enderecoBusca = sc.nextLine();

        limparTerminal();
        boolean encontrado = false;
        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equalsIgnoreCase(enderecoBusca)) {
                System.out.println("Imóvel encontrado:");
                imovel.exibirInformacoes();
                System.out.println("---------------------------");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            limparTerminal();
            System.out.println("Nenhum imóvel encontrado com o endereço informado.");
        }
    }

    private static void removerImovel(List<Imovel> imoveis, Scanner sc) {
        limparTerminal();
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.\n");
            return;
        }

        System.out.println("Escolha o imóvel para remover:");
        for (int i = 0; i < imoveis.size(); i++) {
            System.out.println((i + 1) + ". " + imoveis.get(i).getEndereco());
        }
        int escolha = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha

        if (escolha < 1 || escolha > imoveis.size()) {
            System.out.println("Escolha inválida!\n");
            removerImovel(imoveis, sc);
        }

        Imovel imovelRemovido = imoveis.remove(escolha - 1);
        limparTerminal();
        System.out.println("Imóvel " + imovelRemovido.getEndereco() + " removido com sucesso!\n");
    }

    private static void encerrarSistema() {
        limparTerminal();
        System.out.println("Encerrando o sistema...");
        System.exit(0);
    }

    private static void limparTerminal() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
    }

}