public class Node {
    String palavra;
    Node proximo;
    Node anterior;

    Node(String palavra) {
        this.palavra = palavra;
        this.proximo = null;
        this.anterior = null;
    }
}
