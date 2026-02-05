public class ListaDupla {
    private Node inicio;
    private Node fim;

    public void adicionar(String palavra) {
        Node novo = new Node(palavra);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public Node getInicio() {
        return inicio;
    }

    public int tamanho() {
        int cont = 0;
        Node atual = inicio;
        while (atual != null) {
            cont++;
            atual = atual.proximo;
        }
        return cont;
    }

    //Retorna palavra de um certo índice
    public String obter(int indice) {
        int i = 0;
        Node atual = inicio;
        while (atual != null) {
            if (i == indice) {
                return atual.palavra;
            }
            atual = atual.proximo;
            i++;
        }
        return null; //indice inválido

    }
}
