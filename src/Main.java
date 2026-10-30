import java.util.Scanner;
import java.util.ArrayList;

public class Main {

       public static void main(String[] args) {
           
                      
           ArrayList<Personagem> personagens = new ArrayList<>();
           ArrayList<Grupo> grupos = new ArrayList<>();
           Scanner scan0 = new Scanner(System.in);
           
           
           /*           TESTE APENAS           */
           
           Grupo coracaoPrata = new Grupo("Coração de Prata");
           Grupo arautos = new Grupo("Arautos");
           Grupo reinoHeton = new Grupo("Reino de Heton");
           Grupo desdunia = new Grupo("Desdunia");
           Grupo magosApocalipse = new Grupo("Magos do Apocalipse");
           
           grupos.add(coracaoPrata);
           grupos.add(arautos);
           grupos.add(reinoHeton);
           grupos.add(desdunia);
           grupos.add(magosApocalipse);
                                
           Personagem algra = new Personagem("Algra", "Paladino", 8);
           Personagem perseus = new Personagem("Perseus", "Ladino", 8);
           Personagem olich = new Personagem("Olich", "Bardo", 8);
           
           personagens.add(algra);
           personagens.add(perseus);
           personagens.add(olich);
           
           coracaoPrata.adicionarMembro(algra);
           coracaoPrata.adicionarMembro(perseus);
           coracaoPrata.adicionarMembro(olich);
                    
           
           
           /*           TESTE APENAS           */
           
           
           System.out.println("Bem vindo ao SistemaRPG");
           try { Thread.sleep(300); } catch (InterruptedException e) {Thread.currentThread().interrupt();}
           System.out.println("--------------------------");
           
           int menu;
                      
           do {
           System.out.println("O que gostaria de fazer? digite o número da opção");
               System.out.println("");
           System.out.println("1 - Cadastrar um personagem");
           System.out.println("2 - Listar todos os personagens");
           System.out.println("3 - Listar todos os grupos");
           System.out.println("4 - Atualizar personagem");
           System.out.println("0 - Sair");
           
           
           if (scan0.hasNextInt()) {
           menu = scan0.nextInt();
           scan0.nextLine();
                      
          
           // opção 1 do menu
           if (menu == 1) {
           
               int z = 0;
               int nivel = 1;
               
               System.out.println("-----------------------");
               System.out.println("");
               System.out.println("Vamos cadastrar");
               try { Thread.sleep(300); } catch (InterruptedException e) {Thread.currentThread().interrupt();}
               System.out.println("");
               

           System.out.println("Digite o nome do personagem");
           String nome = scan0.nextLine();
           System.out.println("Qual a classe do personagem?");
           String classe = scan0.nextLine();
           
           do {
               
           System.out.println("Qual o nível do personagem?");
           
           if (scan0.hasNextInt()) {
           
           nivel = scan0.nextInt();
           scan0.nextLine();
           
           if (nivel >= 1 && nivel <=20) {
           z++; } else { System.out.println("O nível do personagem deve estar entre 1 e 20");}
           
           } else { scan0.nextLine(); System.out.println("Por favor, digite apenas números para o nível."); System.out.println("----------------------------------------------");}
           
           
           } while (z == 0);
           
               System.out.println("Este personagem pertence a qual grupo?");
               
                    for (Grupo grupo : grupos) {
                    grupo.apresentarResumo();}
               
               System.out.println("Digite o ID do grupo desejado ou 0 para nenhum grupo;");
               int pgrupo = scan0.nextInt();
                      
               
               System.out.println("");    
               System.out.println("Confirme se as informações estão corretas:");
               System.out.print(nome + ", " + classe + " Nível " + nivel);
                        if (pgrupo !=0 ) {
                            System.out.print(", " + "Membro do Grupo ");
                             for (Grupo grupo : grupos) {
                                if (grupo.idgr == pgrupo) {
                                    System.out.println(grupo.nome);
                                }
                             }
                        } else {System.out.println("");}
                        
                System.out.println("---------------------");
                System.out.println("Cadastar personagem assim?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int cadastro = scan0.nextInt();
                
                if (cadastro == 2) {
                    System.out.println("------------------------------");
                    System.out.println("Vamos refazer seu personagem");
                    System.out.println("-------------------------------");
                    System.out.println("");
                } else {
                
               
           Personagem nomePersonagem = new Personagem(nome, classe, nivel);
           personagens.add(nomePersonagem);
           
           if (pgrupo != 0) {             
               for (Grupo grupo : grupos) {
                   if (grupo.idgr == pgrupo) {
                       grupo.adicionarMembro(nomePersonagem);
                   }
               }               
           }           
           
           
           //Personagem criado com sucesso

               System.out.println("");
               System.out.println("Personagem cadastrado:");
               System.out.println("");
               nomePersonagem.apresentar();
               System.out.println("");
               System.out.println("------------------------------------------");
           
           }
           }
           
           //Opção 2 do menu
           
           else if (menu ==2) {
               
               System.out.println("");
               if (personagens.isEmpty()) {
               
               System.out.println("");
              System.out.println("Ainda não há nenhum personagem cadastrado!");
               System.out.println("");
               
           } else {
                   
                   for (Personagem personagem : personagens) {
                       personagem.apresentar();
                       System.out.println("--------------------------------");
                   }
           }
           }
           
           //Opção 3 do menu
           
           else if (menu ==3 ) {
               
               int opcaoGrupo;
                              
               do {
               
               System.out.println("---GRUPOS---");
               System.out.println("1 - Listar todos os grupos");
               System.out.println("2 - Consultar um grupo");
               System.out.println("0 - Voltar ao menu principal");
               System.out.println("");
               
               opcaoGrupo = scan0.nextInt();
               scan0.nextLine();
               
               if (opcaoGrupo == 1) {
                   
                   for (Grupo grupo : grupos) {
                       grupo.apresentarResumo();
                   }
                   
               }
               
               if (opcaoGrupo == 2) {
                   System.out.println("Digite o ID do grupo que quer consultar");
                   int a = scan0.nextInt();
                   
                   boolean encontrou = false;
                   
                    for (Grupo grupo : grupos) {
                       if (grupo.idgr ==  a) {
                           grupo.apresentar();
                           encontrou = true;
                       } 
                   }    
                    if (encontrou == false) {
                        System.out.println("Nenhum grupo encontrado com esse ID\n"); 
                    }
                                    
               }               
               
               } while (opcaoGrupo !=0);
           
           //Opção 4 do menu
                   
           } else if (menu== 4) {
               System.out.println("---------------------------------------");
               System.out.println("");
                   System.out.println("ainda em desenvolvimento!");
                   System.out.println("");
               System.out.println("---------------------------------------");                   
                   }
           
          
           } else {
                   scan0.nextLine();
                   System.out.println("Inválido");
                   System.out.println("-----------");
                   scan0.nextLine();
                   menu = 9;
           }
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
               
           } while (menu != 0);
           
           System.out.println("Desligando sistema");
          
           
       }
       
}
    

