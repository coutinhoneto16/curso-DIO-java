public class Carro {
    private int velocidade = 0;
    private int marcha = 0;
    private boolean ligado;
    private final int velocidadeMax = 120;
    private final int velocidadeMin = 0;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public void ligarCarro(){
        if(!ligado){
            ligado = true;
            System.out.println("Carro ligado!");
        }
    }

    public void desligarCarro(){
        if(ligado && marcha == 0){
            ligado = false;
            System.out.println("Carro desligado!");
        }else{
            System.out.println("Coloque o carro em ponto morto e zere a velocidade para desligar o carro!");
        }
    }

    public void acelerarCarro(){
        if(ligado){

            if(marcha == 0){
                System.out.println("Não é possível acelerar em ponto morto");
                return;
            }

            if(velocidade < velocidadeMax && podeAcelerarNaMarcha()){
                velocidade ++;
                System.out.println("Acelerando :" + velocidade + " km/h");

            }else{
                System.out.println("Velocidade máxima na marcha atingida!");
            }
        }

    }

    public void desacelerarCarro(){
        if(ligado){
            if(velocidade > velocidadeMin){
                velocidade--;
                System.out.println("Desacelerando :" + velocidade + " km/h");
            }else{
                System.out.println("Carro já está parado!");
            }
        }
    }

    public void verificarVelocidade(){
        if(ligado){
            System.out.println("Velocidade atual: " + velocidade + " km/h");;
        }else{
            System.out.println("Carro desligado");
        }
    }

    public void passarMarcha(int novaMarcha){
        if(ligado){
            if(novaMarcha == marcha + 1 || novaMarcha == marcha - 1){
                if(podeTrocarMarcha(novaMarcha)){
                    marcha = novaMarcha;
                    System.out.println("Marcha trocada para " + marcha);
                }else{
                    System.out.println("Velocidade Incompatível com a marcha!");
                }
            }else{
                System.out.println("Não pode pular marcha!");
            }
        }
    }

    private boolean podeAcelerarNaMarcha(){
        switch(marcha){
            case 1: return velocidade < 20;
            case 2: return velocidade < 40;
            case 3: return velocidade < 60;
            case 4: return velocidade < 80;
            case 5: return velocidade < 100;
            case 6: return velocidade < 120;
            default: return false;
        }
    }

    private boolean podeTrocarMarcha(int novaMarcha){
        switch (novaMarcha){
            case 0: return velocidade == 0; // ponto morto só pode em 0 km
            case 1: return velocidade >= 0 && velocidade <= 20;
            case 2: return velocidade >= 20 && velocidade <= 40;
            case 3: return velocidade >= 40 && velocidade <= 60;
            case 4: return velocidade >= 60 && velocidade <= 80;
            case 5: return velocidade >= 80 && velocidade <= 100;
            case 6: return velocidade >= 100 && velocidade <= 120;
            default: return false;
        }
    }

    public void virarCarro(String lado){
        if(ligado){
            if(velocidade > 1 && velocidade <= 40){
                System.out.println("Virando a " +lado);
            }else{
                System.out.println("Impossivel virar a " +lado + " nessa velocidade");
            }
        }
    }

    public void virarEsquerda(){
        virarCarro("esquerda");
    }

    public void virarDireita(){
        virarCarro("direita");
    }
}


