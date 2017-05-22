package t1sd;
/**
 *
 * @author patrick
 */
import t1sd.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import org.apache.thrift.TException ;
import org.apache.thrift.transport.TTransport ;
import org.apache.thrift.transport.TSocket ;
import org.apache.thrift.protocol.TProtocol ;
import org.apache.thrift.protocol.TBinaryProtocol ;

public class GrafoClient {
    public static void main ( String [] args ) throws InterruptedException {
        try{
            TTransport transport = new TSocket("localhost",9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol( transport );
            Grafosd.Client client = new Grafosd.Client(protocol);
            int i=-1;
            long nomeV;
            long cor;
            String descricao;
            long flag;
            long id;
            long origem;
            long destino;
            double peso;
            Scanner ler = new Scanner(System.in);
            while(i!=0){
                System.out.println("Escolha a opcao:");
                System.out.println("1- adicionar vertice");
                System.out.println("2- adicionar aresta");
                System.out.println("3- remover vertice");
                System.out.println("4- remover aresta");
                System.out.println("5- imprimi grafo");
                System.out.println("6- modificar vertice");
                System.out.println("7- modificar aresta");
                System.out.println("8- lista vertices da aresta");
                System.out.println("9- lista arestas de um vertice");
                System.out.println("10- lista vizinhos de um vertice");
                i=ler.nextInt();
                if(i==1){
                    System.out.println("Informe o nome,cor,descricao e peso");
                    nomeV=ler.nextLong();
                    cor=ler.nextLong();
                    descricao=ler.next();
                    peso=ler.nextDouble();
                    client.addVertice(nomeV, cor, descricao, peso);
                }
                if(i==2){
                    System.out.println("Informe a id,origem,destino,peso,flag,descricao");
                    id=ler.nextLong();
                    origem=ler.nextLong();
                    destino=ler.nextLong();
                    peso=ler.nextDouble();
                    flag=ler.nextLong();
                    descricao=ler.next();
                    client.addAresta(id, origem, destino, peso, flag, descricao);
                }
                if(i==3){
                    System.out.println("Informe o nome do vertice a ser removido");
                    nomeV=ler.nextLong();
                    client.removeVertice(nomeV);
                }
                if(i==4){
                    System.out.println("Informe o id da aresta a ser removida");
                    id=ler.nextLong();
                    client.removeAresta(id);
                }
                if(i==5)
                    client.imprimeGrafo();
                if(i==6){
                    System.out.println("Informe o nome,cor,descricao,peso do vertice a ser modificado");
                    nomeV=ler.nextLong();
                    cor=ler.nextLong();
                    descricao=ler.next();
                    peso=ler.nextDouble();
                    client.modificaVertice(nomeV, cor, descricao, peso);
                }
                if(i==7){
                    System.out.println("Informe o id,peso,descricao da aresta a ser modificado");
                    id=ler.nextLong();
                    peso=ler.nextDouble();
                    descricao=ler.next();
                    client.modificaAresta(id, peso, descricao);
                }
                if(i==8){
                    System.out.println("Informe o id  da aresta");
                    id=ler.nextLong();
                    client.listaVertice(id);
                }
                if(i==9){
                    System.out.println("Informe o nome do vertice");
                    nomeV=ler.nextLong();
                    client.listaAresta(nomeV);
                }
                if(i==10){
                    System.out.println("Informe o nome do vertice");
                    nomeV=ler.nextLong();
                    client.listaVizinhos(nomeV);
                }
            }
            transport.close() ;
        } catch ( TException x ) {
        x.printStackTrace() ;
        }
    }
}
