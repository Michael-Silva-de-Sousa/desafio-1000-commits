import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PedidoSync {
    public void fazerPedido(String atendente, String evento) throws InterruptedException {
        log.info("Atendente {} está preparando: {}", atendente, evento);
        //O Sleep representa o tempo que leva para o evento acontecer
        Thread.sleep(1000);
        log.info("O Atentende {} finalizou: {}", atendente, evento);
    }
}
