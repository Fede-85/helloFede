import java.util.Objects;
import java.util.Random;

public class Elemento {
        int peso;
        int valore;
        int id;

        public Elemento(int peso, int valore) {

                Random rand = new Random();
                this.peso = peso;
                this.valore = valore;
                id = (int)Math.random()* 5000000;
        }

        public int getPeso() {
                return peso;
        }

        public int getValore() {
                return valore;
        }

        public int getId() {
                return id;
        }

        @Override public boolean equals(Object o) {
                if (this == o)
                        return true;
                if (o == null || getClass() != o.getClass())
                        return false;
                Elemento elemento = (Elemento) o;
                return peso == elemento.peso && valore == elemento.valore && id == elemento.id;
        }

        @Override public int hashCode() {
                return Objects.hash(peso, valore, id);
        }

        @Override public String toString() {
                return "Elemento{" + "peso=" + peso + ", valore=" + valore + '}';
        }
}
