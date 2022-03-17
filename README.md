# Lista01
Lista 01 - Programação Concorrente

### Questão 1:
Threads Java podem assumir os seguintes estados: New, Runnable, Blocked, Waiting,
Timed_wating,Terminated

**New**: A thread dica neste estado após criar sua instância e antes de invocar o método
start();

**Runnable**: Indica que ela está executando na máquina virtual Java;

**Blocked**: Ainda está ativa, mas está à espera por algum recurso que está em uso por outra
thread;

**Waiting**: Quando neste estado, ela está à espera por tempo indeterminado pelo fato de
outra thread ter executado uma determinada ação.
Isto ocorre quando se invoca o método wait() ou join(), por exemplo;

**Timed_Waiting**: Neste estado a thread está à espera de uma operação por um tempo
pré-determinado.
Por exemplo, esta situação ocorre ao invocar métodos como Thread.sleep(sleeptime),
wait(timeout) ou join(timeout);

**Terminated**: Este estado sinaliza que o método run() finalizou.
