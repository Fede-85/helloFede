import java.util.ArrayList;
import java.util.List;

public class Knapsac {
        public Knapsac() {
                this.elementi = new ArrayList<Elemento>();
                maxWeight = 15;
                pesoAttuale = 0;
                valore = 0;
        }

        List<Elemento> elementi;
        int maxWeight;
        int pesoAttuale;
        int valore;

        public void addElemento(Elemento e){
                elementi.add(e);
                pesoAttuale+= e.peso;
                valore+=e.valore;
        }

        public void removeElemento(Elemento e){
                elementi.remove(e);
                pesoAttuale-=e.peso;
                valore-=e.valore;
        }

        @Override public String toString() {
                return "Knapsac{" + "elementi=" + elementi + ", maxWeight=" + maxWeight + ", valore=" + valore + '}';
        }

        public static void riempiZaino(int indice, List<Elemento> elementi, Knapsac knapsac, Knapsac knapsacTest){
                // tutti gli elementi entrano nello zaino
                if ((knapsac.pesoAttuale <= knapsac.maxWeight) && (indice == elementi.size()) && knapsac.valore < knapsacTest.valore) {
                        System.out.println("---------------------------------------------------------------------------------------------------------------");
                        System.out.println("found a solution better than before - valore before: " + knapsac.valore + " valore nuovo: " + knapsacTest.valore);
                        knapsac = new Knapsac();
                        for (int i = 0; i < elementi.size(); i++){
                                System.out.println("Elemento " + (i+1) + elementi.get(i));
                                knapsac.addElemento(elementi.get(i));
                        }
                        System.out.println("---------------------------------------------------------------------------------------------------------------");
                        return;
                }

                for (int i = indice; i < elementi.size(); i++){
                        knapsacTest.addElemento(elementi.get(i));
                        riempiZaino(indice+1,elementi,knapsac, knapsacTest);
                        knapsacTest.removeElemento(elementi.get(i));
                }
        }

        public static void main(String [] args){
                Knapsac knapsac = new Knapsac();
                Knapsac knapsacTest = new Knapsac();
                Elemento e1 = new Elemento(1,5);
                Elemento e2 = new Elemento(10, 3);
                Elemento e3 = new Elemento(7, 4);
                List<Elemento> listElementi = new ArrayList<>();
                listElementi.add(e1);
                listElementi.add(e2);
                listElementi.add(e3);
                Knapsac.riempiZaino(0,listElementi,knapsac, knapsacTest);
                System.out.print(knapsac);
        }
}
