import java.util.ArrayList;

public class Grupo {
    
    int idgr;
    String nome;
    static int proxIdgr = 0;
    ArrayList<Personagem> membros;
    
    
    Grupo(String nome) {
        this.idgr = ++proxIdgr;
        this.nome = nome;
        this.membros = new ArrayList<Personagem>();
    }
    
    
    public void apresentar() {
        System.out.println("");
        System.out.println("Grupo " + idgr);
        System.out.println(nome);
        System.out.println("Membros: " + membros.size());
        
        if (!membros.isEmpty()) {            
            for (Personagem personagem : membros) {
                personagem.apresentar();
            }
        }
        System.out.println("--------------------------");
    }
    
    public void apresentarResumo() {
        System.out.println("Grupo " + idgr + "| " + nome + " | " + membros.size() + " membros");
        System.out.println("---------------------------");
    }

    public void adicionarMembro(Personagem personagem) {
        membros.add(personagem);
    }


}