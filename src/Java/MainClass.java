
public class MainClass {
    public static void main(String[] args){
        System.out.println("Создаем справочник");
        Phonebook phonebook = new Phonebook();
        System.out.println("-----------------");

        System.out.println("Наполняем справочник");
        phonebook.add("Акинфеев", "223344");
        phonebook.add("Акинфеев", "22334411");
        phonebook.add("Аршавин", "22334499");
        phonebook.add("Дзюба", "22334488");
        phonebook.add("Акинфеев", "22334422");
        System.out.println("-----------------");

        System.out.println("Получаем номера");
        System.out.println("Акинфеев");
        System.out.println(phonebook.get("Акинфеев"));
        System.out.println("Аршавин");
        System.out.println(phonebook.get("Аршавин"));
        System.out.println("Дзюба");
        System.out.println(phonebook.get("Дзюба"));
        System.out.println("-----------------");

        System.out.println("Случай отсутствия записи");
        System.out.println("Головин");
        System.out.println(phonebook.get("Головин"));
        System.out.println("-----------------");

        System.out.println("Пробуем записать существующий номер");
        phonebook.add("Фернандес", "223344");
        System.out.println("Фернандес");
        System.out.println(phonebook.get("Фернандес"));
    }
}