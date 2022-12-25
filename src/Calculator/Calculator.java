package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
Converter converter = new Converter();
String[] actions = {"+", "-", "/", "*"};
String[] regexAction = {"\\+", "-", "/", "\\*"};
Scanner scn = new Scanner(System.in);
System.out.print("Введите выражение: ");
String exp = scn.nextLine();
// определяем арифметическое действие:
int actionIndex = -1;
for(int i = 0; i<actions.length; i++){
    if(exp.contains(actions[i])){
        actionIndex = i;
        break;
    }
}
// если не нашли арифметическое действие
if(actionIndex==-1){
    System.out.print("Некорректное выражение");
    return;
}
// делим строчку по арифметическому знаку
String[] data = exp.split(regexAction[actionIndex]);
// определяем находятся ли числа в одном формате
if(converter.isRoman(data[0]) == converter.isRoman(data[1])) {
    int a, b;
    // определяем римские ли это числа
    boolean isRoman = converter.isRoman(data[0]);
    if (isRoman) {
        // если римские, то конвертируем в арабские
        a = converter.romanToInt(data[0]);
        b = converter.romanToInt(data[1]);
    } else {
// если арабские, то конвертируем их из строки в число
        a = Integer.parseInt(data[0]);
        b = Integer.parseInt(data[1]);
    }
    int result;
    // выполняем с числами арифметическое действие
    switch (actions[actionIndex]) {
        case "+":
            result = a + b;
            break;
        case "-":
            result = a - b;
            break;
        case "*":
            result = a * b;
            break;
        default:
            result = a / b;
            break;
    }
    if (isRoman) {
        //если оба числа римские, возвращаем результат в римском числе
        System.out.println(converter.intToRoman(result));

    } else {
        //если числа арабские, возвращаем резуьтат в арабском числе
        System.out.println(result);
    }
}else{
    System.out.println("Числа должны быть в одном формате");
}
    }
}

