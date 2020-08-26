package Algorithms;

public class HillCipher {
    private int[][] encryptionKey = new int[100][100];
    private int[][] decryptionKey = new int[100][100];
    private int N;
    public HillCipher(){

    }
    public HillCipher(int key[][], int n){
        this.encryptionKey = key;
        this.N = n;
    }

    public void getEncryptionKay(int key[][], int n){
        this.encryptionKey = key;
        this.N = n;
    }
    public int[][] getDecryptionKey(int key[][]){
        inverse(key, decryptionKey);
        return null;
    }
    private void getCofactor(int A[][], int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public int determinant(int A[][], int n)
    {
        int D = 0;
        if (n == 1)
            return A[0][0];
        int [][]temp = new int[N][N];
        int sign = 1;
        for (int f = 0; f < n; f++)
        {
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return D;
    }
    public void adjoint(int A[][],int [][]adj)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }
        int sign = 1;
        int [][]temp = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                getCofactor(A, temp, i, j, N);
                sign = ((i + j) % 2 == 0)? 1: -1;
                adj[j][i] = (sign)*(determinant(temp, N-1));
            }
        }
    }
    public boolean inverse(int A[][], int[][] inverse)
    {
        int det = determinant(A, N);
        if (det == 0)
        {
            System.out.print("Singular matrix, can't find its inverse");
            return false;
        }
        int [][]adj = new int[N][N];
        adjoint(A, adj);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                inverse[i][j] = (adj[i][j]/det) % 26;

        return true;
    }
}
