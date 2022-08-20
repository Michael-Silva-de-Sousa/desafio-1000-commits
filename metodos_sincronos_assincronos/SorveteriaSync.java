import lombok.extern.slf4j.Slf4j;

import java.util.TreeMap;

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
        //true para executar o pedido no modo sincrono.
        //false para executar o pedido no modo assincrono.
        if(false) {

            PedidoSync pedidoSync = new PedidoSync();
            pedidoSync.fazerPedido("A", "casquinha");
            pedidoSync.fazerPedido("B", "bola sorvete");
            pedidoSync.fazerPedido("C", "pagamento");

        } else {

            PedidoAsync casquinha = new PedidoAsync("A", "casquinha");
            PedidoAsync bolaSorvete = new PedidoAsync("B", "bola sorvete");
            PedidoAsync pagamento = new PedidoAsync("C", "pagamento");

            Thread eventoCasquinha = new Thread(casquinha, "Thread-Casquinha");
            Thread eventoBolaSorvete = new Thread(bolaSorvete, "Thread-Bola-Sorvete");
            Thread eventoPagamento = new Thread(pagamento, "Thread-Pagamento");

            //eventoCasquinha.start(); Quando se usa o .run() a thread main é utilizada.
            eventoCasquinha.start();//Quando seu usa o .start() uma nova thread é criada.
            eventoBolaSorvete.start();
            eventoPagamento.start();
        }

        long end = System.currentTimeMillis();
        log.info("Tempo de execução em segundos: {}", (end - start) / 1000.0);
    }
}
