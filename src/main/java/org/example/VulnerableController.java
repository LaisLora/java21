package org.example;

public class VulnerableController {
    public static void main(String[] args) {
        // Verifica se foi passado algum argumento
        if (args.length < 1) {
            System.out.println("Uso: java org.example.VulnerableLocal <diretório>");
            return;
        }

        // Vulnerabilidade: Não sanitiza o input do usuário
        String directory = args[0];

        // Concatena a entrada para formar um comando a ser executado
        // (No Windows, use "dir"; em sistemas Unix-like, use "ls")
        String command = "dir " + directory;

        try {
            // Executa o comando sem validação – vulnerabilidade de command injection
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            // Imprime o comando executado para efeito de demonstração
            System.out.println("Comando executado: " + command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
