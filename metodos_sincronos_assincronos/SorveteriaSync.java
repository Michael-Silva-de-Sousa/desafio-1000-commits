import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Nese exemplo é demontrado o comportamento comum de
 * uma execução sincrona. Esse tipo de processamento ocorre
 * quando um processo executa uma ação seguida da outra, como se
 * fosse uma fila, ou seja, primeiro ocorre um evento para depois
 * ocorrer o próximo e assim sucessivamente até o final do processamento.
 * </p>
 */
@Slf4j
public class SorveteriaSync {

    /**<
     * <p>
        Vamos supor que você solicitou um sorvete de casquinha em
        uma sorveteria, o atendente 1 pega a casquinha e te chama pelo
        nome e te entrega a casquinha. Passado alguns segundos o atendente 2
        abre o pote do sorvete e pega uma bola de sorvete e te chama novamente
        colocando essa bola sobre a casquinha. Aqui ocorreram dois eventos um
        seguido do outro, primeiro um teve que acontecer para depois o outro acontecer
        esse é um exemplo de processo sincrono. E vamos colocar mais um evento do atendente 3
        que é o que recebe o pagamento.
        Primeiro ocorre o evento do atentede 1.
        Segundo ocorre o evento do atendente 2.
        Terceiro ocorre o evento do atendente 3.
     </p>
    */

    // O método Main é uma thread que inicia e termina um processo.
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Pedido.fazerPedido("A", "casquinha");
        Pedido.fazerPedido("B", "bola sorvete");
        Pedido.fazerPedido("C", "pagamento");

        long end = System.currentTimeMillis();

        log.info("Tempo de execução em segundos: {}", (end - start) / 1000.0);
    }

    static class Pedido {
        public static void fazerPedido(String atendente, String evento) throws InterruptedException {
            log.info("Atendente {} está preparando: {}", atendente, evento);
            //O Sleep representa o tempo que leva para o evento acontecer
            Thread.sleep(1000);
            log.info("O Atentende {} finalizou: {}", atendente, evento);
        }
    }
}
