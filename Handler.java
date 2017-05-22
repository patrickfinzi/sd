/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1sd;

import java.util.Iterator;

/**
 *
 * @author patrick
 */
public class Handler implements Grafosd.Iface{
    Grafo g;
    
    @Override
    public void criaGrafo(Grafo g){
        this.g=g;
    }
    
    @Override
    public void addVertice(long nome, long cor, java.lang.String descricao, double peso){
        int verifica=0;
        for(Vertice w : g.vertices){
            if(w.nome==nome)
                verifica=1;
        }
        if(verifica==0){
            Vertice v = new Vertice(nome,cor,descricao,peso);
            this.g.vertices.add(v);
        }
        else
            System.out.println("Vertice ja existe");
    }
    
    @Override
    public void addAresta(long id, long origem, long destino, double peso, long flag, java.lang.String descricao){
        int verifica=0;
        for(Vertice v : g.vertices){
            if(v.nome==origem)
                verifica++;
            if(v.nome==destino)
                verifica++;
        }
        if(verifica==2){
            Aresta a = new Aresta(id,origem,destino,peso,flag,descricao);
            g.arestas.add(a);
            for(Vertice v: g.vertices){
                if(v.nome==origem)
                    v.adj.add(a);
            }
            if(flag==1){
                Aresta b = new Aresta(id,destino,origem,peso,flag,descricao);
                g.arestas.add(b);
                for(Vertice v: g.vertices){
                    if(v.nome==destino)
                        v.adj.add(b);
                }
            }
        }
        else
            System.out.println("Um ou mais vertices nao estao no grafo");
    }
    
    @Override
    public void imprimeGrafo(){
        Vertice u = new Vertice(-10,0,"balela",10);
        for(Vertice v: g.vertices){
            System.out.print(v.nome);
            System.out.print("->");
            for(Aresta a : v.adj){
                u.nome = a.destino;
                System.out.print(u.nome);
                System.out.print(",");
            }
            System.out.print("\n");
        }
    }
    
    @Override
    public void removeVertice(long nome){
        for(Vertice v : g.vertices){
            if(v.nome==nome)
                v.adj.clear();
        }
        for(Iterator<Aresta> i=g.arestas.iterator();i.hasNext();){
            Aresta a = i.next();
            if(a.origem==nome || a.destino==nome)
                i.remove();
        }
        for(Vertice v : g.vertices){
            for(Iterator<Aresta> i=v.adj.iterator();i.hasNext();){
                Aresta a = i.next();
                if(a.origem==nome || a.destino==nome)
                    i.remove();
            }
        }
        for(Iterator<Vertice> i=g.vertices.iterator();i.hasNext();){
                Vertice v = i.next();
                if(v.nome==nome)
                    i.remove();
        }
        System.out.println("Vertice removido");
    }
    
    @Override
    public void removeAresta(long id){
        for(Iterator<Aresta> i=g.arestas.iterator();i.hasNext();){
                Aresta a = i.next();
                if(a.id==id)
                    i.remove();
        }
        for(Vertice v : g.vertices){
            for(Iterator<Aresta> i=v.adj.iterator();i.hasNext();){
                Aresta a = i.next();
                if(a.id==id)
                    i.remove();
            }
        }
        System.out.println("Aresta removida");
    }
    
    @Override
    public void modificaVertice(long nome, long cor, java.lang.String descricao, double peso){
        int verifica=0;
        for(Vertice v : g.vertices){
            if(v.nome==nome){
                v.cor=cor;
                v.descricao=descricao;
                v.peso=peso;
                verifica=1;
            }
        }
        if(verifica==1)
            System.out.println("Vertice modificado");
        else
            System.out.println("Vertice não modificado");
    }
    
    @Override
    public void modificaAresta(long id, double peso, java.lang.String descricao){
        int verifica=0;
        for(Aresta a : g.arestas){
            if(a.id==id){
                a.peso=peso;
                a.descricao=descricao;
                verifica=1;
            }
        }
        if(verifica==1)
            System.out.println("Aresta modificada");
        else
            System.out.println("Aresta nao modificada");
    }
    
    @Override
    public void listaVertice(long id){
        long b=0;
        long c=0;
        int verifica=0;
        for(Aresta a : g.arestas){
            if(a.id==id){
                b=a.origem;
                c=a.destino;
                verifica=1;
            }
        }
        if(verifica==1)
            System.out.println("Origem "+b+" Destino "+c);
        else
            System.out.println("Aresta nao se encontra");
    }
    
    @Override
    public void listaAresta(long nome){
        int verifica=0;
        for(Vertice v : g.vertices){
            if(v.nome==nome){
                verifica=1;
                for(Aresta a : v.adj){
                    System.out.println(a.id);
                }
            }
        }
        if(verifica==0)
            System.out.println("Vertice nao se encontra");
    }
    
    @Override
    public void listaVizinhos(long nome){
        int verifica=0;
        for(Vertice v : g.vertices){
            if(v.nome==nome){
                verifica=1;
                for(Aresta a : v.adj){
                    System.out.println(a.destino);
                }
            }
        }
        if(verifica==0)
            System.out.println("Vertice nao se encontra");
    }
    
    @Override
    public void lerAresta(long id){
        System.out.println("alameda");
    }
    
    @Override
    public void lerVertice(long nome){
        System.out.println("alameda");
    }
}
