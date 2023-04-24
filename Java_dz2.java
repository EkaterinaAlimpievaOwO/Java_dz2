import java.util.Scanner;

public class Java_dz2 {
    public static void main(String[] args) {
        // Exercise1();
        // Exercise2();
        Exercise3();
    }

    // ------------------------------------------------------------------
    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”

    static void Exercise1() {
        Java_dz2 task = new Java_dz2();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter jewels: ");
        String jewels = scanner.nextLine();
        System.out.print("Enter stones: ");
        String stones = scanner.nextLine();
        System.out.println(task.findJewelsInStones(jewels, stones));
        scanner.close();
    }

    public String findJewelsInStones(String jewels, String stones) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < jewels.length(); i++) {
            int count = 0;
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
            if (count > 0) {
                result.append(jewels.charAt(i)).append(count);
            }
        }
        return result.toString();
    }

    // ------------------------------------------------------------------
    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей
    // строке.
    static void Exercise2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String s = scanner.nextLine();
        int[] index = new int[s.length()];
        System.out.println("Введите новый порядок(от 1):");
        for (int i = 0; i < s.length(); i++) {
            System.out.print("[" + i + "]: ");
            index[i] = scanner.nextInt();
        }
        scanner.close();
        String result = shuffle(s, index);
        System.out.println("Результат: " + result);
    }

    public static String shuffle(final String s, final int[] index) {
        char[] shuffled = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int idx = index[i] - 1;
            shuffled[idx] = s.charAt(i);
        }
        return new String(shuffled);
    }

    // ------------------------------------------------------------------
    // На первой строке записывается натуральное число n - количество строчек в
    // книге.
    // Затем вводится n строк - строки книги. потом вводится натуральное число m -
    // количество продуктов,
    // на которые у человека аллергия. Потом вводится m строк - вида "продукт1 -
    // продукт2",
    // где продукт1 - продукт, на который у человека аллергия и продукт2 - продукт,
    // на который следует заменить продукт1. Гарантируется что любой продукт состоит
    // из 1 слова.
    // название продуктов написаны строчными буквами.
    // Гарантируется, что продукты, на которые нужно выполнить замену,не встречаются
    // изначально в тексте.
    // Выходные данные
    // Замените все продукты в поваренной книге Васи и выведите их построчно на
    // экран.
    // На окончания не обращайте внимание. ВАЖНО!!! Если продукт, который следует
    // заменить написан с большой буквы,
    // то и замена тоже должна начинаться с большой буквы!

    static void Exercise3() {
        System.out.print("Введите количество строк в книге: ");
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int n = scanner.nextInt();
        scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку книги: ");
            String line = scanner.nextLine();
            sb.append(line).append("\n");
        }
        String book = sb.toString();

        System.out.print("Введите количество продуктов, на которые у человека аллергия: ");
        int m = scanner.nextInt();
        scanner.nextLine();

        String[] allergies = new String[m];
        String[] replacements = new String[m];
        for (int i = 0; i < m; i++) {
            System.out.print(
                    "Введите продукт, на который у человека аллергия, и продукт, на который его следует заменить через дефис: ");
            String[] parts = scanner.nextLine().split("-");
            allergies[i] = parts[0].trim();
            replacements[i] = parts[1].trim();
        }

        for (int i = 0; i < m; i++) {
            book = book.replace(allergies[i], replacements[i]);
            book = book.replace(capitalize(allergies[i]), capitalize(replacements[i]));
        }

        System.out.println(book);
        scanner.close();
    }

    static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    // К сожалению не смогла разобраться с кодировкой, поэтому на русском результат
    // некорректный.
    // На английском всё работает
    // Пример для теста:

    // 2
    // Recipe 1. Peanuts 100g, ice cream 200g. Take a peanut and grind it.
    // Sprinklecrushed peanuts over ice cream.
    // Recipe 2. Strawberries 100g, condensedmilk 3kg. Mix, eat) Enjoy life.
    // 3
    // peanut - sausage
    // strawberry - cherry
    // condensedmilk - milk

    // ------------------------------------------------------------------
}