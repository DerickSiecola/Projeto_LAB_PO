import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    public void escreverArquivo(Jogador jog){
        // Importando as classes que nos permitirão escrever no Arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;


        try {
            // Recebe o nome do meu arquivo
            os = new FileOutputStream("Jogadores.txt",true);

            // Mostra em qual arquivo estaremos escrevendo
            osw = new OutputStreamWriter(os);

            // Permite que escrevamos no arquivo
            bw = new BufferedWriter(osw);

            // Efetivamente escrevendo no arquivo
            bw.write("++ Dados do atleta: ++\n");
            bw.write(jog.getNome()+"\n");
            bw.write(jog.getClube()+"\n");
            bw.write(jog.getSalario()+"\n");
            bw.write(jog.getValor()+"\n");
            bw.write(jog.getIdade()+"\n");
            bw.write(jog.getPosicao()+"\n");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public ArrayList<Jogador> lerArquivos(){
        // Criando array list que armazena os jogadores encontrados no arquivo
        ArrayList<Jogador> encontreiNoArquivo = new ArrayList<>();

        // Estruturas que servirão para a leitura dos dados
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer; // Auxiliar que servirá como ponteiro para ler o arquivo

        try{
            is = new FileInputStream("Jogadores.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);


            // Posicionando o cursor no inicio do Arquivo
            linhaLer = br.readLine();

            // Verificando e rodando o código enquanto tiver informações no txt
            while(linhaLer!=null){
                // Verificando se já estamos na estrutura de um jogador
                if(linhaLer.contains("++ Dados do atleta: ++")){

                    // Preenchendo as informações do jogador
                    String nome = br.readLine();
                    String clube = br.readLine();
                    double salario = Double.parseDouble(br.readLine());
                    double valor = Double.parseDouble(br.readLine());
                    int idade = Integer.parseInt(br.readLine());
                    String posicao = br.readLine();

                    // Criando um objeto auxiliar de jogador
                    Jogador auxFuncionario = new Jogador(nome,clube,salario,valor,idade,posicao);

                    // Adicionando o jogador ao arrayList, para informar que encontrei o jogador
                    encontreiNoArquivo.add(auxFuncionario);
                }
                // Passando para a próxima linha
                linhaLer = br.readLine();
            }
        }catch (Exception e){

        }
        return encontreiNoArquivo;
    }
    public void atualizarArquivo(ArrayList<Jogador> jogadores) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Jogadores.txt"))) {
            for (Jogador jogador : jogadores) {
                pw.println("++ Dados do atleta: ++");
                pw.println(jogador.getNome());
                pw.println(jogador.getClube());
                pw.println(jogador.getSalario());
                pw.println(jogador.getValor());
                pw.println(jogador.getIdade());
                pw.println(jogador.getPosicao());
            }
            System.out.println("Arquivo atualizado com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo.");
        }
    }
}