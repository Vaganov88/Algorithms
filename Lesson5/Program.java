public class Program {

    public static void honoiRec(int count, int from, int to, int helper) {
        if (count == 1) {
            System.out.println(from + "->" + to);
        } else {
            honoiRec(count - 1, from, helper, to);
            System.out.println(from + "->" + to);
            honoiRec(count - 1, helper, to, from);
        }
    }
    ////////////////////////////////////////////////

    public static int powSlow(int a, int n) {
        int product = 1;
        while (n > 0) {
            product *= a;
            n--;

        }
        System.out.println(product);
        return product;
    }

    /////////////////////////////////////////////////

    public static int powFast(int a, int n) {
        int product = 1;
        while (n > 0) {
            if (n % 2 > 0) {
                product *= a;
                n--;
            } else {
                a *= a;
                n /= 2;

            }
        }
            System.out.println(product);
            return product;

        }

        /////////////////////////////////////////////////////


        public static int powRec (int a, int n){
            if (n == 0) {
                return 1;
            }
            if (n % 2 > 0) {
                return a * powRec (a, n - 1);
            }
            else {
                return powRec (a * a, n / 2);
            }

        }

    public static void main(String[] args) {
        honoiRec(3, 1, 3, 2);
        powSlow (2, 10);
        powFast(2, 12);
        System.out.println(powRec(2, 8));
    }
}

