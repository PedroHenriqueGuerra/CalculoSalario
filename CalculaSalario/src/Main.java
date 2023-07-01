import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String salario;
        double descontoInss;
        double descontoImpRenda;
        double salarioLiquido;
        double [] listaSalarios = new double [5];

        for(int i = 0; i < listaSalarios.length; i++){
            if(i == 0){
                System.out.println("Informe o valor do salário: ");
            }
            else System.out.println("Informe o valor do próximo salário: ");
            salario = sc.nextLine();

            while (!salario.matches("-?\\d+(\\.\\d+)?") || Double.parseDouble(salario) < 0){
                System.out.println("Informe um valor válido para o salário: ");
                salario = sc.nextLine();
            }

            listaSalarios[i] = Double.parseDouble(salario);
        }


        for (double listaSalario : listaSalarios) {
            descontoInss = descontoInss(listaSalario);
            descontoImpRenda = descontoImpRenda(listaSalario);
            salarioLiquido = listaSalario - (descontoInss + descontoImpRenda);

            System.out.printf("O salário bruto é de: %.2f%n", listaSalario);
            System.out.printf("Foi pago ao INSS: %.2f%n", descontoInss);
            System.out.printf("Foi pago de imposto de renda: %.2f%n", descontoImpRenda);
            System.out.printf("O salário liquido é de: %.2f%n", salarioLiquido);
            System.out.println();
        }

        sc.close();
    }

    public static double descontoInss(double salario){
        double desconto;
        if(salario <= 1212.00){
            desconto = salario * (7.50 / 100.00);
        }
        else if (salario >= 1212.01 && salario <= 2427.35) {
            desconto = salario * (9.00 / 100.00);
        }
        else if (salario >= 2427.36 && salario <= 3641.03) {
            desconto = salario * (12.00 / 100.00);
        }
        else {
            desconto = salario * (14.00 / 100.00);
        }
        return desconto;
    }

    public static double descontoImpRenda(double salario){
        double desconto;
        if (salario <= 1903.98){
            desconto = 0.00;
        }
        else if (salario >= 1903.99 && salario <= 2826.65) {
            desconto = salario * (7.50 / 100.00);
        }
        else if (salario >= 2826.66 && salario <= 3751.05) {
            desconto = salario * (15.00 / 100.00);
        }
        else if (salario >= 3751.06 && salario <= 4664.68) {
            desconto = salario * (22.50 / 100.00);
        }
        else {
            desconto = salario * (27.50 / 100.00);
        }
        return desconto;
    }

}