/*
    Trabalho prático 3
    Para fixar os conceitos fundamentais de Semáforos, crie um exemplo simples de aplicação Java que seja capaz de demonstrar:
    O uso de uma Seção Crítica SEM controle;
    O uso de uma Seção Crítica COM controle

    Nome: João Ryan dos Santos
    Matricula: 239

    Logica usada para projeto foi utilizar um contador compartilhado por varias threads em que o contador e incrementado varias vezes, 
    sem controle ocorrer uma condição de corrida (race condition), onde duas ou mais threads tentam acessar e modificar o contador ao mesmo tempo. 
    Isso pode levar a resultados inconsistentes.

    com controle usamos semáforo (Semaphore) para controlar o acesso à seção crítica, que é a operação de incrementar o contador. O semáforo é inicializado com uma permissão (1), 
    o que permite que apenas uma thread acesse a seção crítica por vez. As outras threads aguardam a liberação do semáforo.
*/

import java.util.concurrent.Semaphore;

public class ComControle {

    void wait(int s) {
        while (s <= 0)
            ;
        s--;
    }

    void signal(int s) {
        s++;
    }

    private static int contador = 0;
    private static Semaphore semaforo = new Semaphore(1);

    public static void main(String[] args) {
        // Criando várias threads que incrementam o contador simultaneamente
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    incrementarComControle();
                }
            });
            thread.start();
        }

        // Aguardando todas as threads terminarem
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Resultado esperado é 500000, pois o semáforo garante o acesso exclusivo
        System.out.println("Contador: " + contador);
    }

    public static void incrementarComControle() {
        try {
            semaforo.acquire(); // Aguarda permissão para entrar na seção crítica
            contador++;
            semaforo.release(); // Libera a permissão para outros processos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
