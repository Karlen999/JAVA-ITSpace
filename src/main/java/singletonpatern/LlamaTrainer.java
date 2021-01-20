package singletonpatern;

public class LlamaTrainer {
    public boolean feedLlamas(int numberOfLlamas) {
        int amountNeeded = 5 * numberOfLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getHayQuantity()<amountNeeded){
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(30);
        if (fed){
            System.out.println("Llamas have been fed");
        }
        return fed;
    }

    public static void main(String[] args) {
        LlamaTrainer trainer = new LlamaTrainer();
        trainer.feedLlamas(5);
    }
}
