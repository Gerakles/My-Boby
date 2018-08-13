package JavaRush.example;

public class Matrice {
    public static void main(String[] args) {
        int Nx = 9, Ny = 6;
        int[][] m = new int[Nx][Ny];

        for (int d = 1, r = 1, x = -1, y = 0, b = Nx; 1 <= (d % 2 == 0 ? Nx-- : Ny--); b += d++ % 2 == 0 ? Nx : Ny)
            while (r <= b) m[x -= (d % 4 - 2) % 2][y += (d % 4 - 1) % 2] = r++;

//проверка
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print( m[i][j] + " " );
            }
        }
    }
}