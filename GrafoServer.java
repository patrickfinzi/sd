package t1sd;
/**
 *
 * @author patrick
 */
import java.util.ArrayList;
import t1sd.*;

import org . apache . thrift . server . TServer ;
import org . apache . thrift . transport . TServerSocket ;
import org . apache . thrift . transport . TServerTransport ;
import org . apache . thrift . server . TServer . Args ;
import org . apache . thrift . server . TSimpleServer ;
import org . apache . thrift . server . TThreadPoolServer ;
import java . util . HashMap ;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GrafoServer {
    public static void main ( String [] args ) {
        try {
            TServerTransport serverTransport = new TServerSocket (9090) ;
            Handler h = new Handler();
            Grafosd.Processor processor = new Grafosd.Processor(h);
            //TServer server = new TSimpleServer ( new Args ( serverTransport ).processor ( processor ) );
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            Semaphore semaforo = new Semaphore(1,true);
            T1SD arq = new T1SD();
            List<Vertice> vertices = new ArrayList<Vertice>();
            List<Aresta> arestas = new ArrayList<Aresta>();
            Grafo g = new Grafo(vertices,arestas);
            h.criaGrafo(g);
            System.out.println(" Starting the simple server ... ");
            semaforo.acquire();
            server.serve();
            semaforo.release();
            arq.salvar(g,"home/patrick/texto.txt");
            System.out.println("cabo");
        }catch ( Exception x) {
            x. printStackTrace () ;
           
        }
    }
}
