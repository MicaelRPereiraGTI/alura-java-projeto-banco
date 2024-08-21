import java.util.Scanner;

public class Main {
    private static String nome;
    private static String tipoConta;
    private static double saldo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nome = "Micael Pereira";
        tipoConta = "Corrente";
        saldo = 6000.00;
        int opt;

        String extratoInicial = """
        ***********************
        
        Dados iniciais do cliente:

        Nome:""" + nome + """
        
        Tipo conta:""" + tipoConta + """
        
        Saldo inicial: R$""" + String.format("%.2f", saldo) + """
        
        
        ***********************

        Operações

        1- Consultar saldos
        2- Receber valor
        3- Transferir valor
        4- Sair

        Digite a opção desejada:""";

        String menu = """
        Operações

        1- Consultar saldos
        2- Receber valor
        3- Transferir valor
        4- Sair

        Digite a opção desejada:""";

        System.out.println(extratoInicial);
        opt = sc.nextInt();

        while (opt != 4) {

            switch (opt){
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    recebeTransferencia();
                    System.out.println("Saldo: R$" + String.format("%.2f", saldo));
                    break;
                case 3:
                    fazTransferencia();
                    System.out.println("Saldo: R$" + String.format("%.2f", saldo));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println(menu);
            opt = sc.nextInt();
        }
    }

    public static double recebeTransferencia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor a receber:");
        double valorRecebido = sc.nextDouble();
        saldo += valorRecebido;
        return saldo;
    }

    public static void consultarSaldo(){
        System.out.println("""
                ***********************
        
                Saldo em Conta:
        

                Saldo: R$""" + String.format("%.2f", saldo) + """
                
                       
                ***********************
                """);
    }


    public static double fazTransferencia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor a transferir:");
        double valorTransferido = sc.nextDouble();
        if (valorTransferido <= saldo){
            saldo -= valorTransferido;
        }else {
            System.out.println("Não há saldo para realizar a transferência.");
        };
        return saldo;
    }
}