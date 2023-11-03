import java.util.Arrays;

public class Main {
// в main идет общение непосредственно с пользователем, поэтому в отсальных классах сканнер не используем

    public static void main(String[] args) {
        AccountManager manager = new AccountManager(5);

        manager.addAccount("Еда");
        manager.addAccount("Спорт");
        manager.addAccount("Образование");

        manager.addSpending("Еда", 6000);
        manager.addSpending("Спорт", 2000);
        manager.addSpending("Еда", 800);
        manager.addSpending("Образование", 500);


//        System.out.println(Arrays.toString(manager.accounts));

        System.out.println("Всего трат: " + manager.sumSpending());
        System.out.println("Категория с максимальной тратой: " + manager.maxAccount());



    }
}
