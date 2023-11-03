import java.util.Objects;

public class AccountManager {
    // по-сути менеджер трат - набор конкретных категорий вместе с тратами. То есть храним  и траты, и категории, поэтому выбираем массив с объектами
    // должно быть добавление нового аккаунта. Покупка новой категории. Менеджер должен уметь добавлять в ту категорию, которая добавлена.
    // Нельзя добавлять трату, если нет категории. Добавление нескольких трат + суммирование трат. Поиск max траты

    public Account[] accounts; // добавляем поле // при инициализации экземпляра AccountManager создается сразу массив Account, который показывет количество трат

    AccountManager(int maxAccounts) { // это конструктор, при создании указываем max количество аккаунтов (категории трат); важный момент - в параметрах конструктора - в круглых скобках указываем произвольные переменные, которые связываем с базовыми свойствами класса
       accounts = new Account[maxAccounts];

    }

    public void addAccount(String accountTitle) {
        Account account = new Account(accountTitle); // в момент добавления категории траты создаем объект внутри каждой траты, то есть получаем, что у нас массив объектов, где каждый объект - экземпляр класса Account и хранит 2 поля - title и amount

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account; // добавляем в массив эту созданную локальную переменную account в массив accounts
                return; // чтобы не заполнялись все остальные ячейки, а было только первое добавление
            }
        }
    }

    public void addSpending(String accountTitle, int amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (Objects.equals(accountTitle, accounts[i].title)) { // accounts[i] - это наш объект с двумя полями, соответственно поле объекта - accounts[i].title
                accounts[i].amount += amount;
                return;
            }
        }
    }

     public int sumSpending() { // думать во время проектирования нужны ли параметры или нет, подумать, нужны ли эти параметры
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) { // если ячейка null - будет исключение
                sum = sum + accounts[i].amount;
            }
        }
        return sum;
     }

     public String maxAccount() {
//         int expense = 0;
//         String maxAccount = null;
         int maxi = 0; // создаем переменную, где будем хранить индекс элемента перебираемого массива
         for (int i = 0; i < accounts.length; i++) {
             if (accounts[i] != null) {
//                 if (accounts[i].amount > expense) { // хороший, промышленный способ, но требует сразу двух переменных, что может
//                     expense = accounts[i].amount; // вызвать потом ошибки в работе, больше информации для хранения в голове
//                     maxAccount = accounts[i].title;
                 if (accounts[i].amount > accounts[maxi].amount) { // если элемент под индексом maxi меньше, делаем maxi = этмоу элементу
                    maxi = i;
                 }
             }
         }
         return accounts[maxi].title;
     }
}
