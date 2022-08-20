import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PedidoAsync implements Runnable {

    private String atendente;
    private String evento;

    public PedidoAsync(String atendente, String evento) {
        this.atendente = atendente;
        this.evento = evento;
    }

    @Override
    public void run() {
        log.info("Atendente {} está preparando: {}", atendente, evento);
        try {
            //O Sleep representa o tempo que leva para o evento acontecer
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            log.error("", ex);
        }
        log.info("O Atentende {} finalizou: {}", atendente, evento);
    }
}
