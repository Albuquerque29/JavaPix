import java.util.Scanner;

/* PARA O SISTEMA DO JAVAPIX SER INICIADO É NECESSÁRIO QUE O NOME/CPF E SENHA DO CLIENTE ESTEJAM CORRETOS.
              NOME: Arthur Vinicius A. Dos Santos / CPF: 123.456.789-00 / SENHA:  123 */

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        String nomeCompleto = "Arthur Vinicius A. Dos Santos";
        String cpf = "123.456.789-00";
        String senhaCorreta = "123";
        String tipoConta = "Corrente";
        double saldoInicial = 2500.00;
        String entrada = """
                Olá!! Você está no JavaPix, o melhor sistema de pix em java.
                Nele Você poderá Transferir, Receber e conferir o seu saldo!
                digite | ok ou OK | para prosseguir!!
                """;
        int menu;

        System.out.println(entrada);

        String prosseguir = leitura.nextLine();

        if (prosseguir.equalsIgnoreCase("OK")) {

            // Loop de validação do nome, CPF e senha
            boolean dadosCorretos = false;  // Flag para saber se os dados estão corretos
            while (!dadosCorretos) {  // Continua até o usuário acertar nome/CPF e senha
                System.out.println("Informe o nome ou CPF da conta: ");
                String entradaNomeOuCpf = leitura.nextLine();

                // Verifica se o nome ou CPF estão corretos
                if (entradaNomeOuCpf.equalsIgnoreCase(nomeCompleto) || entradaNomeOuCpf.equals(cpf)) {
                    System.out.println("Informe a senha da conta: ");
                    String senhaDigitada = leitura.nextLine();

                    // Verifica se a senha está correta
                    if (senhaDigitada.equals(senhaCorreta)) {
                        System.out.println("Dados verificados com sucesso! Prosseguindo...");
                        dadosCorretos = true;  // Sai do loop quando acertar nome/CPF e senha
                    } else {
                        System.out.println("Senha incorreta. Tente novamente.");
                    }
                } else {
                    System.out.println("Nome ou CPF incorretos. Tente novamente.");
                }
            }

            // Exibição do menu após validação
            do {
                System.out.println("\n=======================================");
                System.out.printf("| %-35s |\n", "Sistema JavaPix");
                System.out.println("=======================================");
                System.out.printf("| Nome: %-26s |\n", nomeCompleto);
                System.out.printf("| CPF: %-30s |\n", cpf);
                System.out.printf("| Tipo Conta: %-23s |\n", tipoConta);
                System.out.printf("| Saldo Inicial: R$ %-17.2f |\n", saldoInicial);
                System.out.println("=======================================");
                System.out.printf("| %-35s |\n", "1 - Consultar Saldo");
                System.out.printf("| %-35s |\n", "2 - Receber Valor");
                System.out.printf("| %-35s |\n", "3 - Transferir Valor");
                System.out.printf("| %-35s |\n", "4 - Sair");
                System.out.println("=======================================");
                System.out.print("Escolha uma opção do menu: ");
                menu = leitura.nextInt();

                switch (menu) {
                    case 1:
                        // Consultar saldo
                        System.out.printf("Seu saldo atual é: R$ %.2f%n", saldoInicial);
                        break;
                    case 2:
                        // Receber valor
                        System.out.print("Digite o valor a ser recebido: R$ ");
                        double valorRecebido = leitura.nextDouble();
                        if (valorRecebido > 0) {
                            saldoInicial += valorRecebido;
                            System.out.printf("Recebimento de R$ %.2f realizado com sucesso! Saldo atualizado: R$ %.2f%n", valorRecebido, saldoInicial);
                        } else {
                            System.out.println("Valor inválido para recebimento.");
                        }
                        break;
                    case 3:
                        // Transferir valor
                        System.out.print("Digite o valor a ser transferido: R$ ");
                        double valorTransferido = leitura.nextDouble();
                        if (valorTransferido > 0 && valorTransferido <= saldoInicial) {
                            saldoInicial -= valorTransferido;
                            System.out.printf("Transferência de R$ %.2f realizada com sucesso! Novo saldo: R$ %.2f%n", valorTransferido, saldoInicial);
                        } else {
                            System.out.println("Valor inválido ou saldo insuficiente para transferência.");
                        }
                        break;
                    case 4:
                        // Sair
                        System.out.println("Saindo do sistema. Obrigado!");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (menu != 4);  // Fim do loop

        } else {
            System.out.println("Você precisa digitar 'OK' para prosseguir. Tente Novamente.");
        }

        leitura.close();  // Fecha o Scanner
    }
}