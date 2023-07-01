import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TaskMenedger {
    List<Taskk> tasks = new ArrayList<>(); //Лист хранящий в себе все заддачи
    Scanner scanner = new Scanner(System.in);

    public void createTask() {//Метод для создания задачи   
        System.out.println("=== Создание задачи ===");
        System.out.print("Введите название задачи: ");
        String name = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String option = scanner.nextLine();
        System.out.print("Введите дату выполнения задачи: ");
        String date = scanner.nextLine();
        System.out.print("Введите приоритет задачи: ");
        int priority = scanner.nextInt();

        Taskk task = new Taskk(name, option, date, priority);
        tasks.add(task);
    }

    public void viewAllTasks() {//Метод для просмотра всех задач
        System.out.println("=== Список задач ===");
        for(int i = 0; i < this.tasks.size(); ++i) {
            Taskk task = (Taskk)this.tasks.get(i);
            System.out.println(i + 1 + ". " + task.getName());
            System.out.println("   Описание: " + task.getOptions());
            System.out.println("   Дата выполнения: " + task.getDate());
            System.out.println("   Приоритет: " + task.getPriority());
            System.out.println("   Статус: " + task.getStatus());
            System.out.println("------------------------------");
        }
    }

    public void editTasks() {//Метод для редактирования задачи
        System.out.println("=== Редактирование задач ===");
        System.out.println("Введите номер задчи");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();

        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Taskk task = tasks.get(taskIndex - 1);
            System.out.print("Введите новое название задачи: ");
            String name = scanner.nextLine();
            System.out.print("Введите новое описание задачи: ");
            String option = scanner.nextLine();
            System.out.print("Введите новую дату выполнения задачи: ");
            String date = scanner.nextLine();
            System.out.print("Введите новый приоритет задачи: ");
            int priority = scanner.nextInt();
            scanner.nextLine();

            task.setName(name);
            task.setOptions(option);
            task.setDate(date);
            task.setPriority(priority);

            System.out.println("Задача успешно изменена");
        } else {
            System.out.println("Введён некооректный номер");
        }
    }

    public void deleteTask() {//Метод для удаления задачи
        System.out.println("=== Удаление задачи ===");
        System.out.print("Введите номер задачи для удаления: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Taskk task = tasks.remove(taskIndex - 1);
            System.out.println("Задача успешно удалена: " + task);
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }

    public void otmtitTaskVipoleno() {//Метод для отметки задч как выполненую
        System.out.println("=== Отметить задачу как выполненную ===");
        System.out.print("Введите номер задачи для отметки: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();

        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Taskk task = tasks.get(taskIndex - 1);
            task.setStatus("Задача выполнена");
            System.out.println("Задача успешно отмечена как выполненная.");
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }

    public void sortTask() {//Метод для сортировки задач
        System.out.println("=== Сортировка задач ===");
        System.out.println("1. Сортировать по дате выполнения");
        System.out.println("2. Сортировать по приоритету");
        System.out.print("Выберите опцию: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа
        try {
            switch (choice) {
                case 1:
                    sortByDueDate();
                    break;
                case 2:
                    sortByPriority();
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Пожалуйста, введите число.");
            scanner.nextLine();
        }
    }

    private void sortByDueDate() {//Метод для сортировки по дате выполнения
        tasks.sort((task1, task2) -> task1.getDate().compareTo(task2.getDate()));

        System.out.println("=== Отсортированный список задач по дате выполнения ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void sortByPriority() {//Метод для сортировки по приоритету
        tasks.sort((task1, task2) -> task2.getPriority() - task1.getPriority());

        System.out.println("=== Отсортированный список задач по приоритету ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void displayMenu() {//Меню
        System.out.println("=== Task Manager ===");
        System.out.println("1. Создать задачу");
        System.out.println("2. Просмотреть все задачи");
        System.out.println("3. Редактировать задачу");
        System.out.println("4. Удалить задачу");
        System.out.println("5. Отметить задачу как выполненную");
        System.out.println("6. Сортировать задачи");
        System.out.println("7. Выход");
        System.out.print("Выберите опцию: ");
    }

    public void run() {//Метод для запуска программы
        int choice;
        do {
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createTask();
                        break;
                    case 2:
                        viewAllTasks();
                        break;
                    case 3:
                        editTasks();
                        break;
                    case 4:
                        deleteTask();
                        break;
                    case 5:
                        otmtitTaskVipoleno();
                        break;
                    case 6:
                        sortTask();
                        break;
                    case 7:
                        System.out.println("Выход");
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Введите числовое значение.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 7);
    }
}