
public class Personagem {
    
    int idper;
    String nome;
    String classe;
    int nivel;
    static int proxIdPer = 0;
    String grupo;
    
    Personagem(String nome, String classe, int nivel) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        idper = ++proxIdPer;       
        
        
    }
        
        public void apresentar(){
            System.out.println(this.nome + ", " + this.classe + " Nível " + this.nivel);            
        }
             
           
}        
   
