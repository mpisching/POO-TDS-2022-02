/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prjentradasaidajoptionpane;

import javax.swing.JOptionPane;

/**
 *
 * @author mpisc
 */
public class PrjEntradaSaidaJOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int idade;
        String nome;
        double renda;
        
        nome = JOptionPane.showInputDialog("Nome: ");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        renda = Double.parseDouble(JOptionPane.showInputDialog("Renda"));
        char sexo = JOptionPane.showInputDialog("Sexo (M/F)").charAt(0);
        String sexoExtenso = sexo == 'm' ? "Masculino" : "Feminino";
        JOptionPane.showMessageDialog(null,
                nome + " a sua idade é " + idade + " "
                + ", o seu sexo é "
                + sexoExtenso
                + " e a sua renda é " + renda);
//        System.out.print("Idade.......: ");
//        //idade = entrada.nextInt();
//        idade = Integer.parseInt(entrada.nextLine());
//        System.out.print("Renda.......: ");
//        //renda = entrada.nextDouble();
//        renda = Double.parseDouble(entrada.nextLine());
//        System.out.print("Sexo (M/F)..: ");
//        char sexo = entrada.nextLine().charAt(0);
//        String sexoExtenso = null; //sexo == 'm ? "Masculino" : "Feminino";
//        sexoExtenso = sexo == 'm' ? "Masculino" : "Feminino";
//
//        System.out.println(nome + " a sua idade é " + idade + " "
//                + ", o seu sexo é "
//                + sexoExtenso
//                + " e a sua renda é " + renda);
    }

}
