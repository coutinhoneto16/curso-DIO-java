public class PetShop {
    private int shampoo;
    private int agua;
    private int maxAgua = 30;
    private int maxShampoo = 10;
    boolean ocupado = false;
    boolean limpo = true;
    boolean petLimpo = false;


    public PetShop(int agua, int shampoo) {
        this.agua = agua;
        this.shampoo = shampoo;
    }

    public void colocarPet(){
        if(ocupado){
            System.out.println("Já tem pet na máquina!");
        }else if(!limpo){
            System.out.println("A máquina está suja e precisa ser lavada antes de dar banho em outro pet!");
        }else{
            ocupado = true;
            petLimpo = false;
            System.out.println("Pet colocado na máquina!");
        }
    }

    public void retirarPet(){
        if(!ocupado) {
            System.out.println("Não há pet na máquina!");
        }else if(!petLimpo) {
            System.out.println("O pet não foi limpo e a máquina precisa de limpeza!");
            limpo = false;
            ocupado = false;
        }else{
            System.out.println("Pet retirado e limpo!");
            ocupado = false;
        }
    }

    public void limparMaquina(){
        if (agua >= 3 && shampoo >= 1){
            agua -= 3;
            shampoo -= 1;
            limpo = true;
            System.out.println("Máquina limpa com sucesso!");
        }else{
            System.out.println("Recursos insuficientes para limpar máquina!");
        }

    }

    public void darBanho(){
        if(!ocupado) {
            System.out.println("Não há pet na máquina para banho!");
        }else if(!verificaAgua() || !verificaShampoo()){
            System.out.println("Recursos insuficientes para banho!");
        }else{
            agua -= 10;
            shampoo -= 2;
            petLimpo = true;
            limpo  = true;
            System.out.println("Banho dado com sucesso! O pet está limpo");
        }
    }

    public void abastecerAgua(){
        if (agua <= (maxAgua - 2)){
            agua += 2;
            System.out.println("Máquina abastecida com 2L de água. Nível atual de água: " + agua);
        }else{
            System.out.println("Não cabe mais água na máquina!");
        }
    }

    public void abastecerShampoo(){
        if (shampoo <= (maxShampoo - 2)){
            shampoo += 2;
            System.out.println("Máquina abastecida com 2L de shampoo. Nivel atual de shampoo: " + shampoo);
        }else{
            System.out.println("Não cabe mais shampoo na máquina!");
        }
    }

    public boolean verificaAgua(){
        return agua >= 10;
    }

    public boolean verificaShampoo(){
        return shampoo >= 2;
    }
}
