/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prjentradasaidadedados;

import java.util.Scanner;

/**
 *
 * @author mpisc
 */
public class PrjEntradaSaidaDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char opcao;
        do {
            int idade;
            String nome;
            double renda;
            System.out.print("Nome........: ");
            nome = entrada.nextLine();
            System.out.print("Idade.......: ");
            //idade = entrada.nextInt();
            idade = Integer.parseInt(entrada.nextLine());
            System.out.print("Renda.......: ");
            //renda = entrada.nextDouble();
            renda = Double.parseDouble(entrada.nextLine());
            System.out.print("Sexo (M/F)..: ");
            char sexo = entrada.nextLine().charAt(0);
            String sexoExtenso = null; //sexo == 'm ? "Masculino" : "Feminino";
            sexoExtenso = sexo == 'm' ? "Masculino" : "Feminino";

            System.out.println(nome + " a sua idade é " + idade + " "
                    + ", o seu sexo é " + 
                    sexoExtenso
                    + " e a sua renda é " + renda) ;
            
            System.out.print("Executar novamente? (s/n)? ");
            opcao = entrada.nextLine().charAt(0);
            
        } while (opcao == 's' || opcao == 'S');
    }
    
}
