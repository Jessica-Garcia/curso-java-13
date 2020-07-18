package collections.teoria.modelo;

public class Celular {
    private String nome;
    private String IMEI;

    public Celular(String nome, String IMEI) {
        this.nome = nome;
        this.IMEI = IMEI;
    }


    @Override
    public boolean equals (Object obj){
        // verificar se o objeto que foi passado é nulo, se for retorna false:
        if(obj == null) return false;

        //Verificar se as referências são iguais, se estão no mesmo endereço de memória, se iguais retornar true
        if(this == obj) return true;

        // verificar se o objeto que estou passando é do tipo da classe que quero comparar
        if(this.getClass() != obj.getClass()) return false;

        //após esses passos pode-se fazer o cast com segurança
        Celular outroCelular = (Celular) obj;

        //por fim retorna o critério de igualdade
        return IMEI != null && IMEI.equals(outroCelular.getIMEI());

    }

    @Override
    public int hashCode(){
        return IMEI != null ? IMEI.hashCode() : 1;
    }


    @Override
    public String toString() {
        return "Celular{" +
                "nome='" + nome + '\'' +
                ", IMEI='" + IMEI + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
